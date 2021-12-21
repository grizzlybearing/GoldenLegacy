package EventHandle;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import GUI.GUI;

public class MoveWindowsHandle implements ComponentListener{

	public void componentHidden(ComponentEvent e) {
	}


	public void componentMoved(ComponentEvent e) {
		for(int i =0; i < 9; i++)
			for( int j =0; j < 9; j++)
				GUI.table[i][j].repaint();
	}

	public void componentResized(ComponentEvent e) {
		for(int i =0; i < 9; i++)
			for( int j =0; j < 9; j++)
				GUI.table[i][j].repaint();
		
	}

	public void componentShown(ComponentEvent e) {
	}

}
