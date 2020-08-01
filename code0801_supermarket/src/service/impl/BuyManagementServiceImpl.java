package service.impl;

import dao.impl.GoodsInfoImpl;
import dao.impl.OrderDetailImpl;
import dao.impl.OrderInfoImpl;
import dao.impl.VipInfoImpl;
import entity.ShoppingCart;
import service.BuyManagementService;
import util.DbUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 20:30
 */
public class BuyManagementServiceImpl implements BuyManagementService {

    public BuyManagementServiceImpl() {
    }

    ArrayList<ShoppingCart> shoppingCarts = new ArrayList<>();

    /**
     * 查看商品库存
     * @param goodsId
     * @return
     */
    public Map<String, Object> selectStock(int goodsId) {
        Map<String, Object> map = null;
        try {
            map = new GoodsInfoImpl().selectOne(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public boolean add(int goodsId, int count) {
        boolean flag = false;
        Map<String, Object> map = null;
        try {
            map = new GoodsInfoImpl().selectOne(goodsId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (ShoppingCart cart : shoppingCarts) {
            if (cart.getGoodsId()==goodsId) {
                cart.setCount(cart.getCount() + count);
                cart.setTotalPrice(new BigDecimal(cart.getUnitPrice() * cart.getCount()));
                flag = true;
                break;
            }
        }

        if (!flag) {
            String goodsName = (String) map.get("goodsname");
            float unitPrice = (float) map.get("unitprice");
            float discount = (float) map.get("discount");
            BigDecimal totalPrice = new BigDecimal(unitPrice * count * discount / 10);
            ShoppingCart shoppingCart = new ShoppingCart(goodsId,goodsName,unitPrice,count,discount,totalPrice);
            return shoppingCarts.add(shoppingCart);
        } else {
            return flag;
        }
    }

    @Override
    public int edit(int goodsId,int newCount) {
        int num = 0;
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart.getGoodsId() == goodsId) {
                shoppingCart.setCount(newCount);
                shoppingCart.setTotalPrice(new BigDecimal(shoppingCart.getUnitPrice() * newCount));
                num = 1;
                break;
            }
        }
        return num;
    }

    @Override
    public boolean delete(int goodsId) {
        boolean remove = false;
        for (ShoppingCart shoppingCart : shoppingCarts) {
            if (shoppingCart.getGoodsId() == goodsId) {
                remove = shoppingCarts.remove(shoppingCart);
                break;
            }
        }
        return remove;
    }

    @Override
    public List<ShoppingCart> selectAll() {
        return shoppingCarts;
    }

    /**
     * 现金支付
     */
    public int cashPayment() {
        //购物车商品总金额
        BigDecimal goodsTotalPrice = new BigDecimal(0);
        for (ShoppingCart shoppingCart : shoppingCarts) {
            goodsTotalPrice = goodsTotalPrice.add(shoppingCart.getTotalPrice());
        }

        //参数校验，返回值校验，异常处理机制，log日志
        Connection conn = null;
        try {
            conn = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //关闭事务的自动提交机制
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (ShoppingCart shoppingCart : shoppingCarts) {
            Integer goodsId = shoppingCart.getGoodsId();
            Integer count = shoppingCart.getCount();

            //修改商品信息表中商品数量
            Map<String, Object> map = null;
            try {
                map = new GoodsInfoImpl().selectOne(goodsId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int baseCount = (int) map.get("goodscount");
            Integer finalCount = baseCount -  count;
            try {
                int update = new GoodsInfoImpl().update(finalCount, goodsId);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //添加订单信息到订单信息表
            int keyOrderId = 0;
            try {
                keyOrderId = new OrderInfoImpl().getKey(goodsTotalPrice);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //添加订单信息到订单详情表
            try {
                new OrderDetailImpl().insert(keyOrderId, goodsId, count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int num = 0;
        try {
            conn.commit();
            num = 1;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            e.printStackTrace();
        }

        return num;
    }

    /**
     * 刷卡支付
     */
    public int vipCardPayment(int userId) {
        //购物车商品总金额
        BigDecimal goodsTotalPrice = new BigDecimal(0);
        for (ShoppingCart shoppingCart : shoppingCarts) {
            goodsTotalPrice = goodsTotalPrice.add(shoppingCart.getTotalPrice());
        }

        //参数校验，返回值校验，异常处理机制，log日志
        Connection conn = null;
        try {
            conn = DbUtil.getConn();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            //关闭事务的自动提交机制
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (ShoppingCart shoppingCart : shoppingCarts) {
            Integer goodsId = shoppingCart.getGoodsId();
            Integer count = shoppingCart.getCount();

            //修改商品信息表中商品数量
            Map<String, Object> map = null;
            try {
                map = new GoodsInfoImpl().selectOne(goodsId);
            } catch (Exception e) {
                e.printStackTrace();
            }
            int baseCount = (int) map.get("goodscount");
            Integer finalCount = baseCount -  count;
            try {
                new GoodsInfoImpl().update(finalCount, goodsId);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //添加订单信息到订单信息表
            int keyOrderId = 0;
            try {
                keyOrderId = new OrderInfoImpl().getKey(userId,goodsTotalPrice);
            } catch (Exception e) {
                e.printStackTrace();
            }

            //添加订单信息到订单详情表
            try {
                new OrderDetailImpl().insert(keyOrderId, goodsId, count);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        int num = 0;

        //划掉用户会员卡余额，增加相应的积分
        Map<String, Object> map = null;
        try {
            map = new VipInfoImpl().selectOne(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigDecimal balance = (BigDecimal) map.get("balance");

        if (balance.compareTo(goodsTotalPrice) >= 0) {
            balance = balance.subtract(goodsTotalPrice);
            try {
                new VipInfoImpl().update(balance, userId);
                conn.commit();
                num = 1;
            } catch (Exception e) {
                try {
                    conn.rollback();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
                e.printStackTrace();
            }
        } else {
            num = 2;
        }

        return num;
    }

    public int passwordCheck(int userId, String password) {
        //加密密码
        String encryptionPassword = null;
        //会员密码MD5加密，以防忘记，会员密码全设为123456
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(password.getBytes());
            byte[] encodeBy = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, encodeBy);
            encryptionPassword = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        int num = 0;
        Map<String, Object> map = null;
        try {
             map = new VipInfoImpl().selectOne(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (map.get("vippassword").equals(encryptionPassword)) {
            num = 1;
        }

        return num;
    }

    /**
     * 支付后清空购物车
     */
    public void emptyShoppingCart() {
        shoppingCarts.clear();
    }
}
