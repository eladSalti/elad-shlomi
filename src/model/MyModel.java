package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.MyMaze3dGenerator;
import controller.Controller;
import io.MyCompressorOutputStream;


public class MyModel implements Model {
	private Controller controller;
	private ArrayList<Thread> threads = new ArrayList<Thread>();
	private HashMap<String, Maze3d> mazes = new HashMap<String, Maze3d>();
	
	
	public MyModel(Controller controller)
	{
		this.controller = controller;
	}
	
	@Override
	public void generateMaze(String name, int rows, int cols, int levels) {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {				
				MyMaze3dGenerator mg = new MyMaze3dGenerator();
				Maze3d maze = mg.generate(rows, cols, levels);
				mazes.put(name, maze);
				controller.displayMessage("Maze " + name + " is ready\n");				
			}				
		});
		thread.start();	
		threads.add(thread);
	}
	
	public Maze3d getMaze(String name) {
		return mazes.get(name);			
	}

	@Override
	public void saveMaze(String name, String fileName) {
		if (!mazes.containsKey(name)) {
			controller.displayMessage("Maze " + name + " does not exist\n");
			return;
		}
		Maze3d maze = mazes.get(name);
		try {
			OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
			byte[] bytes = maze.toByteArray();
			out.write(bytes.length);
			out.write(bytes);
			out.flush();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void loadMaze(String fileName, String name) {
		// TODO Auto-generated method stub

	}

	@Override
	public Maze3d display(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
