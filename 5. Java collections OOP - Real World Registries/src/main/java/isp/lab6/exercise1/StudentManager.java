package isp.lab6.exercise1;

import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private List<Student> studentList = new ArrayList<>(); // instantiem pentru a nu avea null pointer exception error

    public boolean addStudent(Student student) {
        return studentList.add(student); // returneaza deja boolean true daca s-a adaugat in lista
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    void displayAllStudents() {
        for (Student student : studentList)
            System.out.println(student);
    }

    public boolean addStudentGrades(Long studentId, String subject, Integer grade) {
        for (Student student : studentList)
            if (student.getId().equals(studentId)) {
                student.getStudentGrades().put(subject, grade);
                return true;
            }
        return false;
    }

    public boolean removeStudent(Student student) {
        return studentList.remove(student);
    }

    public double averageGrade(Long studentId) {
        int nr = 0;
        double sum = 0.0;
        for (Student student : studentList) {
            if (student.getId().equals(studentId)) {
                for (Integer grade : student.getStudentGrades().values()) {
                    sum = sum + grade;
                    nr++;
                }
            }
        }
        if (nr > 0) return (double) (sum / nr);

        else {
            System.out.println("Niciun student");
            return 0.0;
        }
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent(long id) {
        for (Student student : studentList) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }
}
