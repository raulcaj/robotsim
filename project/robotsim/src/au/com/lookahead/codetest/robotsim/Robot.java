package au.com.lookahead.codetest.robotsim;

import au.com.lookahead.codetest.robotsim.enums.Direction;
import au.com.lookahead.codetest.robotsim.enums.Side;
import au.com.lookahead.codetest.robotsim.util.Reference;

public class Robot {
	private final static int gridSize = 5;
	private Direction facing;
	// this values are references cause them make it easier
	// to write the move algorithm
	private Reference<Integer> positionX, positionY;
	
	public Robot(int positionX, int positionY, Direction facing) {
		// cannot initialize a robot outside the grid
		if(!isValidBoundaries(positionX) || !isValidBoundaries(positionY)) {
			throw new IllegalArgumentException("Check position boundaries"); 
		}
		this.positionX = new Reference<Integer>(positionX);
		this.positionY = new Reference<Integer>(positionY);
		this.facing = facing;
	}

	public void move() {
		int increment = (facing.equals(Direction.SOUTH) || facing.equals(Direction.WEST)) ? -1 : 1;
		Reference<Integer> variable = (facing.equals(Direction.NORTH) || facing.equals(Direction.SOUTH)) ? positionY : positionX;
		// the new position cannot be outside the grid
		if(isValidBoundaries(variable.get()+increment)) {
			variable.set(variable.get()+increment);
		}
	}
	
	private boolean isValidBoundaries(int value) {
		return value >= 0 && value < gridSize;
	}

	public void turn(Side side) {
		facing = facing.turn(side);
	}

	public void report() {
		System.out.printf("Output: %d,%d,%s\n", positionX.get(), positionY.get(), facing);
	}
}