package isp.lab6.exercise1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestExercise1 {

    private StudentManager studentManager;
    private Student student1;
    private Student student2;

    @Before
    public void setUp() {
        studentManager = new StudentManager();

        student1 = new Student(1L, "Alice");
        student1.getStudentGrades().put("Math", 9);

        student2 = new Student(2L, "John");
        student2.getStudentGrades().put("Math", 10);

        studentManager.addStudent(student1);
        studentManager.addStudent(student2);
    }

    @Test
    public void testAddStudent() {
        Student student3 = new Student(3L, "Bob");
        studentManager.addStudent(student3);

        assertNotNull(studentManager.getStudent(3L));
    }

    @Test
    public void testRemoveStudent() {
        studentManager.removeStudent(student1);

        assertNull(studentManager.getStudent(1L));
    }

    @Test
    public void testAddStudentGrades() {
        studentManager.addStudentGrades(2L, "Physics", 10);

        assertEquals(Integer.valueOf(10),
                studentManager.getStudent(2L).getStudentGrades().get("Physics"));
    }

    @Test
    public void testAverageGradeSingleSubject() {
        double avg = studentManager.averageGrade(1L);

        assertEquals(9.0, avg, 0.01);
    }

    @Test
    public void testAverageGradeMultipleSubjects() {
        studentManager.addStudentGrades(2L, "Physics", 10);
        studentManager.addStudentGrades(2L, "English", 8);

        double avg = studentManager.averageGrade(2L);

        assertEquals(9.33, avg, 0.01); // (10 + 10 + 8) / 3
    }

    @Test
    public void testUpdateGrade() {
        student2.getStudentGrades().put("Math", 7);

        assertEquals(Integer.valueOf(7),
                studentManager.getStudent(2L).getStudentGrades().get("Math"));
    }

    @Test
    public void testStudentNotFoundAverage() {
        double avg = studentManager.averageGrade(99L);

        assertEquals(0.0, avg, 0.01); // depinde de implementare
    }
}
