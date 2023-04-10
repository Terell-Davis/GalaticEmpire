package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public modifyGui() {
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
