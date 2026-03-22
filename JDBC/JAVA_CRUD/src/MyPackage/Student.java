package MyPackage;

import java.sql.*;

public class Student {
    public void createDatabase() {

        try {
            // load driver, connection establish, create statement, execute query and get,
            // close connection

            String url = "jdbc:mysql://localhost:3306";
            String user = "root";
            String password = "Aniket@123";

            Connection con = DriverManager.getConnection(url, user, password);
            Statement st = con.createStatement();
            String query = "create database DatabaseForJDBC2";
            st.execute(query);
            System.out.println("database created succcessfully");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // e.printStackTrace()
        }
    }

    public void createTable() {
        try {
            // load driver, connection establish, create statement, execute query and get,
            // close connection

            String url = "jdbc:mysql://localhost:3306";
            String db = "DatabaseForJDBC2";
            String user = "root";
            String password = "Aniket@123";

            Connection con = DriverManager.getConnection(url + "/" + db, user, password);
            Statement st = con.createStatement();
            String query = "CREATE TABLE student (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50) NOT NULL, age INT NOT NULL, city VARCHAR(50))";
            st.execute(query);
            System.out.println("table created succcessfully");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // e.printStackTrace()
        }
    }

    public void insertDataInTable() {
        try {
            // load driver, connection establish, create statement, execute query and get,
            // close connection

            String url = "jdbc:mysql://localhost:3306";
            String db = "DatabaseForJDBC2";
            String user = "root";
            String password = "Aniket@123";

            Connection con = DriverManager.getConnection(url + "/" + db, user, password);
            String query = "INSERT INTO student (name, age, city) VALUES (?,?,?)";

            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, "parag");
            pstm.setInt(2, 23);
            pstm.setString(3, "Pune");

            pstm.execute();
            System.out.println("data inserted succcessfully");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // e.printStackTrace()
        }
    }

    public void readTable() {
        try {
            // load driver, connection establish, create statement, execute query and get,
            // close connection

            String url = "jdbc:mysql://localhost:3306";
            String db = "DatabaseForJDBC2";
            String user = "root";
            String password = "Aniket@123";

            Connection con = DriverManager.getConnection(url + "/" + db, user, password);
            Statement st = con.createStatement();
            String query = "SELECT * FROM student";

            // st.execute(query);

            // to see the result we use following way
            ResultSet result = st.executeQuery(query);
            while (result.next()) {
                System.out.println("id   : " + result.getInt(1));
                System.out.println("name : " + result.getString(2));
                System.out.println("age  : " + result.getInt(3));
                System.out.println("city : " + result.getString(4));
            } // result displayed successfully

            System.out.println("table read succcessfully");
            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // e.printStackTrace()
        }
    }

    public void updateDataInTable() {
        try {
            String url = "jdbc:mysql://localhost:3306";
            String db = "DatabaseForJDBC2";
            String user = "root";
            String password = "Aniket@123";

            Connection con = DriverManager.getConnection(url + "/" + db, user, password);

            String query = "UPDATE student SET name=?, age=?, city=? WHERE id=?";

            PreparedStatement pstm = con.prepareStatement(query);

            // Set new values
            pstm.setString(1, "aniket"); // new name
            pstm.setInt(2, 24); // new age
            pstm.setString(3, "Mumbai"); // new city

            // Which row to update? (id=1)
            pstm.setInt(4, 1); // condition

            int rows = pstm.executeUpdate();

            if (rows > 0)
                System.out.println("Data updated successfully");
            else
                System.out.println("No record found with that ID");

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deleteDataFromTable() {
        try {
            String url = "jdbc:mysql://localhost:3306";
            String db = "DatabaseForJDBC2";
            String user = "root";
            String password = "Aniket@123";

            Connection con = DriverManager.getConnection(url + "/" + db, user, password);

            String query = "DELETE FROM student WHERE id=?";

            PreparedStatement pstm = con.prepareStatement(query);

            // Which row to delete? (Example: id = 1)
            pstm.setInt(1, 1);

            int rows = pstm.executeUpdate();

            if (rows > 0)
                System.out.println("Data deleted successfully");
            else
                System.out.println("No record found with that ID");

            con.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
