package laba4.task1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SessionDataTest {
    private SessionData sessionData;

    @BeforeEach
    public void setup() {
        sessionData = new SessionData();
        sessionData.addStudent(new Student("Иванов Иван Иванович", 1, "Математика", 5));
        sessionData.addStudent(new Student("Петров Петр Петрович", 1, "Физика", 4));
        sessionData.addStudent(new Student("Сидорова Елена Петровна", 1, "История", 3));
    }

    @Test
    public void testGetExpelledStudents() {
        List<Student> expelledStudents = sessionData.getExpelledStudents();
        assertEquals(0, expelledStudents.size());
    }

    @Test
    public void testGetStudentsWithAcademicDebt() {
        List<Student> academicDebtStudents = sessionData.getStudentsWithAcademicDebt();
        assertEquals(1, academicDebtStudents.size());
        assertFalse(academicDebtStudents.contains(new Student("Сидорова Елена Петровна", 1, "История", 3)));
    }

    @Test
    public void testGetSuccessfulStudents() {
        List<Student> successfulStudents = sessionData.getSuccessfulStudents();
        assertEquals(2, successfulStudents.size());
        assertFalse(successfulStudents.contains(new Student("Иванов Иван Иванович", 1, "Математика", 5)));
        assertFalse(successfulStudents.contains(new Student("Петров Петр Петрович", 1, "Физика", 4)));
    }
}