package lesson13.lambda;

import javax.swing.*;
import java.awt.event.ActionEvent;

public	class	MethodReferenceSample	extends JFrame {
    public	void	processButtonClick(ActionEvent actionEvent){
        System.out.println("Someone	clicked	on	the	button");
    }

    public	static	void	main(String	args[]){
        MethodReferenceSample	mrs	=	new	MethodReferenceSample();
        JButton	myButton	=	new	JButton("Click	me");
        mrs.add(myButton);

        myButton.addActionListener(mrs::processButtonClick);
        //Same as with Lambda
        myButton.addActionListener(event -> System.out.println("Someone	clicked	on	the	button"));

        mrs.pack();
        mrs.setVisible(true);
        mrs.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}