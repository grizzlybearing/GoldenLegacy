package Sudoku;

import java.io.*;

//class use for write GUI.NUMBER_OF_LV Sudoku boards for GUI.NUMBER_OF_LV levels
public class write{

	public static void main(String[] args){
		//lv1 board
		String[] board1 = { "0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",
							"0 0 0 0 0 0 0 0 0",};
		//Lv2
		String[] board2 = { "3 7 0 0 0 0 0 8 0",
							"0 0 1 0 9 3 0 0 0",
							"0 4 0 7 8 0 0 0 3",
							"0 9 3 8 0 0 0 1 2",
							"0 0 0 0 4 0 0 0 0",
							"5 2 0 0 0 6 7 9 0",
							"6 0 0 0 2 1 0 4 0",
							"0 0 0 5 3 0 9 0 0",
							"0 3 0 0 0 0 0 5 1"};
		//Lv3
		String[] board3 = { "0 0 0 0 0 0 6 8 0",
							"0 0 0 0 7 3 0 0 9",
							"3 0 9 0 0 0 0 4 5",
							"4 9 0 0 0 0 0 0 0",
							"8 0 3 0 5 0 9 0 2",
							"0 0 0 0 0 0 0 3 6",
							"9 6 0 0 0 0 3 0 8",
							"7 0 0 6 8 0 0 0 0",
							"0 2 8 0 0 0 0 0 0",};
		//Lv4
		String[] board4 = { "0 0 0 2 3 5 0 0 0",
							"0 0 9 0 0 0 7 0 1",
							"0 0 4 0 0 0 2 0 6",
							"0 1 0 8 0 0 0 4 0",
							"7 5 0 1 0 6 0 9 3",
							"0 6 0 0 0 2 0 7 0",
							"3 0 1 0 0 0 5 0 0",
							"8 0 7 0 0 0 9 0 0",
							"0 0 0 4 7 1 0 0 0",};
						
		FileOutputStream fos; 
		ObjectOutputStream oos;
		//write
		try{
			fos = new FileOutputStream("Sudoku.dat");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(board1);
			oos.writeObject(board2);
			oos.writeObject(board3);
			oos.writeObject(board4);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
	}//end main
}//end class write