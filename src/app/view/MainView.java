package app.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import app.MainController;

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6601183398706783127L;
	
	// measurements
	private final int windowHeight = 300;
	private final int windowWidth = 300;
	private final int windowPosX = 200;
	private final int windowPosY = 300;
	
	// components
	private UserInterface ui;
	private MainController controller;
	
	
	public MainView(MainController controller) {
		super("Simple Calculator");
		this.controller = controller;
		this.ui = new UserInterface(this, controller);
		
		// basic settings
		this.add(this.ui);
		this.setBounds(windowPosX, windowPosY, windowWidth, windowHeight);
		this.setContentPane(this.ui);
		this.setResizable(false);
		this.setVisible(true);
	}
}
