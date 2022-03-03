package _00_Intro_To_ArrayLists;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class _02_GuestBook implements ActionListener {
    /*
     * Create a GUI with two buttons. One button reads "Add Name" and the other
     * button reads "View Names". When the add name button is clicked, display
     * an input dialog that asks the user to enter a name. Add that name to an
     * ArrayList. When the "View Names" button is clicked, display a message
     * dialog that displays all the names added to the list. Format the list as
     * follows:
     * Guest #1: Bob Banders
     * Guest #2: Sandy Summers
     * Guest #3: Greg Ganders
     * Guest #4: Donny Doners
     */
	Frame frame = new Frame();
	Panel panle = new Panel();
	Button one = new Button("Enter a name");
	Button two = new Button("View List");
	ArrayList<String> Names = new ArrayList<String>();
	
public static void main(String[] args) {
	_02_GuestBook book = new _02_GuestBook();
	book.start();
}
void start() {
	
	frame.add(panle);
	frame.setVisible(true);
	panle.add(one);
	panle.add(two);
	one.addActionListener(this);
	two.addActionListener(this);
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if (e.getSource() == one) {
		String add = JOptionPane.showInputDialog("Add Name: ");
		Names.add(add);
	}
	if(e.getSource() == two) {
		for (int i = 0; i < Names.size(); i++) {
			String print = Names.get(i);
			System.out.println(print);
			
		}
	}
}
}
