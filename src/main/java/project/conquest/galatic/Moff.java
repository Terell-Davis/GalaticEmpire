package project.conquest.galatic;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Moff extends JFrame {
    public JPanel moffPanel;
    private JButton delete;
    private JButton add;
    private JButton modify;
    private JScrollPane namelist;
    private JTextArea infopane;
    private JTextArea selectedName;

    public Moff() {
        function function = new function();
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addPeopleGui people = new addPeopleGui();
                people.setContentPane(people.addgui);

                //Set the Text for the Labels for Moffs
                people.TopLeft.setText("Top"); people.TopRight.setText("Test");
                people.MidLeft.setText("Maybe"); people.MidRight.setText("Work");
                people.BottomLeft.setVisible(false); people.BottomRight.setVisible(false);
                people.BottomRightTxt.setVisible(false); people.BottomLeftTxt.setVisible(false);





                people.setSize(600, 200);
                people.setVisible(true);
                people.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


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