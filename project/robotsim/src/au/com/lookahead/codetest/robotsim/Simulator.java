package au.com.lookahead.codetest.robotsim;

import java.util.HashMap;

import au.com.lookahead.codetest.robotsim.enums.Direction;
import au.com.lookahead.codetest.robotsim.enums.Side;

public class Simulator {
	private Robot robot;
	private HashMap<String, Runnable> commandMap;
	
	public Simulator() {
		commandMap = new HashMap<String, Runnable>();
		commandMap.put("MOVE", new Runnable() {
			@Override
			public void run() {
				robot.move();
			}
		});
		commandMap.put("LEFT", new Runnable() {
			@Override
			public void run() {
				robot.turn(Side.LEFT);
			}
		});
		commandMap.put("RIGHT", new Runnable() {
			@Override
			public void run() {
				robot.turn(Side.RIGHT);
			}
		});
		commandMap.put("REPORT", new Runnable() {
			@Override
			public void run() {
				robot.report();
			}
		});
	}
	
	public void accept(String text) {
		if(commandMap.containsKey(text)) {
			// must discart other commands if a PLACE command wasn't issued
			if(robot != null) {
				commandMap.get(text).run();
			}
		}
		else {
			// PLACE command is a bit harder cause it's arguments
			handlePlaceCommand(text);
		}
	}

	private void handlePlaceCommand(String text) {
		if(text.startsWith("PLACE")) {
			String[] command = text.split(" |,");
			if(command.length == 4) {
				try {
					int x = Integer.parseInt(command[1]);
					int y = Integer.parseInt(command[2]);
					Direction direction = Direction.valueOf(command[3]);
					robot = new Robot(x, y, direction);
				} catch(NumberFormatException e) {
					System.err.printf("Error parsing PLACE commmand: %s\n", e.getMessage());
				} catch(IllegalArgumentException e) {
					System.err.printf("Error parsing PLACE commmand: %s\n", e.getMessage());
				}
			}
		}
	}
}
