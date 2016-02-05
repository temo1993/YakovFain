package lesson8.swingExamples;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutTest {
    public static void main(String[] args) {

        JPanel windowContent = new JPanel();
        windowContent.setLayout(new BoxLayout(windowContent,BoxLayout.Y_AXIS));
        JButton bt1 = new JButton("Button1");
        JButton bt2 = new JButton("Button2");
        JButton bt3 = new JButton("Button3");
        JButton bt4 = new JButton("Button4");
        JButton bt5 = new JButton("Button5");
        JButton bt6 = new JButton("Button6");
        JButton bt7 = new JButton("Button7");

        windowContent.add(bt1);
        windowContent.add(bt2);
        windowContent.add(bt3);
        windowContent.add(bt4);
        windowContent.add(bt5);
        windowContent.add(bt6);
        windowContent.add(bt7);

        JFrame frame = new JFrame("BoxLayout Test");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set the size and make the window visible
        frame.setSize(400,200);
        frame.setMinimumSize(new Dimension(400,100));
        frame.setVisible(true);
    }
}
