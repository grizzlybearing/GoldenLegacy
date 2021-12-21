//References 1.http://stackoverflow.com/questions/9730280/sudoku-solver-using-backtracking
//			 2.http://www.colloquial.com/games/sudoku/java_sudoku.html
//			 3.http://en.wikipedia.org/wiki/Sudoku_algorithms

package Sudoku;

public class Backtracking extends Algorithm{

	//constructor
	public Backtracking(int[][] grid){
		board = grid;
	}
	
	//solve
	public boolean solve(){
		return actualSolve(0,0);
	}
	
	//actualSolve
	//using this to solve the sudoku, cuz the prototype of methods in each algorithm could be different
	private boolean actualSolve(int row, int column){
		if (row == 9) {
            row = 0;
            if (++column == 9)
                return true;
        }
        if (board[row][column] != 0)  // skip filled cells
            return actualSolve(row+1,column);

        for (int val = 1; val <= 9; ++val) {
            if (validInRow(row, val) && validInCol(column, val) && validInBlock(row, column, val)) {
				//System.out.print("[" + row + "," + column + "]=" + val + "   ");
                board[row][column] = val;
                if (actualSolve(row+1,column))
                    return true;
            }
        }
        board[row][column] = 0; // reset on backtrack
        return false;
	}//end actualSolve
	
}//end class Backtracking