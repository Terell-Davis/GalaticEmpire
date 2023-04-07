package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class InfoGui extends JFrame {
    public JPanel InfoGuiPanel;
    private JButton delete;
    private JButton add;
    private JButton modify;
    private JScrollPane namelist;
    private JTextArea infopane;
    private JTextField TableTxtField;
    private JLabel TableLabel;
    private JTextArea selectedName;
    public String currentTable;

    public InfoGui() {
        function function = new function(); addPeopleGui people = new addPeopleGui();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                people.setContentPane(people.addgui);
                TableTxtField.setText(currentTable);
                people.TopLeftTxt.setText(""); people.TopRightTxt.setText("");
                people.MidLeftTxt.setText(""); people.MidRightTxt.setText("");
                people.BottomLeftTxt.setText(""); people.BottomRightTxt.setText("");

                if(currentTable == "moffs") {
                    people.TitleText.setText(currentTable);
                    function.set2Moff();
                    //Set the Text for the Labels for Moffs

                    people.TopLeft.setText("StartDate");
                    people.TopRight.setText("Title");
                    people.MidLeft.setText("HomeSystem");
                    people.MidRight.setText("IdNumber");
                    people.BottomLeft.setVisible(false);
                    people.BottomRight.setVisible(false);
                    people.BottomRightTxt.setVisible(false);
                    people.BottomLeftTxt.setVisible(false);
                } else if (currentTable == "campaigns") {
                    people.TitleText.setText(currentTable);
                    people.firstname.setText("Campaign Name");
                    people.lastname.setVisible(false); people.lname.setVisible(false);
                    people.TopLeft.setText("Campaign #");
                    people.TopRight.setText("Moff #");
                    people.MidLeft.setText("StartDate");
                    people.MidRight.setText("Casualties");
                    people.BottomLeft.setText("Status");
                    people.BottomRight.setVisible(false);
                    people.BottomRightTxt.setVisible(false);
                }else if (currentTable == "generals") {
                    people.TitleText.setText(currentTable);
                    people.TopLeft.setText("Start Date");
                    people.TopRight.setText("Birth Date");
                    people.MidLeft.setText("Campaign #");
                    people.MidRight.setText("IdNumber");
                    people.BottomLeft.setText("Stars");
                    people.BottomRight.setVisible(false);
                    people.BottomRightTxt.setVisible(false);

                }


                people.setSize(600, 250);
                people.setVisible(true);
                people.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


            }
        });
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                people.TitleText.setText(currentTable);
                JList<String> list = (JList<String>) namelist.getViewport().getView();
                String selectedName = list.getSelectedValue();

                people.setContentPane(people.addgui);

                // Autofill name from the one currently selected
                String[]name = selectedName.split(" ", 2);
                people.fname.setText(name[0]); people.lname.setText(name[1]);

                Connection conn = function.connectdb();
                    try {
                        // Execute the SQL query to retrieve data of the selected Moff
                        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + currentTable +" WHERE " +
                                "FirstName=? AND LastName=?");

                        String[] names = selectedName.split(" ");
                        stmt.setString(1, names[0]);
                        stmt.setString(2, names[1]);
                        ResultSet rs = stmt.executeQuery();

                        // Retrieve all info and display it in the info pane
                        if (rs.next()) {
                        }
                        rs.close();
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }










                people.setSize(600, 200);
                people.setVisible(true);
                people.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                people.TitleText.setText(currentTable);
                JList<String> list = (JList<String>) namelist.getViewport().getView();
                String selectedName = list.getSelectedValue();



            }
        });
    }

    public JScrollPane getNamelist(){
        return namelist;
    }

    public JTextArea getInfopane(){
        return infopane;
    }
}