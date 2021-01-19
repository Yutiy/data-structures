package search;

import java.util.Objects;

/**
 * Author: yutiy
 * Date: 2020/12/12 下午8:21
 * Email: 494657028@qq.com
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }
}
