package EventHandle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.GUI;

public class LoadHandle implements ActionListener {
	
	public void actionPerformed(ActionEvent e){
		
		int input = 0;
		do{
			input = Integer.parseInt(JOptionPane.showInputDialog("Type in the level you want to play"));
			if( input < 0 || input > GUI.NUMBER_OF_LV)
				JOptionPane.showMessageDialog(new JFrame(), "Sorry, that level is not available yet!");
		}
		while( 0 > input || input > GUI.NUMBER_OF_LV);
		GUI.sudoku.chooseLevel(input);
	
		GUI.gridToTable();
		
	}
}
