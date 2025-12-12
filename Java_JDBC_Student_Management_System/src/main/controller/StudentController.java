package main.controller;

import java.util.Scanner;
import main.model.Student;
import main.service.StudentService;
import main.service.StudentServiceImpl;

public class StudentController {

    StudentService service = new StudentServiceImpl();
    Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Get by ID");
            System.out.println("5. Get All");
            System.out.println("6. Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> getById();
                case 5 -> getAll();
                case 6 -> System.exit(0);
            }
        }
    }

    private void addStudent() {
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Course: ");
        String course = sc.next();

        Student s = new Student(0, name, age, course);
        System.out.println(service.addStudent(s) ? "Added!" : "Failed!");
    }

    private void updateStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = sc.nextInt();
        System.out.print("Course: ");
        String course = sc.next();

        Student s = new Student(id, name, age, course);
        System.out.println(service.updateStudent(s) ? "Updated!" : "Failed!");
    }

    private void deleteStudent() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.println(service.deleteStudent(id) ? "Deleted!" : "Failed!");
    }

    private void getById() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        Student s = service.getStudent(id);
        System.out.println(s != null ? s : "Not Found!");
    }

    private void getAll() {
        service.getAll().forEach(System.out::println);
    }
}
