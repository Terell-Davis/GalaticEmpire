package project.conquest.galatic;

import javax.swing.*;
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
    private JPanel MoffPanel;
public GalaticGui(){

    moff.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Moff moffFrame = new Moff();
            moffFrame.setContentPane(moffFrame.moffPanel);

            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/galacticconquest", "Testuser", "Test123!");

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
    public static void main(String[] args) throws ClassNotFoundException {

        GalaticGui gui = new GalaticGui();
        gui.setContentPane(gui.Main);
        gui.setTitle("Galatic Conquest Database");
        gui.setSize(500, 700);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    // Useful Function Will go here, so like 'add', 'modify', and stuff

    public void add(){
    //We will use this to add information
    }
}
