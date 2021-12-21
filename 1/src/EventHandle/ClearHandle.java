package EventHandle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.GUI;

public class ClearHandle implements ActionListener{
	
	public void actionPerformed(ActionEvent e){
		for(int i=0; i <9; i++){
			for(int j =0; j<9; j++){
				GUI.table[i][j].setText("");
				GUI.table[i][j].setBackground(Color.WHITE);
			}
		}
	}
}
