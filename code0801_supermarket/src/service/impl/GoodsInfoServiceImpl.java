package service.impl;

import dao.BaseDao;
import entity.GoodsInfo;
import service.GoodsInfoService;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 22:10
 */
public class GoodsInfoServiceImpl implements GoodsInfoService {

    private BaseDao<GoodsInfo> baseDao;

    public GoodsInfoServiceImpl(BaseDao<GoodsInfo> baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public int add(GoodsInfo goodsInfo) {
        int num = 0;
        if (goodsInfo != null) {
            try {
                num = baseDao.insert(goodsInfo);
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
    public int edit(GoodsInfo goodsInfo) {
        int num = 0;
        try {
            num = baseDao.update(goodsInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }

    @Override
    public Map<String, Object> selectOneGoods(int id) {
        Map<String, Object> map = null;
        try {
            map = baseDao.selectOne(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public List<GoodsInfo> selectAllGoods() {
        List<GoodsInfo> goodsInfos = null;
        try {
            goodsInfos = baseDao.selectAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return goodsInfos;
    }
}
