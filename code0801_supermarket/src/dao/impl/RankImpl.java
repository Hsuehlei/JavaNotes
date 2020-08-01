package dao.impl;

import entity.TopTenRank;
import util.DbUtil;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/31 21:46
 */
public class RankImpl {

    public List<TopTenRank> topTenRanksGoodsType() throws Exception {
        String sql = "SELECT goodsid,goodsname,sum(buycount) FROM t_goods_info,t_order_detail " +
                "WHERE goodsid IN (SELECT buyid FROM t_order_detail GROUP BY buyid) AND goodsid = buyid " +
                "GROUP BY goodsid ORDER BY SUM(buycount) DESC LIMIT 0,10";
        List<TopTenRank> topTenRanks = DbUtil.executeQuery(TopTenRank.class, sql);
        return topTenRanks;
    }

    public List<TopTenRank> topTenRanksMonth(String data1, String data2) throws Exception {
        String sql = "SELECT t1.goodsid,t1.goodsname,sum(t2.buycount) FROM t_goods_info t1,t_order_detail t2,t_order_info t3 " +
                "WHERE t2.orderid = t3.orderid AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') >= DATE_FORMAT(?,'%Y-%m-%d') " +
                "AND DATE_FORMAT(t3.ordertime,'%Y-%m-%d') <= DATE_FORMAT(?,'%Y-%m-%d') " +
                "AND t1.goodsid IN (SELECT buyid FROM t_order_detail GROUP BY buyid) AND t1.goodsid = t2.buyid " +
                "GROUP BY t1.goodsid ORDER BY SUM(t2.buycount) DESC LIMIT 0,10";
        List<TopTenRank> topTenRanks = DbUtil.executeQuery(TopTenRank.class, sql, data1, data2);
        return topTenRanks;
    }
}
