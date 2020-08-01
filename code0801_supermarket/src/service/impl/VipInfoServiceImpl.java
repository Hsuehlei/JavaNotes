package service.impl;

import dao.BaseDao;
import dao.impl.VipInfoImpl;
import entity.VipInfo;
import service.VipInfoService;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 11:30
 */
public class VipInfoServiceImpl implements VipInfoService {

    private BaseDao<VipInfo> baseDao;

    public VipInfoServiceImpl(BaseDao<VipInfo> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int add(VipInfo vipInfo) {
        String vipPassword = vipInfo.getVipPassword();
        String basePassword = null;
        //会员密码MD5加密，以防忘记，会员密码全设为123456
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(vipPassword.getBytes());
            byte[] encodeBy = messageDigest.digest();
            BigInteger bigInteger = new BigInteger(1, encodeBy);
            basePassword = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        vipInfo.setVipPassword(basePassword);

        int num = 0;
        try {
            num = baseDao.insert(vipInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return num;
    }

    @Override
    public int delete(int id) {
        int num = 0;
        try {
            num = baseDao.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public int edit(VipInfo vipInfo) {
        int num = 0;
        if (vipInfo != null) {
            try {
                num = baseDao.update(vipInfo);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public Map<String, Object> selectOne(int id) {
        Map<String, Object> map = null;
        try {
            map = baseDao.selectOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<VipInfo> selectAll() {
        List<VipInfo> vipInfos = null;
        try {
            vipInfos = baseDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return vipInfos;
    }

    /**
     * vip余额充值
     *
     * @param id             vip编号
     * @param rechargeAmount 充值金额
     * @return
     */
    public int vipRecharge(int id, BigDecimal rechargeAmount) {
        List<VipInfo> recharge = null;
        try {
            recharge = new VipInfoImpl().recharge(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        BigDecimal totalBalance = new BigDecimal(0);
        if (recharge != null) {
            BigDecimal balance = recharge.get(0).getBalance();
            totalBalance = balance.add(rechargeAmount);
        }

        int num = 0;
        try {
            num = new VipInfoImpl().updateBalance(id, totalBalance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return num;
    }
}
