package dao.impl;

import dao.BaseDao;
import entity.GoodsInfo;
import util.DbUtil;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 22:42
 */
public class GoodsInfoImpl implements BaseDao<GoodsInfo> {
    @Override
    public int insert(GoodsInfo goodsInfo) throws Exception {
        String goodsName = goodsInfo.getGoodsName();
        int goodsType = goodsInfo.getGoodsType();
        int goodsCount = goodsInfo.getGoodsCount();
        float unitPrice = goodsInfo.getUnitPrice();
        int goodsStatus = goodsInfo.getGoodsStatus();
        float discount = goodsInfo.getDiscount();
        String sql = "INSERT INTO t_goods_info(goodsname, goodstype, goodscount, unitprice, goodsstatus, discount, createtime)" +
                " VALUES (?, ?, ?, ?, ?, ?, NOW())";
        int i = DbUtil.executeUpdate(sql,goodsName,goodsType,goodsCount,unitPrice,goodsStatus,discount);
        return i;
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM t_goods_info WHERE id = ?";
        int i = DbUtil.executeUpdate(sql, id);
        return i;
    }

    public int update(int goodsCount, int goodsId) throws Exception {
        String sql = "UPDATE t_goods_info SET goodscount = ?, updatetime = NOW() WHERE goodsid = ?";
        int i = DbUtil.executeUpdate(sql, goodsCount, goodsId);
        return i;
    }

    @Override
    public int update(GoodsInfo goodsInfo) throws Exception {
        int goodsId = goodsInfo.getGoodsId();
        int goodsCount = goodsInfo.getGoodsCount();
        float unitPrice = goodsInfo.getUnitPrice();
        int goodsStatus = goodsInfo.getGoodsStatus();
        float discount = goodsInfo.getDiscount();
        String sql = "UPDATE t_goods_info SET goodscount = ?, unitprice = ?, goodsstatus = ?, discount = ?, " +
                "updatetime = NOW() WHERE goodsid = ?";
        int i = DbUtil.executeUpdate(sql, goodsCount, unitPrice, goodsStatus, discount, goodsId);
        return i;
    }

    @Override
    public Map<String, Object> selectOne(int id) throws Exception {
        String sql = "SELECT * FROM t_goods_info WHERE goodsid = ?";
        List<Map<String, Object>> maps = DbUtil.executeQuery(sql, id);
        if (maps.size() > 0) {
            return maps.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<GoodsInfo> selectAll() throws Exception {
        String sql = "SELECT * FROM t_goods_info";
        List<GoodsInfo> goodsInfos = DbUtil.executeQuery(GoodsInfo.class, sql);
        return goodsInfos;
    }
}
