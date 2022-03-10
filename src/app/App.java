package app;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class App {
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame();
		JPanel ui = new UserInterface();
		frame.add(ui);
		frame.setBounds(200, 300, 500, 500);
		frame.setContentPane(ui);
		frame.setTitle("Simple Calculator");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
