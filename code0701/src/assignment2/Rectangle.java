package exercise.assignment2;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/1 16:50
 */
public class Rectangle {

    private double high;
    private double width;

    public Rectangle() {
    }

    public Rectangle(double high, double width) {
        this.high = high;
        this.width = width;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double area() {
        return this.high * this.width;
    }

    public double perimeter() {
        return this.width * 2 + this.high * 2;
    }
}
