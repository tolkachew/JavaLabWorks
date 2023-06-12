package laba4.task1;

import java.io.*;
import java.util.*;

public class SessionData {
    private List<Student> students;

    public SessionData() {
        this.students = new ArrayList<>();
    }

    public void loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                if (data.length == 4) {
                    String name = data[0];
                    int course = Integer.parseInt(data[1]);
                    String discipline = data[2];
                    int grade = Integer.parseInt(data[3]);
                    Student student = new Student(name, course, discipline, grade);
                    students.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }

    public void saveToFile(String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student student : students) {
                String line = student.getName() + ";" + student.getCourse() + ";" +
                        student.getDiscipline() + ";" + student.getGrade();
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи файла: " + e.getMessage());
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public List<Student> getExpelledStudents() {
        List<Student> expelledStudents = new ArrayList<>();
        Map<String, Integer> failedExamsCount = new HashMap<>();

        for (Student student : students) {
            String key = student.getName() + student.getCourse();
            int count = failedExamsCount.getOrDefault(key, 0);
            if (student.getGrade() < 4) {
                count++;
            }
            failedExamsCount.put(key, count);
            if (count >= 3) {
                expelledStudents.add(student);
            }
        }

        return expelledStudents;
    }

    public List<Student> getStudentsWithAcademicDebt() {
        List<Student> academicDebtStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.getGrade() < 4) {
                academicDebtStudents.add(student);
            }
        }

        return academicDebtStudents;
    }

    public List<Student> getSuccessfulStudents() {
        List<Student> successfulStudents = new ArrayList<>(students);

        successfulStudents.removeAll(getStudentsWithAcademicDebt());

        return successfulStudents;
    }

    public void printStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("ФИО: " + student.getName());
            System.out.println("Курс: " + student.getCourse());
            System.out.println("Дисциплина: " + student.getDiscipline());
            System.out.println("Оценка: " + student.getGrade());
            System.out.println("------------");
        }
    }

    public void printSuccessfulStudentsSortedByAverageGrade() {
        List<Student> successfulStudents = getSuccessfulStudents();
        Map<Integer, List<Student>> studentsByCourse = new HashMap<>();

        for (Student student : successfulStudents) {
            int course = student.getCourse();
            List<Student> students = studentsByCourse.getOrDefault(course, new ArrayList<>());
            students.add(student);
            studentsByCourse.put(course, students);
        }

        for (int course : studentsByCourse.keySet()) {
            List<Student> students = studentsByCourse.get(course);
            students.sort(Comparator.comparingDouble(this::calculateAverageGrade).reversed());
            System.out.println("Курс " + course + ":");
            printStudents(students);
        }
    }

    private double calculateAverageGrade(Student student) {
        double sum = 0.0;
        int count = 0;
        for (Student s : students) {
            if (s.getCourse() == student.getCourse()) {
                sum += s.getGrade();
                count++;
            }
        }
        return count > 0 ? sum / count : 0.0;
    }
}