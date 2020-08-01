package common;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/28 9:54
 */
public class KeyNotFoundException extends Exception {

    private String msg;

    public KeyNotFoundException(String msg) {
        this.msg = msg;
    }
}
