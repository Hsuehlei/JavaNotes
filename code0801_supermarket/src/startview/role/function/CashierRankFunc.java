package startview.role.function;

import entity.TopTenRank;
import service.impl.RankServiceImpl;
import startview.role.Cashier;

import java.util.List;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/8/1 9:58
 */
public class CashierRankFunc {

    static RankServiceImpl rankService = new RankServiceImpl();

    public static void selectByGoodsId(Scanner sc) {
        List<TopTenRank> topTenRanks = rankService.selectByGoodsType();
        System.out.println("商品编号\t商品名\t销量");
        for (TopTenRank topTenRank : topTenRanks) {
            System.out.println(topTenRank);
        }
        backToBuyManagementMenu(sc);
    }

    public static void selectByMonth(Scanner sc) {
        System.out.println("筛选的起始日期为(yyyy-MM-dd)：");
        String data1 = sc.next();
        System.out.println("筛选的结束日期为(yyyy-MM-dd)：");
        String data2 = sc.next();
        List<TopTenRank> topTenRanks = rankService.selectByMonth(data1, data2);
        System.out.println("商品编号\t商品名\t销量");
        for (TopTenRank topTenRank : topTenRanks) {
            System.out.println(topTenRank);
        }
        backToBuyManagementMenu(sc);
    }

    public static void backToBuyManagementMenu(Scanner sc) {
        String choice = Cashier.rankStatistics(sc);
        Cashier.rankStatisticsChoice(choice,sc);
    }
}
