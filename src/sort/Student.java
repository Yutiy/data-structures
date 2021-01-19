package sort;

import java.util.Objects;

/**
 * Author: yutiy
 * Date: 2020/12/12 下午8:21
 * Email: 494657028@qq.com
 */
public class Student implements Comparable<Student>  {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student another) {
        return score - another.score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return String.format("sort.search.Student(name %s, score %d)", name, score);
    }
}
