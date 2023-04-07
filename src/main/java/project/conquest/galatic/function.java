package project.conquest.galatic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class function {
    addPeopleGui people = new addPeopleGui(); static InfoGui info = new InfoGui();

    public static void setCurrentTable(String x){
        info.currentTable = x;
    }

    public void set2Moff(){
        people.TopLeft.setText("StartDate");
        people.TopRight.setText("Title");
        people.MidLeft.setText("HomeSystem");
        people.MidRight.setText("IdNumber");
        people.BottomLeft.setVisible(false);
        people.BottomRight.setVisible(false);
        people.BottomRightTxt.setVisible(false);
        people.BottomLeftTxt.setVisible(false);
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
