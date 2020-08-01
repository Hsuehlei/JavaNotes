package service.impl;

import dao.impl.RankImpl;
import entity.TopTenRank;
import service.RankService;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/8/1 9:54
 */
public class RankServiceImpl implements RankService {

    RankImpl rank = new RankImpl();

    @Override
    public List<TopTenRank> selectByGoodsType() {
        List<TopTenRank> topTenRanks = null;
        try {
            topTenRanks = rank.topTenRanksGoodsType();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topTenRanks;
    }

    /**
     * 日期查询
     * @param data1 起始时间
     * @param data2 终止时间
     * @return
     */
    @Override
    public List<TopTenRank> selectByMonth(String data1, String data2) {
        List<TopTenRank> topTenRanks = null;
        try {
            topTenRanks = rank.topTenRanksMonth(data1,data2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return topTenRanks;
    }
}
