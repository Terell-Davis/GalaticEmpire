package project.conquest.galatic;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class function {
    addPeopleGui people = new addPeopleGui(); static InfoGui info = new InfoGui();

    JLabel fname = people.firstname, lname = people.lastname, topL = people.TopLeft, topR = people.TopRight,
            midL = people.MidLeft, midR = people.MidRight, botL = people.BottomLeft, botR = people.BottomRight;

    public static void setCurrentTable(String x){
        info.currentTable = x;
    }

    public void set2Moff(){
        // Visability of labels
        people.lastname.setVisible(true); people.lname.setVisible(true);
        people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
        people.BottomRight.setVisible(false); people.BottomRightTxt.setVisible(false);



        //people.TopLeft.setText("StartDate");
        people.TopRight.setText("Title");
        people.MidLeft.setText("HomeSystem");
        people.MidRight.setText("IdNumber");




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
