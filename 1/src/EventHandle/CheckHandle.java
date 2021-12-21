package EventHandle;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.GUI;

import Exception.NotAcceptableNumber;

public class CheckHandle implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		
		try{
			GUI.tableToGrid();
		}
		catch(NotAcceptableNumber ex){
			ex.printStackTrace();
		}
		
		for(int i =0; i<9; i++){
			for(int j =0; j<9; j++){
				if( GUI.sudoku.getGrid()[i][j] == 0 ){
					GUI.table[i][j].setBackground(Color.PINK);
					//GUI.table[i][j].repaint();
				}
				else{
					if( check(i,j) == true){
						GUI.table[i][j].setBackground(Color.WHITE);
						//GUI.table[i][j].repaint();
					}
					else{
						GUI.table[i][j].setBackground(Color.RED);
						//GUI.table[i][j].repaint();
					}	
				}
			}
		}
	}
	
	//Check for vaild, except for the cell is being checked itself
	private boolean check(int row, int col){
		int value = GUI.sudoku.getGrid()[row][col];
		int[][] board = GUI.sudoku.getGrid();
		
		//check row
		for( int j = 0; j < 9; j++ )
			if( board[row][j] == value && j != col )
				return false ;
		
		//check column
		for( int i = 0; i < 9; i++ )
			if( board[i][col] == value && i != row ){
				return false ;
			}

		//check block 3x3
		int _col = col;
		int _row = row;
		
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;
		for( int r = 0; r < 3; r++ )
			for( int c = 0; c < 3; c++ )
				if( board[row+r][col+c] == value && row+r != _row && col+c != _col){
					return false ;
				}	
		
		return true ;
	}
	
	
}

