package app.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import app.MainController;

import org.junit.jupiter.api.BeforeEach;

class BlackBox {
	private MainController controller;
	
	@BeforeEach
	public void setup() {
		System.out.println("Initialisiere Taschenrechner");
		
		this.controller = new MainController();
	}

	@Test
	public void inputTests() {
		System.out.println("--- simple input-");
		String testEquation = "1+1";
		createInput(testEquation);
		assertEquals(testEquation, controller.getEquation());
		
		System.out.println("--- delete equation and get command");
		controller.getModel().reactToButton("Delete");
		assertEquals("type in an equation", controller.getEquation());
		
		System.out.println("--- do not allow two symbols in row");
		testEquation = "12+-1";
		createInput(testEquation);
		assertEquals("12-1", controller.getEquation());
		
		System.out.println("--- remove last char from equation");
		createInput("/31");
		controller.getModel().reactToButton("Back");
		assertEquals("12-1/3", controller.getEquation());
		
		System.out.println("--- do not allow symbol at the end when calculation is started");
		createInput("*");
		controller.getModel().reactToButton("=");
		assertEquals("Result", controller.getResult());	// "Result" is the blanco text 
	}
	
	@Test
	public void calculations() {
		System.out.println("--- simple addition");
		String testEquation = "1+1";
		createInput(testEquation);
		controller.getModel().reactToButton("=");
		assertEquals("2.0", controller.getResult());
		
		System.out.println("--- simple subtraction");
		testEquation = "123-23";
		createInput(testEquation);
		controller.getModel().reactToButton("=");
		assertEquals("100.0", controller.getResult());
		
		System.out.println("--- simple multiplication");
		testEquation = "11*23";
		createInput(testEquation);
		controller.getModel().reactToButton("=");
		assertEquals("253.0", controller.getResult());
		
		System.out.println("--- simple division");
		testEquation = "21/7";
		createInput(testEquation);
		controller.getModel().reactToButton("=");
		assertEquals("3.0", controller.getResult());
		
		System.out.println("--- mixed operators");
		testEquation = "3-3+10*5*2/10-10";
		createInput(testEquation);
		controller.getModel().reactToButton("=");
		assertEquals("0.0", controller.getResult());
	}
	
	private void createInput(String input) {
		// insert every char into controller
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			controller.getModel().reactToButton(String.valueOf(c));
		}
	}

}
