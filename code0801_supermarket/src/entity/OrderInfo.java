package entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 15:20
 */
public class OrderInfo {

    /**
     * 订单ID int 自增  唯一
     * 用户ID int 非空
     * 订单总金额	decimal非空
     * 下单时间 datetime 非空
     * 支付类型 tinyint(2) （0-现金or  1-余额）非空
     */
    private Integer orderId;
    private Integer userId;
    private BigDecimal orderTotalPrice;
    private Timestamp orderTime;
    /**
     * true代表1，false代表0
     * 如果数据库中 tinyint 存储大小为 1，则默认映射到 Java 中的 Boolean
     * 否则则映射为Integer
     */
    private Boolean paymentType;

    public OrderInfo() {
    }

    public OrderInfo(Integer userId, BigDecimal orderTotalPrice, Boolean paymentType) {
        this.userId = userId;
        this.orderTotalPrice = orderTotalPrice;
        this.paymentType = paymentType;
    }

    public OrderInfo(Integer orderId, Integer userId, BigDecimal orderTotalPrice, Timestamp orderTime, Boolean paymentType) {
        this.orderId = orderId;
        this.userId = userId;
        this.orderTotalPrice = orderTotalPrice;
        this.orderTime = orderTime;
        this.paymentType = paymentType;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getOrderTotalPrice() {
        return orderTotalPrice;
    }

    public void setOrderTotalPrice(BigDecimal orderTotalPrice) {
        this.orderTotalPrice = orderTotalPrice;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

    public Boolean getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Boolean paymentType) {
        this.paymentType = paymentType;
    }

    @Override
    public String toString() {
        return  "   " + orderId +
                "\t   " + userId +
                "\t" + orderTotalPrice +
                "\t\t" + orderTime +
                "\t" + paymentType;
    }
}
