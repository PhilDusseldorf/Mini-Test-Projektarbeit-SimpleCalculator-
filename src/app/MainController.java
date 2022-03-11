package app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import app.view.MainView;
import app.view.UserInterface;

public class MainController implements ActionListener {
	
	MainModel model;
	MainView view;
	UserInterface ui;
	
	public MainController() {
		// create an instance of all necessary enteties
		this.model = new MainModel();
		this.ui = new UserInterface();
		this.view = new MainView(this, ui);
		
		this.model.addObserver(this.ui);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Action performed");
		
	}

}
