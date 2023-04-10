package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import static project.conquest.galatic.function.info;

public class addPeopleGui extends JFrame {
    public JPanel addgui;
    public JTextField fname;
    public JLabel firstname;
    public JLabel lastname;
    public JTextField lname;
    public JTextField TopLeftTxt;
    public JTextField TopRightTxt;
    public JTextField MidLeftTxt;
    public JTextField MidRightTxt;
    public JLabel TopLeft;
    public JLabel MidLeft;
    public JLabel TopRight;
    public JLabel MidRight;
    public JTextField BottomLeftTxt;
    public JTextField BottomRightTxt;
    public JLabel BottomLeft;
    public JLabel BottomRight;
    public JButton OKbutton;
    public JButton ClearButton;
    public JTextField TitleText;
    public JLabel TitleLabel;
    String query = "";
    public addPeopleGui() {
    Connection conn = function.connectdb();
    OKbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String FName = fname.getText(), LName = lname.getText(),
                    TopL = TopLeftTxt.getText(), TopR = TopRightTxt.getText(),
                    MidL = MidLeftTxt.getText(), MidR = MidRightTxt.getText(),
                    BotL = BottomLeftTxt.getText(), BotR = BottomRightTxt.getText();
            String table = TitleText.getText();

            System.out.println("The current table is: " + table);

            if (table.equals("moffs")) {
                // INSERT INTO Moffs VALUES ('Sutton', 'Tion', '2021-03-04', 'Admiral', 'Yavin', '856839094');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + LName + "', '" + MidR + "','"
                        + TopL + "', '" + MidL + "', '" + TopR + "');";
            } else if (table.equals("campaigns")) {
                // INSERT INTO Campaigns VALUES ('Operation: Knightfall', '749275395', '198765432', 'Victory', '1975-03-07', '5378');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + TopR + "', '" + LName + "','"
                        + MidL + "', '" + MidR + "', '" + TopL + "');";
            } else if (table.equals("admirals") || table.equals("generals")) {
                // INSERT INTO Admirals VALUES ('Zara', 'Krefayn', '381928372', '1981-06-08', '817654329', '4', '1950-04-23');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + LName + "', '" + TopR + "','"
                        + MidR + "', '" + TopL + "', '" + MidL + "','" + BotR + "');";
            } else if (table.equals("legions")) {
                // INSERT INTO Legions VALUES ('41st Elite Corps', '760473057', '143276589', '659278134', '3864', 'Jungle and Urban Warfare');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + LName + "', '" + TopL + "','"
                        + TopR + "', '" + MidR + "', '" + MidL + "');";
            } else if (table.equals("fleets")) {
                // INSERT INTO Fleets VALUES ('Tenth Fleet', '245789637', '587319462', 'Geonosis', '80');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + LName + "', '" + TopL + "','"
                        + TopR + "', '" + MidL + "');";
            } else if (table.equals("stormtroopers") || table.equals("pilots")) {
                // INSERT INTO Stormtroopers VALUES ('CC-2224', 'Cody', '256478913', 'Kamino', '1979-11-08', 'Commander', '760473057');
                // INSERT INTO Pilots VALUES ('Kael', 'Valtor', '840172936', 'Ord Mantell', '2000-10-10', 'Captain', '58759650');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + LName + "', '" + TopR + "','"
                        + MidL + "', '" + MidR + "', '" + TopL + "', '" + BotR + "');";
            } else if (table.equals("base")) {
                // INSERT INTO Base VALUES ('Jedi Temple', '987126354', 'Coruscant', 'Destroyed', '0,10,20');
                query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + LName + "', '" + TopL + "','"
                        + MidL + "', '" + TopR + "');";
            }else if (table.equals("systems")){
                    // INSERT INTO Systems VALUES ('Utapau', '385,358,90', '6', 'Controlled');
                    query = "INSERT INTO " + table + " VALUES ('" + FName + "', '" + TopR + "', '" + TopL + "','"
                            + MidL + "');";
            }

            System.out.println(query);
            try {
                PreparedStatement stmt = conn.prepareStatement(query);
                System.out.println(stmt.toString());

                int result = stmt.executeUpdate();
                System.out.println(result + " Rows affected");
                stmt.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fname.setText(""); lname.setText("");
                TopLeftTxt.setText(""); TopRightTxt.setText("");
                MidLeftTxt.setText(""); MidRightTxt.setText("");
                BottomLeftTxt.setText(""); BottomRightTxt.setText("");
            }
        });
    }
}
