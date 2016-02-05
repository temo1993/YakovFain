package lesson8.swingExamples;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {

        JPanel windowContent = new JPanel();
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        JTextField txtDisplay = new JTextField(20);
        JCheckBox checkBox = new JCheckBox("Check me");
        JMenu jMenu = new JMenu("This menu");

        windowContent.add(BorderLayout.NORTH, txtDisplay);
        windowContent.add(BorderLayout.CENTER, checkBox);
        windowContent.add(BorderLayout.SOUTH, jMenu);

        JFrame frame = new JFrame("BorderLayout Test");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set the size and make the window visible
        frame.setSize(400,100);
        frame.setMinimumSize(new Dimension(400,100));
        frame.setVisible(true);
    }
}
