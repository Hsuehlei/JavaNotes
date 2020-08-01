package service;

import entity.GoodsType;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 16:43
 */
public interface GoodsTypeService {

    /**
     * 插入记录
     * @param goodsType
     * @return
     */
    int add(GoodsType goodsType);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int delete(int id);

    /**
     * 更新记录
     * @param goodsType
     * @return
     */
    int edit(GoodsType goodsType);

    /**
     * 选择一个
     * @param id
     * @return
     */
    GoodsType selectOne(int id);

    /**
     * 选择所有
     * @return
     */
    List<GoodsType> selectAll();
}
