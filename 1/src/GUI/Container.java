package GUI;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Container extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5296894867043491082L;
	//table
	JTextField[][] table;
	
	//constructor
	public Container(JTextField[][] table) {
		super();
		this.table = table;
	}
	
	//paint
	public void paint(Graphics g){
		g.drawLine(145, 0, 145, 440);
		g.drawLine(295, 0, 295, 440);
		g.drawLine(0, 145, 440, 145);
		g.drawLine(0, 295, 440, 295);
		for(int i =0; i<9; i++){
			for(int j =0; j<9; j++){
				table[i][j].paint(g);
			}
		}
	}
	
}
