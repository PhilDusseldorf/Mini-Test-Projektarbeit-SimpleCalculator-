package app;

import java.util.Arrays;

public class MainModel {
	// ATTRIBUTES
	private MainController controller;
	
	private StringBuilder equation;
	private final int equationLengthStart = 45;
	private int[] symbols = {'(', ')', '+', '-', '*', '/', ','};
	
	private String result;
	private final String resultText = "Result";
	
	// CONSTRUCTORS
	public MainModel (MainController controller) {
		this.controller = controller;
		
		equation = new StringBuilder(equationLengthStart);
		result = resultText;
	}
	
	// GETTERS/SETTERS
	public String getEquation() {
		return equation.toString() == "" ? "type in an equation" : equation.toString();
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
		if (equation.length() > 0 && Arrays.stream(symbols).anyMatch(operator -> operator == signAsInt)) {
			for (int x : symbols) {
				// delete last index of the equation if the new input is an operator
				if (equation.charAt(equation.length()-1) == x) {
					equation.deleteCharAt(equation.length()-1);
					break;
				}
			}
		}
		// add sign to equation
		equation.append(sign);
		//System.out.println("New Equation: " + equation);
		controller.showEquation(getEquation());
	}

	private void deleteLastEntry() {
		equation.deleteCharAt(equation.length()-1);	
		controller.showEquation(getEquation());
	}

	private void deleteEquation() {
		equation.delete(0, equation.length());
		controller.showEquation(getEquation());
		controller.showResult(resultText);
	}

	private void calculateEquation() {
		// The equation to be calculate from StringBuilder to String
		String eq = getEquation();
		// the new result as a double
		double newResult = 0.0;
		
		for (int i = 0; i < eq.length(); i++) {
			if (eq.charAt(i) == 0) {
				
			}
		}
		
		result = String.valueOf(newResult);
		controller.showResult(result);
	}
}
