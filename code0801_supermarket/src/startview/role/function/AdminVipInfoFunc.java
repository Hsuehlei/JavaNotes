package startview.role.function;

import dao.impl.VipInfoImpl;
import entity.VipInfo;
import service.impl.VipInfoServiceImpl;
import startview.role.Admin;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 15:14
 */
public class AdminVipInfoFunc {

    public static void addVip(Scanner sc) {
        System.out.println("会员名：");
        String vipName = sc.next();
        System.out.println("密码：");
        String password = sc.next();
        System.out.println("联系方式：");
        String tel = sc.next();
        System.out.println("积分：");
        float integral = sc.nextFloat();
        System.out.println("余额：");
        BigDecimal balance = sc.nextBigDecimal();

        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfo vipInfo = new VipInfo(vipName, password, tel, integral, balance);
        VipInfoServiceImpl vipInfoService = new VipInfoServiceImpl(vipInfoImpl);
        int add = vipInfoService.add(vipInfo);

        if (add == 1) {
            System.out.println("> 会员添加成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 会员添加失败");
            System.out.println("> 请重新添加");
        }
        backToVipInfoMenu(sc);
    }

    public static void editVip(Scanner sc) {
        System.out.println("请输入要修改的会员ID：");
        int vipId = sc.nextInt();
        System.out.println("会员名：");
        String vipName = sc.next();
        System.out.println("会员密码：");
        String vipPassword = sc.next();
        System.out.println("联系方式：");
        String tel = sc.next();

        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfo vipInfo = new VipInfo(vipId, vipName, vipPassword, tel);
        VipInfoServiceImpl vipInfoService = new VipInfoServiceImpl(vipInfoImpl);
        int edit = vipInfoService.edit(vipInfo);

        if (edit == 1) {
            System.out.println("> 会员信息修改成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 会员信息修改失败");
            System.out.println("> 请重新修改");
        }
        backToVipInfoMenu(sc);
    }

    public static void selectOneVip(Scanner sc) {
        System.out.println("请输入要查询的会员ID：");
        int vipId = sc.nextInt();

        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfoServiceImpl vipInfoService = new VipInfoServiceImpl(vipInfoImpl);
        Map<String, Object> map = vipInfoService.selectOne(vipId);

        if (map != null) {
            System.out.println("会员编号\t会员名\t密码\t\t联系方式\t\t积分\t余额\t创建时间\t\t\t\t\t修改时间");
            System.out.println("   " + map.get("vipid") + "\t" + map.get("vipname") + "\t" + map.get("vippassword") + "\t\t" +
                    map.get("tel") + "\t" + map.get("integral") + "\t" + map.get("balance") + "\t\t" + map.get("createtime") + "\t"
                    + map.get("updatetime"));
        } else {
            System.out.println("抱歉，该用户不存在");
        }
        backToVipInfoMenu(sc);
    }

    public static void selectAllVip(Scanner sc) {
        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfoServiceImpl vipInfoService = new VipInfoServiceImpl(vipInfoImpl);
        List<VipInfo> vipInfos = vipInfoService.selectAll();
        System.out.println("会员编号\t会员名\t密码\t\t联系方式\t\t积分\t余额\t创建时间\t\t\t\t\t修改时间");
        for (VipInfo vipInfo : vipInfos) {
            System.out.println(vipInfo);
        }
        backToVipInfoMenu(sc);
    }

    public static void vipRecharge(Scanner sc) {
        System.out.println("请输入要充值的会员ID：");
        int vipId = sc.nextInt();
        System.out.println("请输入要充值的金额：");
        BigDecimal rechargeAmount = sc.nextBigDecimal();

        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfoServiceImpl vipInfoService = new VipInfoServiceImpl(vipInfoImpl);
        int i = vipInfoService.vipRecharge(vipId, rechargeAmount);
        if (i == 1) {
            System.out.println("> 充值成功");
            Map<String, Object> map = vipInfoService.selectOne(vipId);
            System.out.println("> 账户余额为：" + map.get("balance") + "元");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 充值失败");
            System.out.println("> 请重试");
        }
        backToVipInfoMenu(sc);
    }

    public static void deleteVip(Scanner sc) {
        System.out.println("请输入准备删除的会员ID：");
        int vipId = sc.nextInt();

        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfoServiceImpl vipInfoService = new VipInfoServiceImpl(vipInfoImpl);
        int i = vipInfoService.delete(vipId);
        if (i == 1) {
            System.out.println("> 删除成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 删除失败");
            System.out.println("> 请重试");
        }
        backToVipInfoMenu(sc);
    }

    public static void backToVipInfoMenu(Scanner sc) {
        System.out.println();
        String choice = Admin.vipManagement(sc);
        Admin.vipManagementChoice(choice, sc);
    }
}
