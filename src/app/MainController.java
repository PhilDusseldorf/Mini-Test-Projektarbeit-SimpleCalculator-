package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.view.MainView;
import app.view.UserInterface;

public class MainController implements ActionListener {
	
	MainModel model;
	MainView view;
	UserInterface ui;
	
	public MainController() {
		// create an instance of all necessary entities
		this.model = new MainModel(this);
		this.ui = new UserInterface(this);
		this.view = new MainView(this, ui);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println("Action performed");
		if (e.getSource() instanceof JButton) {
			// System.out.println("I execute " + ((JButton)e.getSource()).getText());
			model.reactToButton(((JButton)e.getSource()).getText());
		}
		
	}

}
