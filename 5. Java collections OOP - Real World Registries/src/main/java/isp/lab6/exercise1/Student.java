package isp.lab6.exercise1;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private Long id;
    private String name;
    private Map<String, Integer> studentGrades = new HashMap<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Map<String, Integer> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(Map<String, Integer> studentGrades) {
        this.studentGrades = studentGrades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentGrades=" + studentGrades +
                '}';
    }


}
