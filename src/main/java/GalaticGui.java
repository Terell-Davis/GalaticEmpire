import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public GalaticGui() {
    moff.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFrame moffFrame = new JFrame("Moff Window");

            String[] names = {"Name 1", "Name 2", "Name 3", "Name 4", "Name 5"};
            JList<String> nameList = new JList<>(names);
            JScrollPane scrollPane = new JScrollPane(nameList);

            moffFrame.getContentPane().add(scrollPane);
            moffFrame.setSize(500, 700);
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



    // Useful Function Will go here, so like 'add', 'modify', and stuff

    public void add(){
    //We will use this to add information
    }
}
