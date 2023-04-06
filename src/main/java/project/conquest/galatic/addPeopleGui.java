package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

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
    private JTextArea errorView;


    public addPeopleGui() {
    Connection conn = function.connectdb();
    String TopL, TopR, MidL, MidR, BotR, BotL;
    OKbutton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            String FName = fname.getText(), LName = lname.getText(),
            TopL = TopLeftTxt.getText(), TopR = TopRightTxt.getText(),
            MidL = MidLeftTxt.getText(), MidR = MidRightTxt.getText(),
            BotL = BottomLeftTxt.getText(), BotR = BottomRightTxt.getText(),

            table = TitleText.getText();

            try {
                String query = "";
                if(table == "moffs"){
                    query = ("INSERT INTO " + table + " VALUES ('"+ FName +"', '" + LName +"', '"+ TopL +"','"
                            + TopR +"', '"+ MidL +"', '"+ MidR +"');");
                } else if (table == "admin") {

                }

                PreparedStatement stmt = conn.prepareStatement(query);
                System.out.println(stmt.toString());
                // INSERT INTO Moffs VALUES ('Sutton', 'Tion', '2021-03-04', 'Admiral', 'Yavin', '856839094');

                int result = stmt.executeUpdate();
                System.out.println(result + " Rows affected");
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                errorView.setText(String.valueOf(ex));
            }
        }
    });
        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TopLeftTxt.setText(""); TopRightTxt.setText("");
                MidLeftTxt.setText(""); MidRightTxt.setText("");
                BottomLeftTxt.setText(""); BottomRightTxt.setText("");
            }
        });
    }
}
