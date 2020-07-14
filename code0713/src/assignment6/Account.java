package assignment6;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 22:24
 */
public class Account {

    private long id = 0;
    private double balance;
    private String password;

    public Account(double balance, String password) {
        this.balance = balance;
        this.password = password;
    }

    @Override
    public String toString() {
        return  "balance=" + balance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
