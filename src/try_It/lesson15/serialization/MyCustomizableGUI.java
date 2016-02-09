package try_It.lesson15.serialization;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MyCustomizableGUI extends JPanel{

	private JTextField textField;
	private JDialog prefDialog;

	private JComboBox color;
	private JComboBox font;
	private JComboBox fontSize;

	MyCustomizableGUI () {
		
		this.setLayout (new BoxLayout(this, BoxLayout.Y_AXIS));
		textField = new JTextField (20);
		JButton buttonPref = new JButton("Preferences");
		
		this.add(textField);
		this.add(buttonPref);
		
		buttonPref.addActionListener (evt ->
		                              prefDialog.setVisible(true));

		JFrame frame = new JFrame("My text editor");
		frame.setContentPane(this);
		frame.pack();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
			
		// Preferences dialog box
		prefDialog = new JDialog(frame, "Dialog", true);
		prefDialog.setLayout (new BorderLayout());
		JPanel p1 = new JPanel();
		p1.setLayout (new GridLayout(3,2));
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2, BoxLayout.X_AXIS));

		JButton buttonSave = new JButton("Save");
		JButton buttonCancel = new JButton("Cancel");
		
		buttonSave.addActionListener (evtSave -> {
				
				String fontChosen;
				int fontSizeChosen;
				
				prefDialog.setVisible(false);
				
				if ((String) color.getSelectedItem() == "Red") {
					textField.setForeground(Color.red);
				} else if ((String) color.getSelectedItem() == "Green") {
					textField.setForeground(Color.green);
				} else if ((String) color.getSelectedItem() == "Blue") {
					textField.setForeground(Color.blue);
				} else if ((String) color.getSelectedItem() == "Cyan") {
					textField.setForeground(Color.cyan);
				} else if ((String) color.getSelectedItem() == "Magenta") {
					textField.setForeground(Color.magenta);
				}else if ((String) color.getSelectedItem() == "Yellow") {
					textField.setForeground(Color.yellow);
				}else if ((String) color.getSelectedItem() == "Black") {
					textField.setForeground(Color.black);
				}

				fontChosen = (String) font.getSelectedItem();
				fontSizeChosen = Integer.parseInt((String) fontSize.getSelectedItem());
				textField.setFont(new Font(fontChosen, Font.PLAIN, fontSizeChosen));

				UserPreferences userPrefs = new UserPreferences();
				userPrefs.setColor((String) color.getSelectedItem());
				userPrefs.setFont(fontChosen);
				userPrefs.setFontSize(fontSizeChosen);

				try (FileOutputStream fileOut =
                             new FileOutputStream("src/try_It/lesson15/serialization/files/preferences.ser");
					 ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)){

					objectOut.writeObject(userPrefs);

				} catch (IOException ioe) {
					System.out.println("I/O error: " + ioe.getMessage());
				}
			});

		buttonCancel.addActionListener (evt -> prefDialog.setVisible(false));

		JLabel colorLabel = new JLabel("Color:");
		JLabel fontLabel = new JLabel("Font:");
		JLabel fontSizeLabel = new JLabel("Font size:");
		String[] colorList = {"Red", "Green", "Blue", "Cyan", "Magenta", "Yellow", "Black"};
		color = new JComboBox(colorList);
		String[] fontList = {"Arial", "Times New Roman", "Helvetica"};
		font = new JComboBox(fontList);
		String[] fontSizeList = {"12", "18", "25", "40", "64"};
		fontSize = new JComboBox(fontSizeList);

		p1.add(colorLabel);
		p1.add(color);
		p1.add(fontLabel);
		p1.add(font);
		p1.add(fontSizeLabel);
		p1.add(fontSize);
		p2.add(buttonCancel);
		p2.add(buttonSave);

		prefDialog.add(BorderLayout.NORTH, p1);
		prefDialog.add(BorderLayout.SOUTH, p2);

		prefDialog.pack();
	}
	
	public void setFont (String f, int fs) {
		textField.setFont(new Font(f, Font.PLAIN, fs));	
	}
	
	public static void main(String[] args) {
		
		MyCustomizableGUI custGUI = new MyCustomizableGUI();
		UserPreferences savedPrefs;
		
		try (FileInputStream fileIn = new FileInputStream("src/try_It/lesson15/serialization/files/preferences.ser");
			 ObjectInputStream objectIn = new ObjectInputStream (fileIn)) {
				
			savedPrefs = (UserPreferences) objectIn.readObject();	
			
			if ( savedPrefs.getColor().contains("Red")) {
				custGUI.textField.setForeground(Color.red);
				custGUI.color.setSelectedItem("Red");
			} else if (savedPrefs.getColor().contains("Green")) {
				custGUI.textField.setForeground(Color.green);
				custGUI.color.setSelectedItem("Green");
			} else if (savedPrefs.getColor().contains("Blue")) {
				custGUI.textField.setForeground(Color.blue);
				custGUI.color.setSelectedItem("Blue");
			} else if (savedPrefs.getColor().contains("Cyan")) {
				custGUI.textField.setForeground(Color.cyan);
				custGUI.color.setSelectedItem("Cyan");
			} else if (savedPrefs.getColor().contains("Magenta")) {
				custGUI.textField.setForeground(Color.magenta);
				custGUI.color.setSelectedItem("Magenta");
			}else if (savedPrefs.getColor().contains("Yellow")) {
				custGUI.textField.setForeground(Color.yellow);
				custGUI.color.setSelectedItem("Yellow");
			}else if (savedPrefs.getColor().contains("Black")) {
				custGUI.textField.setForeground(Color.black);
				custGUI.color.setSelectedItem("Black");
			}
			
			custGUI.setFont(savedPrefs.getFont(), savedPrefs.getFontSize());
			custGUI.font.setSelectedItem(savedPrefs.getFont());
			custGUI.fontSize.setSelectedItem("" + savedPrefs.getFontSize());
			
		} catch (FileNotFoundException noFile) {
			// load default font and color
			custGUI.setFont("Arial", 25);
			custGUI.textField.setForeground(Color.black);
			
		} catch (ClassNotFoundException noPrefs) {
			noPrefs.printStackTrace();
		} catch (IOException e) {
			 System.out.println("I/O Error: " + e.getMessage());
		} 
	}
}