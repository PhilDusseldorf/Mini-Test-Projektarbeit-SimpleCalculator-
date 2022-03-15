package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainModel {
	// ATTRIBUTES
	private MainController controller;
	
	private StringBuilder equation;
	private final int equationLengthStart = 45;
	private final int[] symbols = {'(', ')', '+', '-', '*', '/', ','};
	private final int[] operators = {'+', '-', '*', '/'};
	
	private String result;
	private final String resultText = "Result";
	
	private List<Double> numbers = new ArrayList<Double>();

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
		if (command == "=") {
			calculateEquation();
		} else if (command == "Back") {
			deleteLastEntry();
		} else if (command == "Delete") {
			deleteEquation();
		} else if (command == "(" || command == ")") {
			// do nothing at the moment
		} else {
			addToEquation(command);
		}
	}

	private void addToEquation(String sign) {
		// make the sign into an integer to allow streaming an char array
		int signAsInt = (int)(sign.charAt(0));
		// start comparison only if sign is an operator and the equation is greater than 0 chars
		if (equation.length() > 0 && Arrays.stream(symbols).anyMatch(symbol -> symbol == signAsInt)) {
			for (int x : symbols) {
				// delete last index of the equation if the new input is also an operator
				if (equation.charAt(equation.length()-1) == x) {
					equation.deleteCharAt(equation.length()-1);
					break;
				}
			}
		}
		// add any sign to equation
		equation.append(sign);
		controller.showEquation(getEquation());
	}

	private void deleteLastEntry() {
		if (equation.length()>0) {
			equation.deleteCharAt(equation.length()-1);	
			controller.showEquation(getEquation());			
		}
	}

	private void deleteEquation() {
		// empty the equation
		equation.delete(0, equation.length());
		// update the UI
		controller.showEquation(getEquation());
		controller.showResult(resultText);
	}

	private void calculateEquation() {
		// empty lists
		numbers.clear();
		
		// perform calculations if expression is valid
		if (!invalidExpression()) {
			// get all numbers in equation
			buildDoubleNumbers();
			// calculate the result
			double res = performCalculation();
			equation.delete(0, equation.length());
			result = String.valueOf(res);		
			controller.showResult(result);
		} else {
			controller.showResult("No valid expression");
		}
	}
	
	private boolean invalidExpression() {
		// ATTENION: more checks would be possible/necessary
		// checks if last char of equation is an operator
		String expression = equation.toString();
		return Arrays.stream(operators).anyMatch(op -> op == (int)(expression.charAt(expression.length()-1)));
	}

	private double performCalculation() {
		double res = numbers.get(0);
		for (int i = 0; i < equation.length(); i++) {
			char c = equation.charAt(i);
			int intChar = (int)c;
			// if an op is found a calculation is performed
			if (Arrays.stream(operators).anyMatch(op -> op == intChar)) {
				switch (c) {
					case '+':
						res += numbers.get(1);
						numbers.remove(0);
						break;
					case '-':
						res -= numbers.get(1);
						numbers.remove(0);
						break;
					case '*':
						res *= numbers.get(1);
						numbers.remove(0);
						break;
					case '/':
						res /= numbers.get(1);
						numbers.remove(0);
						break;
				}
			}
		}
		return res;
	}

	private void buildDoubleNumbers() {
		boolean isOp = false;		 
		// StringBuilder to make a double from
		StringBuilder numStringB = new StringBuilder();
		// iterate through equation to find numbers
		for (int i = 0; i < equation.length(); i++) {
			isOp = false;
			char c = equation.charAt(i);
			int intChar = (int)c;
			
			// if an op is found, a number is created and stored in list
			if (Arrays.stream(operators).anyMatch(op -> op == intChar)) {
				numbers.add(Double.parseDouble(numStringB.toString()));
				isOp = true;
			}
			
			// change ',' to '.' for double number
			if (c == ',') {
				c = '.';
			}
			
			if (!isOp) {
				// add char to String if it is not an operator
				numStringB.append(c); 
			} else {
				// else clear the StringB to start a new number
				numStringB.delete(0, numStringB.length());
			}
		}
		// add last number to numbers arraylist
		numbers.add(Double.parseDouble(numStringB.toString()));
	}
}
