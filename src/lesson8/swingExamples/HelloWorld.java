package lesson8.swingExamples;

import javax.swing.*;

public class HelloWorld extends JFrame{
    public static void main(String[] args) {
        JFrame myWindow = new HelloWorld();

        //Creating and adding a button to the container
        JButton myButton = new JButton("Click me");
        myWindow.add(myButton);
        myWindow.setSize(200,300);
        myWindow.setTitle("Hello Swing");
        myWindow.setVisible(true);
//        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }
}
