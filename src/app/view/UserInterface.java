package app.view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import app.MainController;

import java.awt.Color;
import java.awt.Component;

public class UserInterface extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 441150729215903406L;
	
	private MainController controller;
	
	// panels
	private JPanel northP;
	private JPanel centerP;
	
	// measurements
	private final int northHeight = 100;
	private final int centerHeight = 200;
	private int windowHeight;
	private int windowWidth;
	
	
	// labels
	private JLabel lblCalculation;
	private JLabel lblResult;
	
	// number buttons
	private JButton btn0;
	private JButton btn1;
	private JButton btn2;
	private JButton btn3;
	private JButton btn4;
	private JButton btn5;
	private JButton btn6;
	private JButton btn7;
	private JButton btn8;
	private JButton btn9;
	
	// special buttons
	private JButton btnOpenB;
	private JButton btnCloseB;
	private JButton btnBack;
	private JButton btnDelete;
	private JButton btnMulti;
	private JButton btnDiv;
	private JButton btnPlus;
	private JButton btnMinus;
	private JButton btnComma;
	private JButton btnResult;
	
	// CONSTRUCTORS
	public UserInterface(MainView view, MainController controller) {
		this.controller = controller;
		windowWidth = view.getWidth();
		windowHeight = view.getHeight();
		
		this.setLayout(new BorderLayout(0, 0));
		this.setSize(windowWidth, windowHeight);
		
		northP = new JPanel();
		northP.setBackground(Color.WHITE);
		northP.setBorder(new EmptyBorder(10, 10, 10, 10));
		northP.setSize(windowWidth, northHeight);
		add(northP, BorderLayout.NORTH);
		northP.setLayout(new BoxLayout(northP, BoxLayout.Y_AXIS));
		
		lblCalculation = new JLabel(controller.getEquation());
		lblCalculation.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblCalculation.setBackground(Color.WHITE);
		lblCalculation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		northP.add(lblCalculation);
		
		lblResult = new JLabel(controller.getResult());
		lblResult.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 20));
		northP.add(lblResult);
		
		centerP = new JPanel();
		centerP.setSize(windowWidth, centerHeight);
		add(centerP, BorderLayout.CENTER);
		centerP.setLayout(new GridLayout(0, 4, 0, 0));
		
		// first row buttons
		btnOpenB = new JButton("(");
		centerP.add(btnOpenB);
		
		btnCloseB = new JButton(")");
		centerP.add(btnCloseB);
		
		btnBack = new JButton("Back");
		centerP.add(btnBack);
		
		btnDelete = new JButton("Delete");
		centerP.add(btnDelete);
		
		// second row buttons
		btn7 = new JButton("7");
		centerP.add(btn7);
		
		btn8 = new JButton("8");
		centerP.add(btn8);
		
		btn9 = new JButton("9");
		centerP.add(btn9);
		
		btnMulti = new JButton("*");
		centerP.add(btnMulti);
		
		// third row buttons
		btn4 = new JButton("4");
		centerP.add(btn4);
		
		btn5 = new JButton("5");
		centerP.add(btn5);
		
		btn6 = new JButton("6");
		centerP.add(btn6);
		
		btnDiv = new JButton("/");
		centerP.add(btnDiv);
		
		// fourth row buttons
		btn1 = new JButton("1");
		centerP.add(btn1);
		
		btn2 = new JButton("2");
		centerP.add(btn2);
		
		btn3 = new JButton("3");
		centerP.add(btn3);
		
		btnPlus = new JButton("+");
		centerP.add(btnPlus);
		
		// fifth row buttons
		btn0 = new JButton("0");
		centerP.add(btn0);
		
		btnComma = new JButton(",");
		centerP.add(btnComma);
		
		btnResult = new JButton("=");
		centerP.add(btnResult);
		
		btnMinus = new JButton("-");
		centerP.add(btnMinus);
		
		addAllActionListeners();
	}
	
	// METHODS
	private void addAllActionListeners() {
		Component[] compArray = centerP.getComponents();
		for (Component comp : compArray) {
			if (comp instanceof JButton) {
				// System.out.println("Buttontext: " + ((JButton)comp).getText());
				((JButton)comp).addActionListener(controller);
			}
		}
	}
	
	public void setResult(String r) {
		lblResult.setText(r);
	}
	
	public void setCalculationText(String c) {
		lblCalculation.setText(c);
	}
}
