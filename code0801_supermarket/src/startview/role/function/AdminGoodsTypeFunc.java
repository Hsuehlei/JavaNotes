package startview.role.function;

import dao.impl.GoodsTypeImpl;
import entity.GoodsType;
import service.impl.GoodsTypeServiceImpl;
import startview.role.Admin;

import java.util.List;
import java.util.Scanner;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 17:15
 */
public class AdminGoodsTypeFunc {

    /**
     * 添加商品类型
     * @param sc
     */
    public static void addType(Scanner sc) {
        //fatherid,typename,iffathertype
        System.out.println("> 父ID(0是一级类目)：");
        int fatherId = sc.nextInt();
        System.out.println("> 类型名称：");
        String typename = sc.next();
        System.out.println("> 是否为父类型(true是，false否)：");
        boolean ifFatherType = sc.nextBoolean();

        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsType goodsType = new GoodsType(fatherId, typename, ifFatherType);
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl(goodsTypeImpl);
        int add = goodsTypeService.add(goodsType);
        if (add == 1) {
            System.out.println("> 商品类型信息添加成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 商品类型信息添加失败");
            System.out.println("> 请重新添加");
        }
        backToGoodsTypeMenu(sc);
    }

    /**
     * 修改商品类型
     * @param sc
     */
    public static void editType(Scanner sc) {
        //此处有一个查询所有类型的方法执行
        System.out.println("> 请输入要修改的类型ID：");
        int typeId = sc.nextInt();
        System.out.println("> 父ID(0是一级类目)：");
        int fatherId = sc.nextInt();
        System.out.println("> 类型名称：");
        String typename = sc.next();
        System.out.println("> 是否为父类型(true是，false否)：");
        boolean ifFatherType = sc.nextBoolean();

        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsType goodsType = new GoodsType(typeId, fatherId, typename, ifFatherType);
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl(goodsTypeImpl);
        int edit = goodsTypeService.edit(goodsType);
        if (edit == 1) {
            System.out.println("> 商品类型信息修改成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 商品类型信息修改失败");
            System.out.println("> 请重新修改");
        }
        backToGoodsTypeMenu(sc);
    }

    /**
     * 查看所有商品类型信息
     * @param sc
     */
    public static void selectAllType(Scanner sc) {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl(goodsTypeImpl);
        List<GoodsType> goodsTypes = goodsTypeService.selectAll();
        System.out.println("类型ID\t"+"父ID  "+"类型名称  "+"是否父类型\t"+"创建时间\t\t\t\t\t"+"修改时间");
        for (GoodsType goodsType : goodsTypes) {
            System.out.println("  " + goodsType.getTypeId() +"  \t"+ goodsType.getFatherId() +"\t  "+ goodsType.getTypeName() +"  \t"+
                    goodsType.getIfFatherType() +"\t\t"+ goodsType.getCreateTime() +"  "+ goodsType.getUpdateTime());

        }
        backToGoodsTypeMenu(sc);
    }

    /**
     * 删除商品类型信息
     * @param sc
     */
    public static void deleteType(Scanner sc) {
        System.out.print("> 请输入要删除的商品类型ID：");
        int typeId = sc.nextInt();
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl(goodsTypeImpl);
        int delete = goodsTypeService.delete(typeId);
        if (delete == 1) {
            System.out.println("> 商品类型信息删除成功");
            System.out.println("> 1秒后返回");
        } else {
            System.out.println("> 商品类型信息删除失败");
            System.out.println("> 请重新删除");
        }
        backToGoodsTypeMenu(sc);
    }

    /**
     * 查询所有父类型的子类型
     */
    public static void querySubclass(Scanner sc) {
        GoodsTypeImpl goodsTypeImpl = new GoodsTypeImpl();
        GoodsTypeServiceImpl goodsTypeService = new GoodsTypeServiceImpl(goodsTypeImpl);
        List<GoodsType> supertype = goodsTypeService.selectAllSupertype();
        List<GoodsType> subtype = goodsTypeService.selectAllSubtype();
        for (GoodsType sup : supertype) {
            System.out.println("|---" + sup.getTypeName());
            for (GoodsType sub : subtype) {
                if (sub.getFatherId().equals(sup.getTypeId())) {
                    System.out.println("\t|---" + sub.getTypeName());
                }
            }
        }
        backToGoodsTypeMenu(sc);
    }

    public static void backToGoodsTypeMenu(Scanner sc) {
        System.out.println();
        String choice = Admin.goodsTypeManagement(sc);
        Admin.goodsTypeManagementChoice(choice,sc);
    }
}
