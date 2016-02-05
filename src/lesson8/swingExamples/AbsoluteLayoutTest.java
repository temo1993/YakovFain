package lesson8.swingExamples;

import javax.swing.*;
import java.awt.*;

public class AbsoluteLayoutTest {
    public static void main(String[] args) {

        JPanel windowContent = new JPanel();
        windowContent.setLayout(null);
        JButton myButton = new JButton("New Game");
        myButton.setBounds(100,200,150,20);

        windowContent.add(myButton);


        JFrame frame = new JFrame("Absolute Layout Test");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set the size and make the window visible
        frame.setSize(400,400);
        frame.setMinimumSize(new Dimension(400,300));
        frame.setVisible(true);
    }
}
