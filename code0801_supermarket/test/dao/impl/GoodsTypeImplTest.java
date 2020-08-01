package dao.impl;

import entity.GoodsType;
import org.junit.Test;
import util.DbUtil;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 20:55
 */
public class GoodsTypeImplTest {

    @Test
    public void insert() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsType goodsType = new GoodsType(2,"进口蔬菜",false);
        System.out.println(goodsTypeImpl.insert(goodsType));
    }

    @Test
    public void delete() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        System.out.println(goodsTypeImpl.delete(4));
    }

    @Test
    public void update() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsType goodsType = new GoodsType(5,2,"进口蔬菜",false);
        System.out.println(goodsTypeImpl.update(goodsType));
    }

    @Test
    public void selectOne() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        Map<String, Object> map = goodsTypeImpl.selectOne(5);
        System.out.println(map);
    }

    @Test
    public void selectAll() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        List<GoodsType> goodsTypes = goodsTypeImpl.selectAll();
        System.out.println(goodsTypes);
    }

    @Test
    public void selectSupertype() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        List<GoodsType> goodsTypes = goodsTypeImpl.selectSupertype();
        for (GoodsType goodsType : goodsTypes) {
            System.out.println("|---" + goodsType.getTypeName());
        }
    }

    @Test
    public void selectSubtype() throws Exception {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        List<GoodsType> goodsTypes = goodsTypeImpl.selectSubtype();
        for (GoodsType goodsType : goodsTypes) {
            System.out.println("|---" + goodsType.getTypeName());
        }
    }
}