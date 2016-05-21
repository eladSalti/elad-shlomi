package model;

import java.util.HashMap;

import algorithms.mazeGenerator.Maze3d;
import algorithms.mazeGenerator.MyMaze3dGenerator;

public class MyModel implements Model {
	
	HashMap<String,Maze3d> mazesMap;
	private HashMap<String, Maze3d> mazes = new HashMap<String, Maze3d>();
	
	@Override
	public void generateMaze(String name, int rows, int columns, int levels) {
		MyMaze3dGenerator mg = new MyMaze3dGenerator();
		Maze3d maze = mg.generate(rows, columns, levels);
		mazes.put(name, maze);
		System.out.println(maze);
		
		// Send message to controller that maze is ready

	}
	@Override
	public Maze3d display(String name)
	{
		if (mazesMap.containsKey(name)) 
			return mazesMap.get(name);
		return null;
	}
	
	public void saveMaze(String name, String fileName) {
		
	}

	public void loadMaze(String fileName, String name) {
		// TODO Auto-generated method stub

	}

}
