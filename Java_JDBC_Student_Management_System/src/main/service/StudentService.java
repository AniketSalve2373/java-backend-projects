package main.service;

import main.model.Student;
import java.util.List;

public interface StudentService {
    boolean addStudent(Student s);

    boolean updateStudent(Student s);

    boolean deleteStudent(int id);

    Student getStudent(int id);

    List<Student> getAll();
}
