package entity;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/27 20:34
 */
public class OrderDetail {

    private Integer id;
    private Integer orderId;
    private Integer buyId;
    private Integer buyCount;

    public OrderDetail(Integer id, Integer orderId, Integer buyId, Integer buyCount) {
        this.id = id;
        this.orderId = orderId;
        this.buyId = buyId;
        this.buyCount = buyCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getBuyId() {
        return buyId;
    }

    public void setBuyId(Integer buyId) {
        this.buyId = buyId;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    @Override
    public String toString() {
        return  "    " + id +
                "\t\t" + orderId +
                "\t\t" + buyId +
                "\t\t" + buyCount;
    }
}
