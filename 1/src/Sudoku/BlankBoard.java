//References 1.http://stackoverflow.com/questions/9730280/sudoku-solver-using-backtracking
//			 2.http://www.colloquial.com/games/sudoku/java_sudoku.html
//			 3.http://en.wikipedia.org/wiki/Sudoku_algorithms

package Sudoku;

public class BlankBoard extends Algorithm{

	//constructor
	public BlankBoard(int[][] grid){
		board = grid;
	}
	
	//solve
	public boolean solve(){
		return actualSolve();
	}
	
	//actualSolve
	//using this to solve the sudoku, cuz the prototype of methods in each algorithm could be different
	public boolean actualSolve(){
		final int n =3;
		int temp = 0;
		for (int  i = 0; i < 9; i++){
			for (int j = 0; j < 9; j++){
				temp = (i*n + i/n + j) % (n*n) + 1;
                board[i][j] = temp;
				//System.out.print("[" + i + "," + j + "]=" + temp + "   ");
			}
		}	
		return true;
		
	}//end solve
	
}//end class Backtracking