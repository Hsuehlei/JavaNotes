package dao.impl;

import entity.VipInfo;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 10:46
 */
public class VipInfoImplTest {

    @Test
    public void insert() throws Exception {
        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfo vipInfo = new VipInfo("吴八","123456","13345678912",132F,new BigDecimal(77));
        System.out.println(vipInfoImpl.insert(vipInfo));
    }

    @Test
    public void delete() throws Exception {
        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        System.out.println(vipInfoImpl.delete(6));
    }

    @Test
    public void update() throws Exception {
        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        VipInfo vipInfo = new VipInfo(6,"吴八", "456123", "11111111111", 77.0F, new BigDecimal(88));
        System.out.println(vipInfoImpl.update(vipInfo));
    }

    @Test
    public void selectOne() throws Exception {
        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        Map<String, Object> map = vipInfoImpl.selectOne(6);
        System.out.println(map);
    }

    @Test
    public void selectAll() throws Exception {
        VipInfoImpl vipInfoImpl = new VipInfoImpl();
        List<VipInfo> vipInfos = vipInfoImpl.selectAll();
        System.out.println(vipInfos);
    }
}