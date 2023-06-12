package laba4.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SessionData sessionData = new SessionData();

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        sessionData.loadFromFile(fileName);

        boolean exit = false;
        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1. Просмотреть данные");
            System.out.println("2. Добавить нового студента");
            System.out.println("3. Редактировать данные студента");
            System.out.println("4. Удалить студента");
            System.out.println("5. Вывести список отчисленных студентов");
            System.out.println("6. Вывести список студентов с академическими задолженностями");
            System.out.println("7. Вывести список успешных студентов, отсортированный по среднему баллу");
            System.out.println("8. Выйти");

            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    sessionData.printStudents(sessionData.getSuccessfulStudents());
                    break;
                case 2:
                    System.out.print("Введите имя студента: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите курс: ");
                    int course = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите дисциплину: ");
                    String discipline = scanner.nextLine();
                    System.out.print("Введите оценку: ");
                    int grade = scanner.nextInt();
                    scanner.nextLine();
                    Student newStudent = new Student(name, course, discipline, grade);
                    sessionData.addStudent(newStudent);
                    break;
                case 3:
                    System.out.print("Введите индекс студента для редактирования: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    if (index >= 0 && index < sessionData.getSuccessfulStudents().size()) {
                        Student student = sessionData.getSuccessfulStudents().get(index);
                        System.out.print("Введите новую оценку: ");
                        int newGrade = scanner.nextInt();
                        scanner.nextLine();
                        student.setGrade(newGrade);
                        System.out.println("Данные студента успешно обновлены.");
                    } else {
                        System.out.println("Студент с указанным индексом не найден.");
                    }
                    break;
                case 4:
                    System.out.print("Введите индекс студента для удаления: ");
                    int removeIndex = scanner.nextInt();
                    scanner.nextLine();
                    if (removeIndex >= 0 && removeIndex < sessionData.getSuccessfulStudents().size()) {
                        Student student = sessionData.getSuccessfulStudents().get(removeIndex);
                        sessionData.removeStudent(student);
                        System.out.println("Студент успешно удален.");
                    } else {
                        System.out.println("Студент с указанным индексом не найден.");
                    }
                    break;
                case 5:
                    sessionData.printStudents(sessionData.getExpelledStudents());
                    break;
                case 6:
                    sessionData.printStudents(sessionData.getStudentsWithAcademicDebt());
                    break;
                case 7:
                    sessionData.printSuccessfulStudentsSortedByAverageGrade();
                    break;
                case 8:
                    sessionData.saveToFile(fileName);
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }
            System.out.println();
        }
    }
}