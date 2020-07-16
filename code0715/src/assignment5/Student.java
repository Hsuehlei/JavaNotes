package assignment5;

import java.io.Serializable;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/16 15:07
 */
public class Student implements Serializable {

    private String id;
    private String name;
    private char gender;

    public String show() {
        return  "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }
}
