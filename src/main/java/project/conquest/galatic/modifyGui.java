package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public modifyGui() {
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(selectedName);

            }
        });
        pullbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
