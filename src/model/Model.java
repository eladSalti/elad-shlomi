package model;

import algorithms.mazeGenerator.Maze3d;

public interface Model {
	void generateMaze(String name, int rows, int colums, int levels);
	Maze3d display(String name);
	void saveMaze(String name, String fileName);
	void loadMaze(String fileName, String name);
}
