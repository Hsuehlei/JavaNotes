package dao.impl;

import entity.GoodsInfo;
import entity.GoodsType;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 22:58
 */
public class GoodsInfoImplTest {

    @Test
    public void insert() throws Exception {
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        GoodsInfo goodsInfo = new GoodsInfo("葡萄",1,270,1.7F,1,8.0F);
        System.out.println(goodsInfoImpl.insert(goodsInfo));
    }

    @Test
    public void delete() throws Exception {
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        System.out.println(goodsInfoImpl.delete(6));
    }

    @Test
    public void update() throws Exception {
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        GoodsInfo goodsInfo = new GoodsInfo(6, 111, 1.5F, 1, 8.0F);
        System.out.println(goodsInfoImpl.update(goodsInfo));
    }

    @Test
    public void selectOne() throws Exception {
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        Map<String, Object> map = goodsInfoImpl.selectOne(10);
        System.out.println(map);
    }

    @Test
    public void selectAll() throws Exception {
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        List<GoodsInfo> goodsInfos = goodsInfoImpl.selectAll();
        System.out.println(goodsInfos);
    }
}