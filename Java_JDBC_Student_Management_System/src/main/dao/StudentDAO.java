package main.dao;

import main.model.Student;
import java.util.List;

public interface StudentDAO {
    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    Student getStudentById(int id);

    List<Student> getAllStudents();
}
