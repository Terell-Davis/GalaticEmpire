package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class modifyGui extends JFrame {
    public JPanel modifyPanel;
    public JTextField MidR;
    public JTextField BotL;
    public JTextField BotR;
    public JTextField MidL;
    public JButton Submit;
    public JTextField TopR;
    public JTextField TopL;
    public JTextField ModifyDisplay;
    public JLabel LabelTopR;
    public JLabel LabelTopL;
    public JLabel LabelMidL;
    public JLabel LabelMidR;
    public JLabel LabelBotL;
    public JLabel LabelBotR;
    public JTextField fnameTxt;
    public JTextField lnameTxt;
    public JLabel fname;
    public JLabel lname;
    private JButton pullbutton;
    public String selectedName;

    public String currentTable;

    public modifyGui() {
        Connection conn = function.connectdb();
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectedName);

                String query = "UPDATE " + currentTable + " SET";

            }
        });
        pullbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectedName);
                if(Objects.equals(currentTable, "moffs") || Objects.equals(currentTable, "generals") ||
                        Objects.equals(currentTable, "admirals") || Objects.equals(currentTable, "stormtroppers") ||
                        Objects.equals(currentTable, "pilots")){
                    String query = "SELECT * FROM " + currentTable + " WHERE FirstName=? AND LastName=?";
                    try {
                        String[] Firstname = selectedName.split(" ");
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, Firstname[0]);
                        stmt.setString(2, Firstname[1]);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            if(Objects.equals(currentTable, "moffs")){
                                fnameTxt.setText(rs.getString("FirstName"));
                                lnameTxt.setText(rs.getString("LastName"));
                                TopL.setText(rs.getString("Title"));
                                TopR.setText(rs.getString("Idnumber"));
                                MidL.setText(rs.getString("Homesystem"));
                                MidR.setText(rs.getString("StartDate"));
                            } else if (Objects.equals(currentTable, "generals") ||
                                    Objects.equals(currentTable, "admirals")) {
                                fnameTxt.setText(rs.getString("FirstName"));
                                lnameTxt.setText(rs.getString("LastName"));
                                TopL.setText(rs.getString("CampaignNumber"));
                                TopR.setText(rs.getString("Idnumber"));
                                MidL.setText(rs.getString("Stars"));
                                MidR.setText(rs.getString("StartDate"));
                                BotR.setText(rs.getString("BirthDate"));
                            } else if (Objects.equals(currentTable, "stormtroppers") ||
                                    Objects.equals(currentTable, "pilots")) {
                                fnameTxt.setText(rs.getString("FirstName"));
                                lnameTxt.setText(rs.getString("LastName"));
                                TopL.setText(rs.getString("Rank"));
                                TopR.setText(rs.getString("Idnumber"));
                                MidL.setText(rs.getString("Homesystem"));
                                MidR.setText(rs.getString("BirthDate"));
                                BotR.setText(rs.getString(6));
                            }
                        }
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else if (Objects.equals(currentTable, "campaigns") || Objects.equals(currentTable, "legions") ||
                        Objects.equals(currentTable, "fleets") || Objects.equals(currentTable, "base") ||
                        Objects.equals(currentTable, "systems")) {
                    String query = "SELECT FROM " + currentTable + " WHERE Name=?";
                    try {
                        PreparedStatement stmt = conn.prepareStatement(query);
                        stmt.setString(1, selectedName);

                        ResultSet rs = stmt.executeQuery();

                        if (rs.next()) {
                            if(Objects.equals(currentTable, "campaigns")){
                                fnameTxt.setText(rs.getString("Name"));
                                lnameTxt.setText(rs.getString("campaignnumber"));
                                TopL.setText(rs.getString("Casualties"));
                                TopR.setText(rs.getString("moffnumber"));
                                MidL.setText(rs.getString("Status"));
                                MidR.setText(rs.getString("StartDate"));
                            } else if (Objects.equals(currentTable, "legions")) {
                                
                            }
                        }


                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }
}
