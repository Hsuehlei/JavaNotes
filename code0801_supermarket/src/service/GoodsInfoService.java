package service;

import entity.GoodsInfo;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 22:05
 */
public interface GoodsInfoService {

    /**
     * 插入记录
     * @param goodsInfo
     * @return
     */
    int add(GoodsInfo goodsInfo);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 更新记录
     * @param goodsInfo
     * @return
     */
    int edit(GoodsInfo goodsInfo);

    /**
     * 选择一个
     * @param id
     * @return
     */
    Map<String, Object> selectOneGoods(int id);

    /**
     * 选择所有
     * @return
     */
    List<GoodsInfo> selectAllGoods();
}
