package entity;

import java.math.BigDecimal;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/30 20:03
 */
public class ShoppingCart {

    private Integer goodsId;
    private String goodsName;
    private Float unitPrice;
    private Integer count;
    private Float discount;
    private BigDecimal totalPrice;

    public ShoppingCart() {
    }

    public ShoppingCart(Integer goodsId, String goodsName, Float unitPrice, Integer count, Float discount, BigDecimal totalPrice) {
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.unitPrice = unitPrice;
        this.count = count;
        this.discount = discount;
        this.totalPrice = totalPrice;
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

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return  "   " + goodsId + "\t" + goodsName + "\t" + unitPrice + "\t\t" + count + "\t\t" + discount + "\t" + totalPrice;
    }
}
