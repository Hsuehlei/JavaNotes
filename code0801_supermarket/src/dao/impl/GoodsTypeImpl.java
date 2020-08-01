package dao.impl;

import dao.BaseDao;
import entity.GoodsType;
import util.DbUtil;

import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 20:48
 */
public class GoodsTypeImpl implements BaseDao<GoodsType> {
    /*
    类型ID  int 自增 唯一
    父id   int   当父id为0时  代表的是一级类目  pid
    类型名称 varchar(20) 非空
    是否为父类型 tinyint(1) 1为是，0为否
    创建时间 datetime 可空
    修改时间 datetime 可空
     */
    @Override
    public int insert(GoodsType goodsType) throws Exception {
        int fartherId = goodsType.getFatherId();
        String typeName = goodsType.getTypeName();
        boolean ifFatherType = goodsType.getIfFatherType();
        String sql = "INSERT INTO t_goods_type(fatherid,typename,iffathertype,createtime) VALUES (?,?,?,NOW())";
        int i = DbUtil.executeUpdate(sql,fartherId,typeName,ifFatherType);
        return i;
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM t_goods_type WHERE typeid = ?";
        int i = DbUtil.executeUpdate(sql, id);
        return i;
    }

    @Override
    public int update(GoodsType goodsType) throws Exception {
        int typeId = goodsType.getTypeId();
        int fatherId = goodsType.getFatherId();
        String typeName = goodsType.getTypeName();
        boolean ifFatherType = goodsType.getIfFatherType();
        String sql = "UPDATE t_goods_type SET fatherid = ?,typename = ?,iffathertype = ?,updatetime = NOW() WHERE typeid = ?";
        int i = DbUtil.executeUpdate(sql, fatherId, typeName, ifFatherType, typeId);
        return i;
    }

    @Override
    public Map<String, Object> selectOne(int id) throws Exception {
        String sql = "SELECT * FROM t_goods_type WHERE typeid = ?";
        List<Map<String, Object>> maps = DbUtil.executeQuery(sql, id);
        if (maps.size() > 0) {
            Map<String, Object> map = maps.get(0);
            return maps.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<GoodsType> selectAll() throws Exception {
        String sql = "SELECT * FROM t_goods_type";
        List<GoodsType> goodsTypes = DbUtil.executeQuery(GoodsType.class, sql);
        return goodsTypes;
    }

    public List<GoodsType> selectSupertype() throws Exception {
        String sql = "SELECT * FROM t_goods_type WHERE fatherid = 0";
        List<GoodsType> superTypes = DbUtil.executeQuery(GoodsType.class, sql);
        return superTypes;
    }

    public List<GoodsType> selectSubtype() throws Exception {
        String sql = "SELECT * FROM t_goods_type WHERE iffathertype = 0";
        List<GoodsType> subTypes = DbUtil.executeQuery(GoodsType.class, sql);
        return subTypes;
    }
}
