package service.impl;

import dao.BaseDao;

import dao.impl.GoodsTypeImpl;
import entity.GoodsType;
import service.GoodsTypeService;

import java.util.List;


/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 16:52
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {

    //管理商品类型信息；商品类型管理拥有添加、删除、修改、查询商品类型，
    //查询父类型下所有的子类型(使用树状结构图进行展示,突出层级关系)（管理员权限）
    GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();

    private BaseDao<GoodsType> baseDao;

    public GoodsTypeServiceImpl(BaseDao<GoodsType> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int add(GoodsType goodsType) {
        int num = 0;
        if (goodsType != null) {
            try {
                num = baseDao.insert(goodsType);
            } catch (Exception e) {
                e.printStackTrace();
            }
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
    public int edit(GoodsType goodsType) {
        int num = 0;
        if (goodsType != null) {
            try {
                num = baseDao.update(goodsType);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return num;
    }

    @Override
    public GoodsType selectOne(int id) {
        return null;
    }

    @Override
    public List<GoodsType> selectAll() {
        List<GoodsType> goodsTypes = null;
        try {
            goodsTypes = baseDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsTypes;
    }

    public List<GoodsType> selectAllSupertype() {
        List<GoodsType> goodsTypes = null;
        try {
            goodsTypes = goodsTypeImpl.selectSupertype();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsTypes;
    }

    public List<GoodsType> selectAllSubtype() {
        List<GoodsType> goodsTypes = null;
        try {
            goodsTypes = goodsTypeImpl.selectSubtype();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsTypes;
    }
}
