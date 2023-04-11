package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Objects;

public class InfoGui extends JFrame {
    public JPanel InfoGuiPanel;
    private JButton delete;
    private JButton add;
    private JButton modify;
    private JScrollPane namelist;
    private JTextArea infopane;
    public JTextField TableTxtField;
    private JLabel TableLabel;
    private JTextArea selectedName;
    public String currentTable;
    String query = "";

    public InfoGui() {
        function function = new function(); addPeopleGui people = new addPeopleGui(); modifyGui modpeople = new modifyGui();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                people.setContentPane(people.addgui);
                TableTxtField.setText(currentTable);

                people.TopLeft.setVisible(true); people.TopRight.setVisible(true);
                people.MidLeft.setVisible(true); people.MidRight.setVisible(true);
                people.BottomLeft.setVisible(true); people.BottomRight.setVisible(true);

                people.TopLeftTxt.setText(""); people.TopRightTxt.setText("");
                people.MidLeftTxt.setText(""); people.MidRightTxt.setText("");
                people.BottomLeftTxt.setText(""); people.BottomRightTxt.setText("");

                people.TopLeftTxt.setVisible(true); people.TopRightTxt.setVisible(true);
                people.MidLeftTxt.setVisible(true); people.MidRightTxt.setVisible(true);
                people.BottomLeftTxt.setVisible(true); people.BottomRightTxt.setVisible(true);

                if(Objects.equals(currentTable, "moffs")) {
                    people.TitleText.setText(currentTable);
                    //function.set2Moff();
                    people.TopLeft.setText("Title"); people.TopRight.setText("Id Number");
                    people.MidLeft.setText("HomeSystem"); people.MidRight.setText("Start Date (yyyy-mm-dd)");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                    people.BottomRight.setVisible(false); people.BottomRightTxt.setVisible(false);
                } else if (Objects.equals(currentTable, "campaigns")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("Campaign Name"); people.lastname.setText("Campaign #");
                    people.TopLeft.setText("Casualties"); people.TopRight.setText("Moff #");
                    people.MidLeft.setText("Status"); people.MidRight.setText("StartDate (yyyy-mm-dd)");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                    people.BottomRight.setVisible(false); people.BottomRightTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "generals")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("First Name"); people.lastname.setText("Last Name");
                    people.TopLeft.setText("Campaign #"); people.TopRight.setText("Id Number");
                    people.MidLeft.setText("Stars"); people.MidRight.setText("Start Date (yyyy-mm-dd)");
                    people.BottomRight.setText("Birthday (yyyy-mm-dd)");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "admirals")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("First Name"); people.lastname.setText("Last Name");
                    people.TopLeft.setText("Campaign #"); people.TopRight.setText("Id Number");
                    people.MidLeft.setText("Stars"); people.MidRight.setText("Start Date (yyyy-mm-dd)");
                    people.BottomRight.setText("Birthday (yyyy-mm-dd)");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "legions")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("Legion Name"); people.lastname.setText("Legion #");
                    people.TopLeft.setText("General #"); people.TopRight.setText("Base #");
                    people.MidLeft.setText("Specialty"); people.MidRight.setText("Troop Count");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                    people.BottomRight.setVisible(false); people.BottomRightTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "fleets")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("Fleet Name"); people.lastname.setText("Fleet #");
                    people.TopLeft.setText("Admiral #"); people.TopRight.setText("System");
                    people.MidLeft.setText("Ship Count");
                    people.MidRight.setVisible(false); people.MidRightTxt.setVisible(false);
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                    people.BottomRight.setVisible(false); people.BottomRightTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "stormtroopers")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("First Name"); people.lastname.setText("Last Name");
                    people.TopLeft.setText("Rank"); people.TopRight.setText("Id Number");
                    people.MidLeft.setText("Home System"); people.MidRight.setText("Birthday (yyyy-mm-dd)");
                    people.BottomRight.setText("Legion #");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "pilots")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("First Name"); people.lastname.setText("Last Name");
                    people.TopLeft.setText("Rank"); people.TopRight.setText("Id Number");
                    people.MidLeft.setText("Home System"); people.MidRight.setText("Birthday (yyyy-mm-dd)");
                    people.BottomRight.setText("Fleet #");
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "base")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("Name"); people.lastname.setText("Base #");
                    people.TopLeft.setText("System");people.TopRight.setText("coordinates");
                    people.MidLeft.setText("Status");
                    people.MidRight.setVisible(false); people.MidRightTxt.setVisible(false);
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                    people.BottomRight.setVisible(false); people.BottomRightTxt.setVisible(false);
                }else if (Objects.equals(currentTable, "systems")) {
                    people.TitleText.setText(currentTable);

                    people.firstname.setText("Name");
                    people.lastname.setVisible(false); people.lname.setVisible(false);
                    people.TopLeft.setText("Moon");people.TopRight.setText("coordinates");
                    people.MidLeft.setText("Status");
                    people.MidRight.setVisible(false); people.MidRightTxt.setVisible(false);
                    people.BottomLeft.setVisible(false); people.BottomLeftTxt.setVisible(false);
                    people.BottomRight.setVisible(false);people.BottomRightTxt.setVisible(false);
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

                modpeople.setContentPane(new JPanel());
                modpeople.setContentPane(modpeople.modifyPanel);

                // Autofill name from the one currently selected - wip will do if time allows
                String[] name = selectedName.split(" ");

                Connection conn = function.connectdb();

                if (Objects.equals(currentTable, "moffs") || Objects.equals(currentTable, "generals") ||
                        Objects.equals(currentTable, "admirals") || Objects.equals(currentTable, "stormtroppers") ||
                        Objects.equals(currentTable, "pilots")) {
                    query = "UPDATE " + currentTable + " SET ";

                try {
                    // Execute the SQL query to retrieve data of the selected Moff
                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + currentTable + " WHERE " +
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


            }
                modpeople.setSize(600, 200);
                modpeople.setVisible(true);
                modpeople.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            }
        });
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                people.TitleText.setText(currentTable);
                Connection conn = function.connectdb();
                JList<String> list = (JList<String>) namelist.getViewport().getView();
                String selectedName = list.getSelectedValue();
                System.out.println(selectedName);
                String[] Firstname = selectedName.split(" ");

                if(Objects.equals(currentTable, "moffs") || Objects.equals(currentTable, "generals") ||
                        Objects.equals(currentTable, "admirals") || Objects.equals(currentTable, "stormtroppers") ||
                        Objects.equals(currentTable, "pilots")){
                    String query = "DELETE FROM " + currentTable + " WHERE FirstName=?";
                    try {
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, Firstname[0]);
                        int result = stmt.executeUpdate();
                        System.out.println(result + " rows deleted");
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else if (Objects.equals(currentTable, "campaigns") || Objects.equals(currentTable, "legions") ||
                        Objects.equals(currentTable, "fleets") || Objects.equals(currentTable, "base") ||
                        Objects.equals(currentTable, "systems")) {
                    String query = "DELETE FROM " + currentTable + " WHERE Name=?";
                    try {
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, selectedName);
                        int result = stmt.executeUpdate();
                        System.out.println(result + " rows deleted");
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
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