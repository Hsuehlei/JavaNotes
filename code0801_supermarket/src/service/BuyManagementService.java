package service;

import com.sun.org.apache.bcel.internal.generic.NEW;
import entity.ShoppingCart;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 19:57
 */
public interface BuyManagementService {

    /**
     * 商品加购物车
     * @param goodsId
     * @param count
     * @return
     */
    boolean add(int goodsId, int count);

    /**
     * 修改购物车商品数量
     * @param goodsId
     * @param newCount
     * @return
     */
    int edit(int goodsId, int newCount);

    /**
     * 删除购物车商品
     * @param goodsId
     * @return
     */
    boolean delete(int goodsId);

    /**
     * 查看购物车商品
     * @return
     */
    List<ShoppingCart> selectAll();

}
