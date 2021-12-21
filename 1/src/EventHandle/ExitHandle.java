package EventHandle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ExitHandle implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		int input = JOptionPane.showConfirmDialog(null, "Are you sure?", null, JOptionPane.YES_NO_OPTION);
		if( input == 0){
			System.exit(1);
		}
		
		
	}
	
	
}
