package assignment5;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 22:24
 */
public class Account {

    private Long id;
    private Double balance;
    private String password;
    private static Long count = 100L;

    public Account(Double balance, String password) {
        this.id = ++count;
        this.balance = balance;
        this.password = password;
    }

    //set方法等需要的时候再添加
    public Long getId() {
        return id;
    }

    public Double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public static Long getCount() {
        return count;
    }
}
