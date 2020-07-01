package exercise.assignment5;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 17:29
 */
public class Admin {

    private String userName;
    private String passWord;
    private boolean flag;
    public Admin ad;

    public Admin() {
    }

    public Admin(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String showInfo() {
        System.out.println("管理员信息：");
        System.out.println("用户名：" + this.userName);
        System.out.println("密码：" + this.passWord);
        return this.passWord;
    }

    public Admin check(Admin ad) {
        if (ad.userName.equals(this.userName) && ad.passWord.equals(this.passWord)) {
            System.out.println("登录成功");
            this.flag = true;
        } else {
            System.out.println("用户名或密码不正确");
        }
        return ad;
    }
}
