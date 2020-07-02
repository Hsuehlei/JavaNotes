package assignment1;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/2 16:43
 */
public class Pet {

    private String name;
    private char gender;
    private String experience;
    private int rank;

    public Pet() {
    }

    public Pet(String name, char gender, String experience, int rank) {
        this.name = name;
        this.gender = gender;
        this.experience = experience;
        this.rank = rank;
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

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void followMaster() {
        System.out.println("我在跟随主人");
    }

    public void eat() {
        System.out.println("我能吃东西");
    }
}
