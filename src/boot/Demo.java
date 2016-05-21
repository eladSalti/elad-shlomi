package boot;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;
import controller.GenerateCommand;
import model.MyModel;
import view.Cli;

public class Demo {

	public static void main(String[] args) {
		MyModel model = new MyModel();
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter writer = new PrintWriter(System.out);
		HashMap<String, Command> commands = new HashMap<String,Command>();
		
		commands.put("generate_3d_maze", new GenerateCommand(model));
		
		Cli cli = new Cli(reader, writer, commands);
		cli.start();

	}

}
