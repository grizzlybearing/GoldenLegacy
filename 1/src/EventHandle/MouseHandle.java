package EventHandle;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import GUI.GUI;

public class MouseHandle implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		for(int i =0; i < 9; i++)
			for( int j =0; j < 9; j++)
				GUI.table[i][j].repaint();
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		for(int i =0; i < 9; i++)
			for( int j =0; j < 9; j++)
				GUI.table[i][j].repaint();
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
