package main.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import main.model.Student;
import main.util.DBConnection;

public class StudentDAOImpl implements StudentDAO {

    private Connection conn;

    public StudentDAOImpl() {
        conn = DBConnection.getConnection(); // Load DB connection once
    }

    @Override
    public boolean addStudent(Student s) {
        String sql = "INSERT INTO students(name, age, course) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student s) {
        String sql = "UPDATE students SET name=?, age=?, course=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s.getName());
            ps.setInt(2, s.getAge());
            ps.setString(3, s.getCourse());
            ps.setInt(4, s.getId());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        String sql = "DELETE FROM students WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudentById(int id) {
        String sql = "SELECT * FROM students WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"));

                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
