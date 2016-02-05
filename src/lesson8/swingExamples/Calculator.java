package lesson8.swingExamples;

import lesson9.eventHandling.CalculatorEngine;

import javax.swing.*;
import java.awt.*;

public class Calculator {
    //Declare all calculator's components
    JPanel windowContent;
    JTextField displayField;
    JButton button0;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JButton button5;
    JButton button6;
    JButton button7;
    JButton button8;
    JButton button9;
    JButton buttonPoint;
    JButton buttonEqual;
    JPanel p1;

    //Instantiating CalculatorEngine object that implements ActionListener
    CalculatorEngine msg = new CalculatorEngine();

    //Constructor creates the components
    //and adds the to the frame using combination of
    //BorderLayout and Gridlayout

    public Calculator() {
        windowContent = new JPanel();
        //Set layout manager for this panel
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        //Create the display field and place it in the
        //North area of the window
        displayField = new JTextField(30);
        windowContent.add("North", displayField);
        //Create buttons using constructors of the
        //class JButton that takes the label of the
        //button as a parameter
        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonPoint = new JButton(".");
        buttonEqual = new JButton("=");

        //Adding listeners for each button
        button0.addActionListener(msg);
        button1.addActionListener(msg);
        button2.addActionListener(msg);
        button3.addActionListener(msg);
        button4.addActionListener(msg);
        button5.addActionListener(msg);
        button6.addActionListener(msg);
        button7.addActionListener(msg);
        button8.addActionListener(msg);
        button9.addActionListener(msg);
        buttonPoint.addActionListener(msg);
        buttonEqual.addActionListener(msg);
        //Create the panel with GridLayout with 12 buttons -
        //10 numeric ones, period, and the equal sign
        p1 = new JPanel();
        GridLayout gl = new GridLayout(4,3);
        p1.setLayout(gl);
        //Add window controls to the panel p1
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        //Add the panel p1 to the center of the window
        windowContent.add("Center" , p1);
        //Create the frame and set its content pane
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        //Set the size of the window big enough
        //to accommodate all controls
        frame.pack();
        //Display the window
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Calculator();

    }
}
