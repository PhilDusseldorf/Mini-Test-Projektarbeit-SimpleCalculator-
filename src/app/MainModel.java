package app;

import java.util.Arrays;

public class MainModel {
	// ATTRIBUTES
	private MainController controller;
	
	private StringBuilder equation;
	private final int equationLengthStart = 45;
	private int[] operators = {'(', ')', '+', '-', '*', '/', ','};
	
	private String result;
	
	// CONSTRUCTORS
	public MainModel (MainController controller) {
		this.controller = controller;
		
		equation = new StringBuilder(equationLengthStart);
		result = "Result";
	}
	
	// GETTERS/SETTERS
	public String getEquation() {
		return equation.toString() == "" ? "Type in an equation" : equation.toString();
	}
	
	public String getResult() {
		return result;
	}
	
	
	// METHODS
	public void reactToButton(String command) {
		// System.out.println(String.format("Button %s pressed! ", command));
		if (command == "=") {
			calculateEquation();
		} else if (command == "Back") {
			deleteLastEntry();
		} else if (command == "Delete") {
			deleteEquation();
		} else {
			addToEquation(command);
		}
	}

	private void addToEquation(String sign) {
		// make the sign into an integer to allow streaming an char array
		int signAsInt = (int)(sign.charAt(0));
		// start comparison only if sign is an operator and the equation is greater than 0 chars
		if (equation.length() > 0 && Arrays.stream(operators).anyMatch(operator -> operator == signAsInt)) {
			for (int x : operators) {
				// delete last index of the equation if the new input is an operator
				if (equation.charAt(equation.length()-1) == x) {
					equation.deleteCharAt(equation.length()-1);
					break;
				}
			}
		}
		// add sign to equation
		equation.append(sign);
		System.out.println("New Equation: " + equation);
		controller.updateUI();
	}

	private void deleteLastEntry() {
		// TODO Auto-generated method stub
		
	}

	private void deleteEquation() {
		// TODO Auto-generated method stub
		
	}

	private void calculateEquation() {
		// TODO Auto-generated method stub
		
	}
}
