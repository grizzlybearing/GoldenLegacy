/**
 * Something javadoc
 * 
*/
package mysnakegameexample;

import javax.swing.JFrame;


public class Main extends JFrame{

    public Main(){
        setTitle("Змейка");
        setSize(908, 943);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.add(new GameField());
        main.setVisible(true);
    }
}
