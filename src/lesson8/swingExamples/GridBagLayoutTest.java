package lesson8.swingExamples;

import javax.swing.*;
import java.awt.*;
//Creating constraints for GridBagLayout
public class GridBagLayoutTest {
    public static void main(String[] args) {

        JPanel windowContent = new JPanel();

        //Set the GridBagLayout for the window's content pane
        GridBagLayout gb = new GridBagLayout();
        windowContent.setLayout(gb);
        //Create an instance of the GridBagConstraints
        //You'll have to repeat these lines for each component
        //that you'd like to add to the grid cell
        GridBagConstraints constraints = new GridBagConstraints();
        //setting constraints for the Calculator's displayField:
        //x coordinate in the grid
        constraints.gridx = 0;
        //y coordinate in the grid
        constraints.gridy = 0;
        //this cell has the same height as other cells
        constraints.gridheight = 1;
        //this cell is as wide as 5 other ones
        constraints.gridwidth = 5;
        //fill all space in the cell
        constraints.fill = GridBagConstraints.BOTH;
        //proportion of horizontal space taken by this
        //component
        constraints.weightx = 1.0;
        //proportion of vertical space taken by this component
        constraints.weighty = 1.0;
        //position of the component within the cell
        constraints.anchor = GridBagConstraints.CENTER;
        JTextField displayField = new JTextField();
        //set constraints for this field
        gb.setConstraints(displayField, constraints);
        //add he text field to the window
        windowContent.add(displayField);
        

        JFrame frame = new JFrame("GridBagLayout Test");
        frame.setContentPane(windowContent);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //set the size and make the window visible
        frame.setSize(400,200);
        frame.setMinimumSize(new Dimension(400,100));
        frame.setVisible(true);
    }
}
