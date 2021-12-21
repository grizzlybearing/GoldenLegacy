package EventHandle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AboutHandle implements ActionListener{

	public void actionPerformed(ActionEvent e) {
		String content = "Version 1.0\n" +
						 "Author: Viet Vu Danh \n" +
						 "If you have any problem, want to contact me, giving me ideas to improve the program,...\n" +
						 "please mail me at: robberviet@gmail.com \n" +
						 "Thank you for your support!";
		JOptionPane.showMessageDialog(null, content, "About",  JOptionPane.PLAIN_MESSAGE);
	}

}
