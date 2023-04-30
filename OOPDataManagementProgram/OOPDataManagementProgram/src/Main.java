import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuItem;

//ABSTRACT: line 23-41
//Encapsulation: line 34-55
//Inheritance: line 27,58 & line 201-202
//Polymorphism: line 61-82 & 147-158
abstract class Abstraction{
	
	abstract void go();
	
	void errorMessage() {//This method is used in Inheritance
		JOptionPane.showMessageDialog(null, "The text field is empty");
	}
}

class Abstract extends Abstraction{
	
	Encapsulation capsule = new Encapsulation("The Item is already in the list");

	@Override
	void go() {
		JOptionPane.showMessageDialog(null, capsule.getPrompt());
	}
	
}
//Encapsulation
//I used the encapsulation inside the Abstract class (Line 34)
class Encapsulation{
	
	private String prompt;
	
	Encapsulation(String prompt){
		this.prompt = prompt;
	}
	
	public String getPrompt() {
		return prompt;
	}
}

//Inheritance inherits the Abstract class which is a subclass of a parent class
class Inheritance extends Abstract{
	//Read Line 201-202
	
	public void printAboutTheProgram() {
		JOptionPane.showMessageDialog(null, "Polymorphism thing");
		
	}
	
}

//Polymorphism
class Polymorphism1 extends Inheritance {
	public void printAboutTheProgram() {
		JOptionPane.showMessageDialog(null, "The program is about Data Management and applying the 4 pillars of OOPs");
		
	}
}

class Polymorphism2 extends Inheritance {
	public void printAboutTheProgram() {
		JOptionPane.showMessageDialog(null, "This program is like a To-do List, but a grocery /market list");
		JOptionPane.showMessageDialog(null, "Click the 'Add Button' to add data");
		JOptionPane.showMessageDialog(null, "Click the 'Clear List Button' to clear the data");
	}
}

public class Main extends JFrame {
	
	private JPanel contentPane;
	private JTextField gcTextField;
	private JTextField nameTextField;
	
	static JTextArea textAria = new JTextArea();
	static JButton addButton = new JButton("Add");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	HashMap<String, String> reservation;

	
	boolean createReservation(String gf, String name) {
		if(reservation.containsKey(gf)) {
			Abstract abstrct = new Abstract();
			abstrct.go();
			return false;
		}else {
			reservation.put(gf, name);
			textAria.append(gf + " : " + name + "\n");
			return true;
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Simple Data Management Program");

		reservation = new HashMap<String, String>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 439);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("About");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Polymorphism1 poly1 = new Polymorphism1();
				poly1.printAboutTheProgram();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("How to use");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Polymorphism2 poly2 = new Polymorphism2();
				poly2.printAboutTheProgram();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JLabel lblNewLabel_2 = new JLabel("< Click this");
		menuBar.add(lblNewLabel_2);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Grocery list");
		panel.add(lblNewLabel);
		
		gcTextField = new JTextField();
		gcTextField.setToolTipText("");
		panel.add(gcTextField);
		gcTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Quantity(Optional)");
		panel.add(lblNewLabel_1);
		
		nameTextField = new JTextField();
		panel.add(nameTextField);
		nameTextField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(gcTextField.getText().equals("")) {
					
					//Inherit's the Method from the sub class(Abstract) 
					//of the parent class(Abstraction)
					
					Inheritance inherit = new Inheritance();
					inherit.errorMessage();
					
					
					System.out.println("The textfield is empty");
				}else {
					String gf = gcTextField.getText();
					String name = nameTextField.getText();
					
					createReservation(gf, name);
					
				}

			}
		});
	
		panel_1.add(addButton);
		
		JButton btnNewButton_1 = new JButton("Clear List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAria.setText("");
				reservation.clear();
				
			}
		});
		panel_1.add(btnNewButton_1);
		textAria.setText("Try inserting the same Keyword on the Grocery list or double click the add button\r\n\r\n" );
		
		contentPane.add(textAria, BorderLayout.CENTER);

	}

}
