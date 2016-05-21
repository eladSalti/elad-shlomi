package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import controller.Command;

public class Cli {
	private BufferedReader in;
	private PrintWriter out;
	private HashMap<String, Command> commands;

	public Cli(BufferedReader in, PrintWriter out, HashMap<String,Command> commands) {
		this.in = in;
		this.out = out;
		this.commands = commands;
	}
	


	public void start(){
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				 
				try {
					out.write("Enter command: ");
					out.flush();
					String line = in.readLine();
					while (!(line.equals("exit"))) {
						
											
						String[] arr = line.split(" ");
						String str = "";
						int i = 0;					
						
						Command command = null;
						while (command == null && i < arr.length) {
							str += arr[i];
							command = commands.get(str);
							str += "_";
							
							i++;
						}
						
						if (command == null) {
							out.write("Command not found\n");
							out.flush();							
						} else {
							
							String[] args = null;
							if (i < arr.length) {
								args = new String[arr.length - i];
								System.arraycopy(arr, i, args, 0, arr.length - i);
							}						
							
							command.doCommand(args);						
						}						
						
						out.write("Enter command: ");
						out.flush();
						line = in.readLine();
					}	
					
				} catch (IOException e) {
					System.out.println(e.getMessage());
				}						
			}
			
		});
		thread.start();
	}
		
	}
	
	


