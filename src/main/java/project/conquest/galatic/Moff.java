package project.conquest.galatic;

import javax.swing.*;

public class Moff extends JFrame {
    public JPanel moffPanel;
    private JButton delete;
    private JButton add;
    private JButton modify;
    private JScrollPane namelist;
    private JTextArea infopane;
    private JTextArea selectedName;

    public JScrollPane getNamelist(){
        return namelist;
    }

    public JTextArea getInfopane(){
        return infopane;
    }
}