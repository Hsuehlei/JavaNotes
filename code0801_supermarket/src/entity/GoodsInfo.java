package entity;

import java.sql.Timestamp;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 22:34
 */
public class GoodsInfo {

    /*
    商品编号 id	int 自增 唯一主键
    商品名	varchar（20） 非空
    商品所属类型   非空
    商品数量	int 非空 默认值0
    单价 float 非空
    商品状态 tinyint(4) 1-正常，2-下架，3-删除
    折扣(默认是10) float
    创建时间 datetime 可空
    修改时间 datetime 可空
     */
    private Integer goodsId;
    private String goodsName;
    private Integer goodsType;
    private Integer goodsCount;
    private Float unitPrice;
    private Integer goodsStatus;
    private Float discount;
    private Timestamp createTime;
    private Timestamp updateTime;

    public GoodsInfo() {
    }

    public GoodsInfo(Integer goodsId, Integer goodsCount, Float unitPrice, Integer goodsStatus, Float discount) {
        this.goodsId = goodsId;
        this.goodsCount = goodsCount;
        this.unitPrice = unitPrice;
        this.goodsStatus = goodsStatus;
        this.discount = discount;
    }

    public GoodsInfo(String goodsName, Integer goodsType, Integer goodsCount, Float unitPrice, Integer goodsStatus, Float discount) {
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsCount = goodsCount;
        this.unitPrice = unitPrice;
        this.goodsStatus = goodsStatus;
        this.discount = discount;
    }

    public GoodsInfo(Integer goodsId, String goodsName, Integer goodsType, Integer goodsCount,
                     Float unitPrice, Integer goodsStatus, Float discount, Timestamp createTime, Timestamp updateTime) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsType = goodsType;
        this.goodsCount = goodsCount;
        this.unitPrice = unitPrice;
        this.goodsStatus = goodsStatus;
        this.discount = discount;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Integer goodsType) {
        this.goodsType = goodsType;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
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
        return  "   " + goodsId + "\t" + goodsName + "\t" +  goodsType + "\t\t" + goodsCount + "\t\t" + unitPrice + "\t\t" + goodsStatus +
                "\t\t" + discount + "\t\t" + createTime + "\t" + updateTime;
    }
}
