package isp.lab6.exercise1;

public class Exercise1 {
    public static void main(String[] args) {

        StudentManager studentManager = new StudentManager();

        Student student1 = new Student(1L,"Alice");
        student1.getStudentGrades().put("Math",9); //get pentru a accesa map - put pentru a adauga in map
        studentManager.addStudent(student1);

        Student student2 = new Student(2L,"John");
        student2.getStudentGrades().put("Math",10); //get pentru a accesa map - put pentru a adauga in map
        studentManager.addStudent(student2);

        studentManager.displayAllStudents();

        studentManager.addStudentGrades(2L,"Physics",10);
        studentManager.displayAllStudents();

        studentManager.removeStudent(student1);
        studentManager.displayAllStudents();

        student2.setName("John JOHN");
        student2.getStudentGrades().put("Math",9);
        studentManager.displayAllStudents();

        System.out.println(studentManager.averageGrade(1L));
        System.out.println(studentManager.averageGrade(2L));

        studentManager.displayAllStudents();

    }
}