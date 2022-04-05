package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 */


	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton("Add Entry");
	JButton button2 = new JButton("Search by ID");
	JButton button3 = new JButton("View List");
	JButton button4 = new JButton("Remove Entry");
	HashMap<Integer, String> entrylist = new HashMap<Integer, String>();
	int realnum;
	
	public static void main(String[] args) {
new _02_LogSearch().run();
	}
	void run() {
		
		frame.add(panel);
		frame.setVisible(true);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == button1) {
			String num = JOptionPane.showInputDialog("Add ID Number");
			realnum = Integer.parseInt(num);
			String entry = JOptionPane.showInputDialog("Add Name");
			entrylist.put(realnum, entry);

		}
		if (e.getSource() == button2) {
			String wordid = JOptionPane.showInputDialog("Search By ID");
			int id = Integer.parseInt(wordid);
			if (entrylist.containsKey(id)) {

				System.out.println(entrylist.get(id));
			}
		}

		if (e.getSource() == button3) {
			for (String s : entrylist.values()) {
				System.out.println("Number: " + realnum + "Name: " + s);
			}
		}
		if (e.getSource() == button4) {
			String removeid = JOptionPane.showInputDialog("Enter ID for removal");
int remove = Integer.parseInt(removeid);
				if (entrylist.containsKey(remove)) {
					entrylist.remove(remove);
				}
			}
		}
	}

