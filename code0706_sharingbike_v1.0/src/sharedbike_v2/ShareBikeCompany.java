package sharedbike_v2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/6 14:50
 */
public class ShareBikeCompany implements Share {

    private int id;
    private String bikeCompanyName;
    private ShareBike[] shareBikes;
    private int sum;
    private int count;

    @Override
    public void putBike(ShareBike shareBike) {
        //单车需不需要扩容
        int length = this.shareBikes.length;
        if (length == sum) {
            //仓库不足，需要扩容
            this.shareBikes = Arrays.copyOf(shareBikes, length + length / 2);
        }
        shareBike.setStatus(1);
        shareBike.setBorrowTime("");

        //添加单车对象到数组中
        this.shareBikes[sum] = shareBike;
        sum++;
        System.out.println("实际单车总量现在是：" + sum);
        System.out.println("=====投放成功=====");
    }

    @Override
    public ShareBike[] selectBike() {
        return this.shareBikes;
    }

    @Override
    public void deleteBike(int id) {
        if (sum == 0) {
            System.out.println("已经没有单车可删除了");
            return;
        }
        //删除单车的
        //删除后，后面的数组元素需要前移
        for (int i = 0; i < sum; i++) {
            if (id == this.shareBikes[i].getBid()) {
                for (int j = i; j < sum - 1; j++) {
                    shareBikes[j] = shareBikes[j + 1];
                }
                shareBikes[sum - 1] = null;
                sum--;
                System.out.println("=====删除成功=====");
                return;
            }
        }
        System.out.println("=====删除失败=====");
    }

    @Override
    public void lendBike(int id) {
        if (sum == 0) {
            System.out.println("已经没有单车可外借了");
            return;
        }
        //找到单车
        for (int i = 0; i < sum; i++) {
            if (id == this.shareBikes[i].getBid()) {
                //判断单车状态
                if (this.shareBikes[i].getStatus() == 0) {
                    System.out.println("此单车已借出，请换一辆");
                    return;
                } else {
                    this.shareBikes[i].setStatus(0);
                    //获取系统时间，格式yyyy-MM-dd
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    long currentTimeMillis = System.currentTimeMillis();
                    String lendTime = simpleDateFormat.format(currentTimeMillis);
                    this.shareBikes[i].setBorrowTime(lendTime);
                    System.out.println("借出时间是：" + lendTime);
                    count++;
                    System.out.println("=====单车借出成功=====");
                    return;
                }
            }
        }
        System.out.println("=====单车不存在，借出失败=====");
    }

    @Override
    public void returnBike(int id) {
        for (int i = 0; i < sum; i++) {
            if (id == this.shareBikes[i].getBid()) {
                if (this.shareBikes[i].getStatus()==1) {
                    System.out.println("单车未借出，勿需归还");
                    return;
                }
                System.out.println("=====归还中=====");
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    String returnTime = simpleDateFormat.format(currentTimeMillis);
                    System.out.println("还车时间为：" + returnTime);
                    Date parse = simpleDateFormat.parse(this.shareBikes[i].getBorrowTime());
                    long lendTime = parse.getTime();
                    double useBikeTime = (currentTimeMillis - lendTime)/1000.0;
                    //假设1秒钟0.02分
                    double charge = useBikeTime * 0.02;
                    System.out.println("用车时长是：" + useBikeTime + "秒");
                    System.out.println("共需支付：" + String.format("%.1f",charge) + "元");
                    System.out.println("=====单车归还成功=====");
                    this.shareBikes[i].setStatus(1);
                    this.shareBikes[i].setBorrowTime("");
                    return;
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("=====单车归还失败=====");
    }

    public ShareBikeCompany() {
    }

    public ShareBikeCompany(int id, String bikeCompanyName, ShareBike[] shareBikes, int sum, int count) {
        this.id = id;
        this.bikeCompanyName = bikeCompanyName;
        this.shareBikes = shareBikes;
        this.sum = sum;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBikeCompanyName() {
        return bikeCompanyName;
    }

    public void setBikeCompanyName(String bikeCompanyName) {
        this.bikeCompanyName = bikeCompanyName;
    }

    public ShareBike[] getShareBikes() {
        return shareBikes;
    }

    public void setShareBikes(ShareBike[] shareBikes) {
        this.shareBikes = shareBikes;
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
