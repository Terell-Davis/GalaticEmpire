import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = "jdbc:mysql://localhost:3306/company";
        String user = "Testuser";
        String password = "Test123!";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);

            // Do something with the connection here

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee");

            while (rs.next()){
                String name = rs.getString("fname");
                int ssn = rs.getInt("ssn");
                System.out.println(name + " is " + ssn + " is the SSN.");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}