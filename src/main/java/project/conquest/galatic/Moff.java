package project.conquest.galatic;

import javax.swing.*;

public class Moff extends JFrame {
    public JPanel moffPanel;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JScrollPane namelist;

    public JScrollPane getNamelist(){
        return namelist;
    }



    /*public static void main(String[] args) {
        Moff moffFrame = new Moff();
        moffFrame.setContentPane(moffFrame.moffPanel);
        moffFrame.setSize(500, 700);
        moffFrame.setVisible(true);
        moffFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }*/
}