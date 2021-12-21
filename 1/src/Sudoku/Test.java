package Sudoku;

import java.util.*;

public class Test{

	public static void main(String[] args) {
		
		//Sudoku
		Sudoku sudoku = new Sudoku();
		
		//Prompt for choosing level
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.print("Please choose a level(0-3):");
		
		try{
			choice = input.nextInt();
			input.close();
		}
		catch(InputMismatchException e){
			e.printStackTrace();
		}
		
		sudoku.chooseLevel(choice);
		//after read lv
		System.out.println("\nBoard lv" + choice + ":");
		System.out.println( sudoku.toString() );	
		
		//save state(1);
		System.out.println("\nsave state(1)");
		sudoku.saveState();
		
		//solve
		System.out.println("\nsolve");
		sudoku.solve();

		System.out.println("\nSudoku board after solved:");
		System.out.println( sudoku.toString() );

		//load state(1);
		System.out.println("\nload state(1)");
		sudoku.loadState();
		
		System.out.println("\nSudoku board after load state(1):");
		System.out.println( sudoku.toString() );
	
	}//end main
	
}//end class Test