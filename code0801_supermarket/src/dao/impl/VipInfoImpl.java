package dao.impl;

import dao.BaseDao;
import entity.VipInfo;
import util.DbUtil;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 10:22
 */
public class VipInfoImpl implements BaseDao<VipInfo> {
    @Override
    public int insert(VipInfo vipInfo) throws Exception {
        String vipName = vipInfo.getVipName();
        String vipPassword = vipInfo.getVipPassword();
        String tel = vipInfo.getTel();
        float integral = vipInfo.getIntegral();
        BigDecimal balance = vipInfo.getBalance();
        String sql = "INSERT INTO t_vip_info(vipname, vippassword, tel, integral, balance, createtime, updatetime) " +
                "VALUES (?, ?, ?, ?, ?, NOW(), NOW())";
        int i = DbUtil.executeUpdate(sql, vipName, vipPassword, tel, integral, balance);
        return i;
    }

    @Override
    public int delete(int id) throws Exception {
        String sql = "DELETE FROM t_vip_info WHERE vipid = ?";
        int i = DbUtil.executeUpdate(sql, id);
        return i;
    }

    @Override
    public int update(VipInfo vipInfo) throws Exception {
        int vipId = vipInfo.getVipId();
        String vipName = vipInfo.getVipName();
        String vipPassword = vipInfo.getVipPassword();
        String tel = vipInfo.getTel();
        String sql = "UPDATE t_vip_info SET vipname = ?, vippassword = ?, tel = ?, updatetime = NOW() WHERE vipid = ?";
        int i = DbUtil.executeUpdate(sql, vipName, vipPassword, tel, vipId);
        return i;
    }

    public int update(BigDecimal balance, int id) throws Exception {
        String sql = "UPDATE t_vip_info SET balance = ? WHERE vipid = ?";
        int i = DbUtil.executeUpdate(sql, balance, id);
        return i;
    }

    @Override
    public Map<String, Object> selectOne(int id) throws Exception {
        String sql = "SELECT * FROM t_vip_info WHERE vipid = ?";
        List<Map<String, Object>> maps = DbUtil.executeQuery(sql, id);
        //如过查询了数据库中不存在的ID，会报java.lang.IndexOutOfBoundsException，故在此加个判断
        if (maps.size() > 0) {
            return maps.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<VipInfo> selectAll() throws Exception {
        String sql = "SELECT * FROM t_vip_info";
        List<VipInfo> vipInfos = DbUtil.executeQuery(VipInfo.class, sql);
        return vipInfos;
    }

    /**
     * 会员充值，查询余额
     * @param id
     * @throws Exception
     */
    public List<VipInfo> recharge(int id) throws Exception {
        String sql = "SELECT * FROM t_vip_info WHERE vipid = ?";
        List<VipInfo> vipInfos = DbUtil.executeQuery(VipInfo.class, sql, id);
        return vipInfos;
    }

    /**
     * 更新余额记录
     * @param balance 充值后的余额
     * @param id vip编号
     * @return
     * @throws Exception
     */
    public int updateBalance(int id,BigDecimal balance) throws Exception {
        String sql = "UPDATE t_vip_info SET balance = ? WHERE vipid = ?";
        int i = DbUtil.executeUpdate(sql, balance, id);
        return i;
    }
}
