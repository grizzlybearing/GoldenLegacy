package GUI;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import Sudoku.Sudoku;

import Exception.NotAcceptableNumber;

import EventHandle.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

public class GUI extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5778199570292676522L;
	
	//constants
	public static int NUMBER_OF_LV = 4;
	
	//attributes:
	public static GUI su;
	public static Sudoku sudoku;				//sudoku solve
	public static JTextField[][] table;			//table
	public static Container contain;			//contain
	
	//constructor
	public GUI(){
		sudoku = new Sudoku();
		table = new JTextField[9][9];
		for(int i =0; i<9; i++){
			for(int j =0; j<9; j++){
				table[i][j] = new JTextField();
			}
		}
		contain = new Container(table);
		contain.setPreferredSize(new Dimension(460, 460));
		this.initUI();
	}
	
	//initUI
	public void initUI(){
		//menu
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		
		menuBar.add(file);
		menuBar.add(help);
		
		JMenuItem load = new JMenuItem("Load");
		JMenuItem new1 = new JMenuItem("New");
		JMenuItem about = new JMenuItem("About");
		JMenuItem exit = new JMenuItem("Exit");
		
		help.add(about);
		
		file.add(new1);
		file.add(load);
		file.addSeparator();
		file.add(exit);
		
		//panel
		getContentPane().add(contain);
		contain.setLayout(null);
		contain.setLocation(100, 20);
		
		//table to panel
		for(int i =0; i<9; i++){
			for(int j =0; j<9; j++){
				//table[i][j].setPreferredSize(new Dimension(40, 40) );
				table[i][j].setBounds(0 + j*50, 0 + i*50, 40, 40 );
				contain.add(table[i][j]);
				table[i][j].setVisible(true);
			}
		}
		contain.setVisible(true);
		
		//right panel
		JPanel right = new JPanel();
		right.setLayout(new BoxLayout(right, BoxLayout.Y_AXIS));
		right.setAlignmentX(1f);
		right.setAlignmentY(1f);
		
		JButton clear = new JButton("Clear");clear.setPreferredSize(new Dimension(100, 20));
		JButton check = new JButton("Check");check.setPreferredSize(new Dimension(100, 20));
		JButton load1 = new JButton("Load");load1.setPreferredSize(new Dimension(100, 20));
		JButton solve = new JButton("Sovle");solve.setPreferredSize(new Dimension(100, 20));
		
		right.add(Box.createRigidArea(new Dimension(0, 100)));
		right.add(clear);
		right.add(Box.createRigidArea(new Dimension(0, 10)));
		right.add(check);
		right.add(Box.createRigidArea(new Dimension(0, 10)));
		right.add(load1);
		right.add(Box.createRigidArea(new Dimension(0, 10)));
		right.add(solve);
		
		add(right, BorderLayout.EAST);
		
		//add clear listener
		ClearHandle clearHandle = new ClearHandle();
		clear.addActionListener(clearHandle);
		new1.addActionListener(clearHandle);
		//add load listener
		LoadHandle loadHandle = new LoadHandle();
		load1.addActionListener(loadHandle);
		load.addActionListener(loadHandle);
		//add solve listener
		SolveHandle solveHandle = new SolveHandle();
		solve.addActionListener(solveHandle);	
		//add check listener
		CheckHandle checkHandle = new CheckHandle();
		check.addActionListener(checkHandle);
		//add exit listener
		ExitHandle exitHandle = new ExitHandle();
		exit.addActionListener(exitHandle);
		//add about listener
		AboutHandle aboutLisenter = new AboutHandle();
		about.addActionListener(aboutLisenter);
		
		//add move Listenter
		MoveWindowsHandle moveWindow = new MoveWindowsHandle();
		addComponentListener(moveWindow);
		
		//add mouse Lisenter
		MouseHandle mouseHandle = new MouseHandle();
		contain.addMouseListener(mouseHandle);
		
		//show
		setResizable(false);
		setTitle("Sudoku");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,500);
		this.setLocationRelativeTo(getRootPane());
	}
	
	//main
	public static void main(String[] args){
		su = new GUI();
		su.setVisible(true);
	}
	
	//sync table and sudoku
	public static void tableToGrid() throws NotAcceptableNumber{
		int grid[][] = new int[9][9];
		for(int i = 0; i<9; i++){
			for(int j =0; j<9; j++){
				if( table[i][j].getText().equals("") ) table[i][j].setText("0");
				int temp = Integer.parseInt(table[i][j].getText().trim());
				table[i][j].setBackground(Color.WHITE);
				if( temp < 0 || temp > 9)throw new NotAcceptableNumber();
				grid[i][j] = temp; 
			}
		}
		sudoku = new Sudoku(grid);
	}
	
	public static void gridToTable(){
		for(int i = 0; i<9; i++){
			for(int j =0; j<9; j++){
				table[i][j].setText( "  " + String.valueOf( sudoku.getGrid()[i][j]) );
				table[i][j].setBackground(Color.WHITE);
			}
		}
		contain.repaint();
		contain.revalidate();
		su.repaint();
		su.getContentPane().revalidate();
		
	}
	
	
}//end class GUI
