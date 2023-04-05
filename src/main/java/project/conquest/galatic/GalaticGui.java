package project.conquest.galatic;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GalaticGui extends JFrame {
    private JButton moff;
    private JButton campaign;
    private JButton pioltsButton;
    private JButton stromtroopersButton;
    private JButton fleetButton;
    private JButton legionButton;
    private JButton admiralButton;
    private JButton generalButton;
    private JButton baseButton;
    private JButton systemButton;
    private JPanel Main;
   // private JPanel MoffPanel;
public GalaticGui(){
    function function = new function();
    moff.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            Moff moffFrame = new Moff();
            moffFrame.setContentPane(moffFrame.moffPanel);

            try {
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT fname, lname FROM moff");
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    String firstname = rs.getString("fname");
                    String lastname = rs.getString("lname");
                    model.addElement(firstname + " " + lastname);
                }

                // Display the results
                JList<String> list = new JList<>(model);

                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Connection conn = function.connectdb();
                        if (!e.getValueIsAdjusting()) {
                            String selectedName = list.getSelectedValue();

                            try {
                                // Execute the SQL query to retrieve data of the selected Moff
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM moff WHERE fname=? AND lname=?");
                                String[] names = selectedName.split(" ");
                                stmt.setString(1, names[0]);
                                stmt.setString(2, names[1]);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    String fname = rs.getString("fname");
                                    String lname = rs.getString("lname");
                                    Date seniority = rs.getDate("seniority");
                                    String title = rs.getString("title");
                                    int moffnum = rs.getInt("moffnum");
                                    String homesystem = rs.getString("homesystem");
                                    moffFrame.getInfopane().setText("This Moff name is " + fname + " " + lname +
                                            "\n Start Date: " + seniority.toString() +
                                            "\n This Moff title is: " + title + " ID: " + moffnum +
                                            "\n The home system for this moff is " + homesystem);
                                }
                                rs.close();
                                stmt.close();
                                conn.close();
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                });
                JScrollPane scrollPane = moffFrame.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            moffFrame.setSize(700, 700);
            moffFrame.setVisible(true);
            moffFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });
}
    public static void main(String[] args) {

        GalaticGui gui = new GalaticGui();
        gui.setContentPane(gui.Main);
        gui.setTitle("Galatic Conquest Database");
        gui.setSize(500, 700);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
