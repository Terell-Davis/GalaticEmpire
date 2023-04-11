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
    private JButton stormtroopersButton;
    private JButton fleetButton;
    private JButton legionButton;
    private JButton admiralButton;
    private JButton generalButton;
    private JButton baseButton;
    private JButton systemButton;
    private JPanel Main;
   // private JPanel MoffPanel;
public GalaticGui(){
    function function = new function(); addPeopleGui people = new addPeopleGui();
    InfoGui info = new InfoGui();
    moff.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "moffs";

            try {
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT FirstName, LastName FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    String firstname = rs.getString("FirstName");
                    String lastname = rs.getString("LastName");
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
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE FirstName=? AND LastName=?");

                                String[] names = selectedName.split(" ");
                                stmt.setString(1, names[0]);
                                stmt.setString(2, names[1]);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("This Moff name is " + rs.getString("FirstName")
                                            + " " + rs.getString("LastName") +
                                            "\n Start Date: " + rs.getDate("StartDate").toString() +
                                            "\n This Moff title is: " + rs.getString("Title") +
                                            "\n ID: " + rs.getInt("IdNumber") +
                                            "\n The home system for this moff is " + rs.getString("HomeSystem"));
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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });
    campaign.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "campaigns";

            try{
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("Name"));
                }

                JList<String> list = new JList<>(model);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Connection conn = function.connectdb();
                        if (!e.getValueIsAdjusting()) {
                            String selectedName = list.getSelectedValue();

                            try {
                                // Execute the SQL query to retrieve data of the selected Moff
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE Name=?");

                                stmt.setString(1, selectedName);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("Name: " + rs.getString("Name") +
                                            "\nCampaign #: " + rs.getString("CampaignNumber") +
                                            "\n Start Date : " + rs.getString("StartDate") +
                                            "\n Moff #: " + rs.getString("MoffNumber") +
                                            "\n Casualties: " + rs.getString("Casualties") +
                                            "\n Status: " + rs.getString("Status"));

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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
    });
    generalButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "generals";

            try {
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT FirstName, LastName FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    String firstname = rs.getString("FirstName");
                    String lastname = rs.getString("LastName");
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
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE FirstName=? AND LastName=?");

                                String[] names = selectedName.split(" ");
                                stmt.setString(1, names[0]);
                                stmt.setString(2, names[1]);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("This General name is " + rs.getString("FirstName")
                                            + " " + rs.getString("LastName") +
                                            "\n Start Date: " + rs.getDate("StartDate").toString() +
                                            "\n Stars: " + rs.getString("Stars") +
                                            "\n ID: " + rs.getInt("IdNumber") +
                                            "\n The Campaign Number " + rs.getString("CampaignNumber"));
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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });
    admiralButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            {
                Connection conn = function.connectdb();
                info.setContentPane(info.InfoGuiPanel);
                info.currentTable = "admirals";

                try {
                    // Execute the SQL query
                    PreparedStatement stmt = conn.prepareStatement("SELECT FirstName, LastName FROM " + info.currentTable);
                    ResultSet rs = stmt.executeQuery();

                    // Retrieve the results
                    DefaultListModel<String> model = new DefaultListModel<>();
                    while (rs.next()) {
                        String firstname = rs.getString("FirstName");
                        String lastname = rs.getString("LastName");
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
                                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +" WHERE " +
                                            "FirstName=? AND LastName=?");

                                    String[] names = selectedName.split(" ");
                                    stmt.setString(1, names[0]);
                                    stmt.setString(2, names[1]);
                                    ResultSet rs = stmt.executeQuery();

                                    // Retrieve all info and display it in the info pane
                                    if (rs.next()) {
                                        info.getInfopane().setText("This Admiral name is " + rs.getString("FirstName")
                                                + " " + rs.getString("LastName") +
                                                "\n Start Date: " + rs.getDate("StartDate").toString() +
                                                "\n Stars: " + rs.getString("Stars") +
                                                "\n ID: " + rs.getInt("IdNumber") +
                                                "\n The Campaign Number " + rs.getString("CampaignNumber"));
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
                    JScrollPane scrollPane = info.getNamelist();
                    scrollPane.setViewportView(list);
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                info.setSize(700, 700);
                info.setVisible(true);
                info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        }
    });
    legionButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "legions";

            try{
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("Name"));
                }

                JList<String> list = new JList<>(model);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Connection conn = function.connectdb();
                        if (!e.getValueIsAdjusting()) {
                            String selectedName = list.getSelectedValue();

                            try {
                                // Execute the SQL query to retrieve data of the selected Moff
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE Name=?");

                                stmt.setString(1, selectedName);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("Name: " + rs.getString("Name") +
                                            "\nLegion #: " + rs.getString("Number") +
                                            "\nGeneral # : " + rs.getString("GeneralNumber") +
                                            "\nBase #: " + rs.getString("BaseNumber") +
                                            "\nTropp Count: " + rs.getString("TroopCount") +
                                            "\nSpecialty: " + rs.getString("Specialty"));

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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });
    fleetButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "fleets";

            try{
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("Name"));
                }

                JList<String> list = new JList<>(model);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Connection conn = function.connectdb();
                        if (!e.getValueIsAdjusting()) {
                            String selectedName = list.getSelectedValue();

                            try {
                                // Execute the SQL query to retrieve data of the selected Moff
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE Name=?");

                                stmt.setString(1, selectedName);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("Name: " + rs.getString("Name") +
                                            "\nFleet #: " + rs.getString("Number") +
                                            "\nAdmiral # : " + rs.getString("AdmiralNumber") +
                                            "\nSystem: " + rs.getString("Systems") +
                                            "\nShip Count: " + rs.getString("ShipCount"));

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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    });
    stormtroopersButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            {
                Connection conn = function.connectdb();
                info.setContentPane(info.InfoGuiPanel);
                info.currentTable = "stormtroopers";

                try {
                    // Execute the SQL query
                    PreparedStatement stmt = conn.prepareStatement("SELECT FirstName, LastName FROM " + info.currentTable);
                    ResultSet rs = stmt.executeQuery();

                    // Retrieve the results
                    DefaultListModel<String> model = new DefaultListModel<>();
                    while (rs.next()) {
                        String firstname = rs.getString("FirstName");
                        String lastname = rs.getString("LastName");
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
                                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +" WHERE " +
                                            "FirstName=? AND LastName=?");

                                    String[] names = selectedName.split(" ");
                                    stmt.setString(1, names[0]);
                                    stmt.setString(2, names[1]);
                                    ResultSet rs = stmt.executeQuery();

                                    // Retrieve all info and display it in the info pane
                                    if (rs.next()) {
                                        info.getInfopane().setText("This StormTrooper name is " + rs.getString("FirstName")
                                                + " " + rs.getString("LastName") +
                                                "\n Birth Date: " + rs.getDate("BirthDate").toString() +
                                                "\n Rank: " + rs.getString("TroopRank") +
                                                "\n ID: " + rs.getInt("IdNumber") +
                                                "\n Legion #: " + rs.getInt("LegionNumber") +
                                                "\n Home System: " + rs.getString("HomeSystem"));
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
                    JScrollPane scrollPane = info.getNamelist();
                    scrollPane.setViewportView(list);
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                info.setSize(700, 700);
                info.setVisible(true);
                info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        }
    });
    pioltsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            {
                Connection conn = function.connectdb();
                info.setContentPane(info.InfoGuiPanel);
                info.currentTable = "pilots";

                try {
                    // Execute the SQL query
                    PreparedStatement stmt = conn.prepareStatement("SELECT FirstName, LastName FROM " + info.currentTable);
                    ResultSet rs = stmt.executeQuery();

                    // Retrieve the results
                    DefaultListModel<String> model = new DefaultListModel<>();
                    while (rs.next()) {
                        String firstname = rs.getString("FirstName");
                        String lastname = rs.getString("LastName");
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
                                    PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +" WHERE " +
                                            "FirstName=? AND LastName=?");

                                    String[] names = selectedName.split(" ");
                                    stmt.setString(1, names[0]);
                                    stmt.setString(2, names[1]);
                                    ResultSet rs = stmt.executeQuery();

                                    // Retrieve all info and display it in the info pane
                                    if (rs.next()) {
                                        info.getInfopane().setText("This Pilot name is " + rs.getString("FirstName")
                                                + " " + rs.getString("LastName") +
                                                "\n Birth Date: " + rs.getDate("BirthDate").toString() +
                                                "\n Rank: " + rs.getString("TroopRank") +
                                                "\n ID: " + rs.getInt("IdNumber") +
                                                "\n Fleet #: " + rs.getInt("FleetNumber") +
                                                "\n Home System: " + rs.getString("HomeSystem"));
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
                    JScrollPane scrollPane = info.getNamelist();
                    scrollPane.setViewportView(list);
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                info.setSize(700, 700);
                info.setVisible(true);
                info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }

        }
    });
    baseButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "base";

            try{
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("Name"));
                }

                JList<String> list = new JList<>(model);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Connection conn = function.connectdb();
                        if (!e.getValueIsAdjusting()) {
                            String selectedName = list.getSelectedValue();

                            try {
                                // Execute the SQL query to retrieve data of the selected Moff
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE Name=?");

                                stmt.setString(1, selectedName);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("Name: " + rs.getString("Name") +
                                            "\nBase #: " + rs.getString("Number") +
                                            "\n System: " + rs.getString("Systems") +
                                            "\n Coordinates: " + rs.getString("Coordinates") +
                                            "\n Status: " + rs.getString("Status"));
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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
    });
    systemButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Connection conn = function.connectdb();
            info.setContentPane(info.InfoGuiPanel);
            info.currentTable = "systems";

            try{
                // Execute the SQL query
                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable);
                ResultSet rs = stmt.executeQuery();

                // Retrieve the results
                DefaultListModel<String> model = new DefaultListModel<>();
                while (rs.next()) {
                    model.addElement(rs.getString("Name"));
                }

                JList<String> list = new JList<>(model);
                list.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        Connection conn = function.connectdb();
                        if (!e.getValueIsAdjusting()) {
                            String selectedName = list.getSelectedValue();

                            try {
                                // Execute the SQL query to retrieve data of the selected Moff
                                PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + info.currentTable +
                                        " WHERE Name=?");

                                stmt.setString(1, selectedName);
                                ResultSet rs = stmt.executeQuery();

                                // Retrieve all info and display it in the info pane
                                if (rs.next()) {
                                    info.getInfopane().setText("Name: " + rs.getString("Name") +
                                            "\nMoon(s): " + rs.getString("MoonCount") +
                                            "\n Coordinates: " + rs.getString("Coordinates") +
                                            "\n Status: " + rs.getString("Status"));
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
                JScrollPane scrollPane = info.getNamelist();
                scrollPane.setViewportView(list);
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            info.setSize(700, 700);
            info.setVisible(true);
            info.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        }
    });
}
    public static void main(String[] args)
    {
        GalaticGui gui = new GalaticGui();
        gui.setContentPane(gui.Main);
        gui.setTitle("Galatic Conquest Database");
        gui.setSize(500, 700);
        gui.setVisible(true);
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
