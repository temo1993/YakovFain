package lesson9.eventHandling;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngineMsg implements ActionListener {

    public void actionPerformed(ActionEvent e){
        JOptionPane.showConfirmDialog(null,
                "Something happened...",
                "Just a test",
                JOptionPane.DEFAULT_OPTION);
    }
}
