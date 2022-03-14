package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import app.view.MainView;
import app.view.UserInterface;

public class MainController implements ActionListener {
	// ATTRIBUTES
	private MainModel model;
	private MainView view;
	private UserInterface ui;
	
	// CONSTRUCTORS
	public MainController() {
		// create an instance of all necessary entities
		this.model = new MainModel(this);
		this.view = new MainView(this);
	}
	
	// GETTERS/SETTERS
	public MainModel getModel() {
		return model;
	}

	public MainView getView() {
		return view;
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
