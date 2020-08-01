package service;

import entity.TopTenRank;

import java.util.List;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/8/1 9:50
 */
public interface RankService {

    /**
     * 按商品类型查询销量前十
     * @return
     */
    List<TopTenRank> selectByGoodsType();

    /**
     * 按时间日期筛选销量前十
     * @param data1
     * @param data2
     * @return
     */
    List<TopTenRank> selectByMonth(String data1,String data2);


}
