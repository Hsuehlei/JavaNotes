package sharedbike_v2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/6 14:41
 */
public class ShareBike {

    /**
     * bid：单车编号
     * bName：单车名称 -> ofo、哈罗、摩拜
     * status：单车状态 -> 0，已借出；1，可借状态
     * borrowTime：单车借出时间
     */
    private int bid;
    private String bName;
    private int status;
    private String borrowTime;

    public ShareBike() {
    }

    public ShareBike(int bid, String bName, int status, String borrowTime) {
        this.bid = bid;
        this.bName = bName;
        this.status = status;
        this.borrowTime = borrowTime;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getBorrowTime() {
        return borrowTime;
    }

    public void setBorrowTime(String borrowTime) {
        this.borrowTime = borrowTime;
    }
}
