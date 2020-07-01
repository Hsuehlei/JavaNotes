package exercise.assignment6;

import java.util.Random;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 18:54
 */
public class Vip {

    private int vipId;
    private String vipName;
    private int score;
    public Vip v;

    public Vip() {
    }

    public Vip(int vipId, String vipName, int score) {
        this.vipId = vipId;
        this.vipName = vipName;
        this.score = score;
    }

    public int getVipId() {
        return vipId;
    }

    public void setVipId(int vipId) {
        this.vipId = vipId;
    }

    public String getVipName() {
        return vipName;
    }

    public void setVipName(String vipName) {
        this.vipName = vipName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Vip check(Vip v) {
        if (v.vipId > 999 && v.vipId < 10000) {
            System.out.println("会员号合法，已保存会员号信息");
            System.out.print("今天");
            discount(v);
            lottery(v);
        } else {
            System.out.println("会员号不合法，已退出");
        }

        return v;
    }

    public Vip lottery(Vip v) {
        System.out.println("---------");
        Random r = new Random();
        int x = r.nextInt(8999) + 1 + 1000;
        if (x == v.vipId) {
            System.out.println("恭喜你，你是今天的幸运会员！");
        } else {
            System.out.println("不是幸运会员，再接再厉！");
        }
        return v;
    }

    public Vip discount(Vip v) {
        if (v.score >= 10000) {
            System.out.println("六折！");
        } else if (v.score > 8000) {
            System.out.println("七折！");
        } else if (v.score > 6000) {
            System.out.println("八折！");
        } else if (v.score > 4000) {
            System.out.println("九折！");
        } else {
            System.out.println("不打折！");
        }
        return v;
    }
}

