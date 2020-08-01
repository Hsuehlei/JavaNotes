package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/29 9:57
 */
public class VipInfo {

    /*
    会员编号 int 自增 唯一 主键
    会员名 varchar（20） 非空
    密码  varchar(64) 加密存储
    联系方式 varchar（20）可空
    积分  float 默认为0
    余额。 decimal默认为0
    创建时间 datetime 非空
    修改时间 datetime 非空
     */
    private Integer vipId;
    private String vipName;
    private String vipPassword;
    private String tel;
    private Float integral;
    private BigDecimal balance;
    private Timestamp createTime;
    private Timestamp updateTime;

    public VipInfo() {
    }

    public VipInfo(Integer vipId, String vipName, String vipPassword, String tel) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipPassword = vipPassword;
        this.tel = tel;
    }

    public VipInfo(String vipName, String vipPassword, String tel, Float integral, BigDecimal balance) {
        this.vipName = vipName;
        this.vipPassword = vipPassword;
        this.tel = tel;
        this.integral = integral;
        this.balance = balance;
    }

    public VipInfo(Integer vipId, String vipName, String vipPassword, String tel, Float integral, BigDecimal balance) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipPassword = vipPassword;
        this.tel = tel;
        this.integral = integral;
        this.balance = balance;
    }

    public VipInfo(Integer vipId, String vipName, String vipPassword, String tel, Float integral, BigDecimal balance,
                   Timestamp createTime, Timestamp updateTime) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.vipPassword = vipPassword;
        this.tel = tel;
        this.integral = integral;
        this.balance = balance;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getVipId() {
        return vipId;
    }

    public void setVipId(Integer vipId) {
        this.vipId = vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public String getVipPassword() {
        return vipPassword;
    }

    public void setVipPassword(String vipPassword) {
        this.vipPassword = vipPassword;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Float getIntegral() {
        return integral;
    }

    public void setIntegral(Float integral) {
        this.integral = integral;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return  "   " + vipId + "\t" + vipName + "\t" + vipPassword + "\t\t" + tel + "\t" + integral + "\t" + balance +
                "\t\t" + createTime + "\t" + updateTime;
    }
}
