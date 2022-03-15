package app.view;

import javax.swing.JFrame;

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
	
	// GETTERS/SETTERS
	public UserInterface getUi() {
		return ui;
	}
	
	public void setUi(UserInterface ui) {
		this.ui = ui;
	}

	// CONSTRUCTORS
	public MainView(MainController controller) {
		super("Simple Calculator");
		this.ui = new UserInterface(this, controller);
		
		// basic settings
		this.add(this.ui);
		this.setBounds(windowPosX, windowPosY, windowWidth, windowHeight);
		this.setContentPane(this.ui);
		this.setResizable(false);
		this.setVisible(true);
	}
}
