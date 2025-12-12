package main.service;

import main.dao.StudentDAO;
import main.dao.StudentDAOImpl;
import main.model.Student;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDAO dao = new StudentDAOImpl();

    @Override
    public boolean addStudent(Student s) {
        return dao.addStudent(s);
    }

    @Override
    public boolean updateStudent(Student s) {
        return dao.updateStudent(s);
    }

    @Override
    public boolean deleteStudent(int id) {
        return dao.deleteStudent(id);
    }

    @Override
    public Student getStudent(int id) {
        return dao.getStudentById(id);
    }

    @Override
    public List<Student> getAll() {
        return dao.getAllStudents();
    }
}
