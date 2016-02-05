package lesson9.eventHandling;

import javax.swing.*;

public class Calculator extends JFrame{
    public static void main(String[] args) {
        JFrame myWindow = new Calculator();
        JButton myButton = new JButton("Click me");
        CalculatorEngineMsg msg = new CalculatorEngineMsg();
        myButton.addActionListener(msg);
        myWindow.add(myButton);
        myWindow.setSize(300,300);
        myWindow.setTitle("Best Calc");
        myWindow.setVisible(true);
        myWindow.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
