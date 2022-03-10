package app;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Component;

public class UserInterface extends JPanel {

	/**
	 * Create the panel.
	 */
	public UserInterface() {
		setLayout(new BorderLayout(0, 0));
		this.setBounds(new Rectangle(300, 300));
		
		JPanel northP = new JPanel();
		northP.setBackground(Color.WHITE);
		northP.setBorder(new EmptyBorder(10, 10, 10, 10));
		add(northP, BorderLayout.NORTH);
		northP.setLayout(new BoxLayout(northP, BoxLayout.Y_AXIS));
		
		JLabel lblCalculation = new JLabel("29 + 100 / 2");
		lblCalculation.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblCalculation.setBackground(Color.WHITE);
		lblCalculation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		northP.add(lblCalculation);
		
		JLabel lblResult = new JLabel("79");
		lblResult.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 20));
		northP.add(lblResult);
		
		JPanel centerP = new JPanel();
		add(centerP, BorderLayout.CENTER);
		centerP.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btnOpenB = new JButton("(");
		centerP.add(btnOpenB);
		
		JButton btnCloseB = new JButton(")");
		centerP.add(btnCloseB);
		
		JButton btnBack = new JButton("Back");
		centerP.add(btnBack);
		
		JButton btnDelete = new JButton("Delete");
		centerP.add(btnDelete);
		
		JButton btn7 = new JButton("7");
		centerP.add(btn7);
		
		JButton btn8 = new JButton("8");
		centerP.add(btn8);
		
		JButton btn9 = new JButton("9");
		centerP.add(btn9);
		
		JButton btnMulti = new JButton("*");
		centerP.add(btnMulti);
		
		JButton btn4 = new JButton("4");
		centerP.add(btn4);
		
		JButton btn5 = new JButton("5");
		centerP.add(btn5);
		
		JButton btn6 = new JButton("6");
		centerP.add(btn6);
		
		JButton btnDiv = new JButton("/");
		centerP.add(btnDiv);
		
		JButton btn1 = new JButton("1");
		centerP.add(btn1);
		
		JButton btn2 = new JButton("2");
		centerP.add(btn2);
		
		JButton btn3 = new JButton("3");
		centerP.add(btn3);
		
		JButton btnPlus = new JButton("+");
		centerP.add(btnPlus);
		
		JButton btn0 = new JButton("0");
		centerP.add(btn0);
		
		JButton btnComma = new JButton(",");
		centerP.add(btnComma);
		
		JButton btnResult = new JButton("=");
		centerP.add(btnResult);
		
		JButton btnMinus = new JButton("-");
		centerP.add(btnMinus);

	}

}
