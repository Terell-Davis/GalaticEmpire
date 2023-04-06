package project.conquest.galatic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class function {

    public void add(){

    }

    public static Connection connectdb() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/galacticempire", "Testuser", "Test123!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
