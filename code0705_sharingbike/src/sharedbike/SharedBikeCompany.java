package sharedbike;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/4 19:05
 */
public class SharedBikeCompany {
    /**
     * bikeCompanyId：公司ID
     * bikeCompany：ofo、哈罗、摩拜
     * sharedBikes：公司持有共享单车
     * sum：公司单车总量
     * count：公司单车借出次数
     */
    private int bikeCompanyId;
    private String bikeCompany;
    private SharedBike[] sharedBikes;
    private int sum;
    private int count;

    public SharedBikeCompany() {
    }

    public SharedBikeCompany(int bikeCompanyId, String bikeCompany, SharedBike[] sharedBikes, int sum) {
        this.bikeCompanyId = bikeCompanyId;
        this.bikeCompany = bikeCompany;
        this.sharedBikes = sharedBikes;
        this.sum = sum;
    }

    public SharedBikeCompany(int bikeCompanyId, String bikeCompany, SharedBike[] sharedBikes, int sum, int count) {
        this.bikeCompanyId = bikeCompanyId;
        this.bikeCompany = bikeCompany;
        this.sharedBikes = sharedBikes;
        this.sum = sum;
        this.count = count;
    }

    public int getBikeCompanyId() {
        return bikeCompanyId;
    }

    public void setBikeCompanyId(int bikeCompanyId) {
        this.bikeCompanyId = bikeCompanyId;
    }

    public String getBikeCompany() {
        return bikeCompany;
    }

    public void setBikeCompany(String bikeCompany) {
        this.bikeCompany = bikeCompany;
    }

    public SharedBike[] getSharedBikes() {
        return sharedBikes;
    }

    public void setSharedBikes(SharedBike[] sharedBikes) {
        this.sharedBikes = sharedBikes;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
