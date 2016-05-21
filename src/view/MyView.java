package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import algorithms.mazeGenerator.Maze3d;
import controller.Command;
import controller.Controller;

public class MyView implements View {

	private BufferedReader in;
	private Writer out;
	private CLI cli;
	private Controller controller;
	private HashMap<String, Command> commands;
	
	public MyView(Controller controller, BufferedReader in, Writer out)
	{		
		this.in = in;
		this.out = out;
		
	}
			
	@Override
	public void displayMessage(String message) {
		try {
			out.write(message);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Override
	public void start() {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {				
				cli.start();
			}
			
		});	
		thread.start();
	}

	@Override
	public void sendCommands(HashMap<String, Command> commands) {
		this.commands = commands;
		cli = new CLI(in, out, commands);
	}

	@Override
	public void displayMaze(Maze3d maze) {
		try {
			out.write(maze.toString());
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}
