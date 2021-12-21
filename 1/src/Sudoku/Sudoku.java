package Sudoku;

import java.io.*;

import javax.swing.JOptionPane;

public class Sudoku{

	//attribute
	private int[][] Grid;				//Grid size of 9*9
	public Algorithm algor;				//algor reference for selecting algorithm
										//List of availabe algorithm: Backtracking, BlankBoard
	
	//constructors
	public Sudoku(){
		algor = null;
		Grid = null;
		algor = null;
	}
	public Sudoku(int[][] grid){
		Grid = new int[9][9];
		for( int row =0; row < 9; row++)
			for(int column =0; column < 9; column++ )
				Grid[row][column] = grid[row][column];
		algor = null;		
	}
	
	//getGrid
	public int[][] getGrid(){
		return Grid;
	}
	
	//setBacktracking
	private void setBacktracking(){
		algor = new Backtracking(Grid);
	}
	
	//set BlankBoard
	private void setBlankBoard(){
		algor = new BlankBoard(Grid);
	}
	
	//solve
	//check the sudoku board using utility: checkBoard and choose the proper algorithm
	public boolean solve(){
		//if there are 81 blank cells, use blank
		if( checkBoard() == 81){
			//System.out.println("\nUsing BlankBoard algorithm");
			setBlankBoard();
			return (algor.solve());
		}
		//else use Backtracking
		else {
			//System.out.println("\nUsing Backtracking algorithm");
			setBacktracking();
			return (algor.solve());
		}
			
	}//end solve
	
	//static method stringsToGrid
	//input: String sudoku board
	//output: int sudoku board
	public static int[][] stringsToGrid(String[] s){
		int[][] grid = new int[9][9];
		for( int row =0; row < 9; row++){
			for(int column =0; column < 9; column++ )
				grid[row][column] = Character.digit(s[row].charAt(column*2), 10); 		//column *2 cuz there is a white space between to numbers
																						//in the given string
		}		
		return grid;		
	}//end stringToGrid
	
	//toString
	public String toString(){
		StringBuilder result = new StringBuilder();
		
		for( int row =0; row < 9; row++){
			for(int column =0; column < 9; column++ ){
				result.append(Grid[row][column]);
				result.append(' ');
			}
			result.append('\n');
		}
		
		return result.toString();
		
	}//end toString
	
	//save state
	public void saveState(){
		try{
			FileOutputStream fos = new FileOutputStream("src/States/state.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(Grid);
			oos.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}//end saveState
	
	//load state
	public void loadState(){
		try{
			FileInputStream fis = new FileInputStream("src/States/state.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Grid = (int[][])ois.readObject();
			ois.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}//end loadState
	
	//load lv from file to Grid
	public void chooseLevel(int lv){
		try{
			String[] s;
			FileInputStream fis = new FileInputStream("src/Source/Sudoku.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			for(int i = 0; i < lv-1; i++){
				ois.readObject();
			}
			s = (String[])ois.readObject();
			ois.close();
			Grid = Sudoku.stringsToGrid(s);
		}
		catch(FileNotFoundException e){
			String content = "File \"Sudoku.dat\" not found!\n" +
							 "Please make sure \"Sudoku.dat\" is at path: \"src/Source/\"\n";
			JOptionPane.showMessageDialog(null, content, "Source file not found", JOptionPane.ERROR_MESSAGE);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}//end chooseLevel
	
	//utility used for count the number of blank cells in the board
	private int checkBoard(){
		int count =0;
		for( int row =0; row < 9; row++)
			for(int column =0; column < 9; column++ )
				if( Grid[row][column] == 0)count++;
		return count;		
	}

}//end Sudoku