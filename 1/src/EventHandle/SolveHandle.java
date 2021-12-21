package EventHandle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.GUI;

import Exception.NotAcceptableNumber;;

public class SolveHandle implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		
		try{
			GUI.tableToGrid();
		}
		catch(NotAcceptableNumber ex){
			ex.printStackTrace();
		}
		GUI.sudoku.solve();
		GUI.gridToTable();
		
	}


}
