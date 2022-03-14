package app;

public class MainModel {
	// ATTRIBUTES
	private MainController controller;
	
	private StringBuilder equation;
	private final int equationMax = 45;
	
	// CONSTRUCTORS
	public MainModel (MainController controller) {
		this.controller = controller;
		
		equation = new StringBuilder(equationMax);
	}
	
	// GETTERS/SETTERS
	
	// METHODS
	public void reactToButton(String command) {
		if (command == "=") {
			
		} else if (command == "Back") {
			
		} else if (command == "Delete") {
			
		} else {
			
		}
	}
}
