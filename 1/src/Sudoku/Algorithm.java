//References 1.http://stackoverflow.com/questions/9730280/sudoku-solver-using-backtracking
//			 2.http://www.colloquial.com/games/sudoku/java_sudoku.html
//			 3.http://en.wikipedia.org/wiki/Sudoku_algorithms

package Sudoku;

abstract public class Algorithm{
	
	//attributes
	//reference to the grid, algorithm will work with this reference
	protected int[][] board;
	
	//solve
	abstract public boolean solve();
	
	//check if valid in row
	public boolean validInRow(int row, int value){
		for( int col = 0; col < 9; col++ )
			if( board[row][col] == value )
				return false ;

		return true ;
	}

	//check if valid in column
	public boolean validInCol(int col, int value){
		for( int row = 0; row < 9; row++ )
			if( board[row][col] == value )
				return false ;

		return true ;
	}
	
	//check if valid in 3*3
	public boolean validInBlock(int row, int col, int value){
		row = (row / 3) * 3 ;
		col = (col / 3) * 3 ;

		for( int r = 0; r < 3; r++ )
			for( int c = 0; c < 3; c++ )
				if( board[row+r][col+c] == value )
					return false ;

		return true ;
	}

}//end interface Algorith