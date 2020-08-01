package startview.role.function;

import dao.impl.GoodsInfoImpl;
import entity.GoodsInfo;
import service.impl.GoodsInfoServiceImpl;
import startview.role.Admin;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 21:58
 */
public class AdminGoodsInfoFunc {

    public static void addGoods(Scanner sc) {
        System.out.println("> 商品名称：");
        String goodsName = sc.next();
        System.out.println("> 商品类型：");
        int goodsType = sc.nextInt();
        System.out.println("> 商品数量：");
        int goodsCount = sc.nextInt();
        System.out.println("> 商品单价：");
        float unitPrice = sc.nextFloat();
        System.out.println("> 商品状态(1-正常，2-下架，3-删除)：");
        int goodsStatus = sc.nextInt();
        System.out.println("> 商品折扣：");
        float discount = sc.nextFloat();

        GoodsInfoImpl goodInfoImpl = new GoodsInfoImpl();
        GoodsInfo goodsInfo = new GoodsInfo(goodsName,goodsType,goodsCount,unitPrice,goodsStatus,discount);
        GoodsInfoServiceImpl goodsInfoService = new GoodsInfoServiceImpl(goodInfoImpl);
        int add = goodsInfoService.add(goodsInfo);

        if (add == 1) {
            System.out.println("> 商品信息添加成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 商品信息添加失败");
            System.out.println("> 请重新添加");
        }
        backToGoodsInfoMenu(sc);
    }

    public static void editGoods(Scanner sc) {
        System.out.println("请输入要修改的商品ID：");
        int goodsId = sc.nextInt();
        System.out.println("商品数量：");
        int goodsCount = sc.nextInt();
        System.out.println("商品单价：");
        float unitPrice = sc.nextFloat();
        System.out.println("商品状态：");
        int goodsStatus = sc.nextInt();
        System.out.println("商品折扣：");
        float discount = sc.nextFloat();

        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        GoodsInfo goodsInfo = new GoodsInfo(goodsId,goodsCount,unitPrice,goodsStatus,discount);
        GoodsInfoServiceImpl goodsInfoService = new GoodsInfoServiceImpl(goodsInfoImpl);
        int edit = goodsInfoService.edit(goodsInfo);

        if (edit == 1) {
            System.out.println("> 商品信息修改成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 商品信息修改失败");
            System.out.println("> 请重新添加");
        }
        backToGoodsInfoMenu(sc);
    }

    public static void selectOneGoods(Scanner sc) {
        System.out.print("请输入要查询的商品ID：");
        int goodsId = sc.nextInt();
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        GoodsInfoServiceImpl goodsInfoService = new GoodsInfoServiceImpl(goodsInfoImpl);
        Map<String, Object> map = goodsInfoService.selectOneGoods(goodsId);
        if (map != null) {
            System.out.println("商品编号\t商品名称\t商品类型\t商品数量\t商品单价\t商品状态\t商品折扣\t创建时间\t\t\t\t\t修改时间");
            System.out.println("   " +map.get("goodsid") +" \t"+ map.get("goodsname") +"   \t"+ map.get("goodstype") +"\t\t"+ map.get("goodscount") +
                    "\t\t"+map.get("unitprice") +"\t\t"+ map.get("goodsstatus") +"\t\t"+ map.get("discount") +"\t\t"+ map.get("createtime") +"\t"+ map.get("updatetime"));
        } else {
            System.out.println("抱歉，该商品不存在");
        }
        backToGoodsInfoMenu(sc);
    }

    public static void selectAllGoods(Scanner sc) {
        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        GoodsInfoServiceImpl goodsInfoService = new GoodsInfoServiceImpl(goodsInfoImpl);
        List<GoodsInfo> goodsInfos = goodsInfoService.selectAllGoods();
        System.out.println("商品编号\t商品名称\t商品类型\t商品数量\t商品单价\t商品状态\t商品折扣\t创建时间\t\t\t\t\t修改时间");
        for (GoodsInfo goodsInfo : goodsInfos) {
            System.out.println(goodsInfo);
        }
        backToGoodsInfoMenu(sc);
    }

    public static void deleteGoods(Scanner sc) {
        System.out.println("请输入要删除的商品ID：");
        int goodsId = sc.nextInt();

        GoodsInfoImpl goodsInfoImpl = new GoodsInfoImpl();
        GoodsInfoServiceImpl goodsInfoService = new GoodsInfoServiceImpl(goodsInfoImpl);
        int delete = goodsInfoService.delete(goodsId);

        if (delete == 1) {
            System.out.println("> 商品信息删除成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 商品信息删除失败");
            System.out.println("> 请重新删除");
        }
        backToGoodsInfoMenu(sc);
    }

    /**
     * 回到商品信息管理的选择界面
     * @param sc
     */
    public static void backToGoodsInfoMenu(Scanner sc) {
        System.out.println();
        String choice = Admin.goodsInfoManagement(sc);
        Admin.goodsInfoManagementChoice(choice,sc);
    }

}
