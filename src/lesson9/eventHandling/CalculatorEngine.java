package lesson9.eventHandling;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        //Get the source object of this action
        JButton clickedButton = (JButton) e.getSource();
        //Get the button's label
        String clickedButtonLabel = clickedButton.getText();
        //Concatenate the button's label
        //to the text of the message box
        JOptionPane.showConfirmDialog(null, "You pressed --> " + clickedButtonLabel,
                "Just a test", JOptionPane.DEFAULT_OPTION);
    }
}
