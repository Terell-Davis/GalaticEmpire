package project.conquest.galatic;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class function {
    addPeopleGui people = new addPeopleGui(); static InfoGui info = new InfoGui();
    // Will make this cleaner if time allows
    /*JLabel fname = people.firstname, lname = people.lastname, topL = people.TopLeft, topR = people.TopRight,
            midL = people.MidLeft, midR = people.MidRight, botL = people.BottomLeft, botR = people.BottomRight;

    JTextField fnametxt = people.fname, lnametxt = people.lname, topLtxt = people.TopLeftTxt, topRtxt = people.TopRightTxt,
            midLtxt = people.MidLeftTxt, midRtxt = people.MidRightTxt, botLtxt = people.BottomLeftTxt, botRtxt = people.BottomRightTxt;
    public static void setCurrentTable(String x){
        info.currentTable = x;
    }

    public void set2Moff(){
        // Visability of labels & text feilds
        lname.setVisible(true); lnametxt.setVisible(true);
        botL.setVisible(false); botLtxt.setVisible(false);
        botR.setVisible(false); botLtxt.setVisible(false);

        // Label Names
        fname.setText("First Name:"); lname.setText("Last Name");
        topL.setText("Title"); topR.setText("Id Number");
        midL.setText("Home System"); midR.setText("Start Date");
    }*/

    //Something to make the line of code a little less long, pretty sure i can do this better but time limit
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
