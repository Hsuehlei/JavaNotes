package entity;

import java.math.BigDecimal;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/31 22:25
 */
public class TopTenRank {

    private Integer goodsId;
    private String goodsName;
    private BigDecimal sales;

    public TopTenRank() {
    }

    public TopTenRank(Integer goodsId, String goodsName, BigDecimal sales) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.sales = sales;
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

    public BigDecimal getSales() {
        return sales;
    }

    public void setSales(BigDecimal sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return  "   " + goodsId + "\t" + goodsName + "\t" + sales;
    }
}
