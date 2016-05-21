package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController implements Controller {
	private Model model;
	private View view;
	private HashMap<String, Command> commands;
	
	@Override
	public void displayMessage(String message) {
		view.displayMessage(message);
	}

	@Override
	public void setModel(Model model) {
		this.model = model;		
	}

	@Override
	public void setView(View view) {		
		this.view = view;	
	}	
	
	
	public void generateCommands() {
		commands = new HashMap<String, Command>();
		commands.put("generate_3d_maze", new GenerateCommand(model));
		commands.put("save_maze", new SaveMazeCommand(model));
		commands.put("display", new DisplayMazeCommand(model, view));
		view.sendCommands(commands);
	}
}
