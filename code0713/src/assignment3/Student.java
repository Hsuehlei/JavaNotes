package assignment3;

import java.util.Objects;

/**
 * @author Lei
 * @version 1.0
 * @date 2020/7/13 21:10
 */
public class Student implements Comparable<Student> {

    private Integer id;
    private Integer score;

    public Student(Integer id, Integer score) {
        this.id = id;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.getScore();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return getId().equals(student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", score=" + score +
                '}';
    }
}
