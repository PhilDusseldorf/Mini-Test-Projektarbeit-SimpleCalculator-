package app.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.MainController;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6601183398706783127L;
	
	JPanel ui;
	MainController controller;
	
	
	public MainView(MainController controller, UserInterface ui) {
		super("Simple Calculator");
		this.controller = controller;
		this.ui = ui;
		
		// basic settings
		this.add(this.ui);
		this.setBounds(200, 300, 300, 300);
		this.setContentPane(this.ui);
		this.setResizable(false);
		this.setVisible(true);
	}

}
