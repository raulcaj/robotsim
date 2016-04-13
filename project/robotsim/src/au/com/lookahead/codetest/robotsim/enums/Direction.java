package au.com.lookahead.codetest.robotsim.enums;

public enum Direction {
	NORTH, EAST, SOUTH, WEST;
	
	public Direction turn(Side side) {
		// all this does is circle through the enum to a given side
		// NORTH + LEFT = WEST
		// SOUTH + RIGHT = EAST
		// ...
		return values()[ (ordinal() + (side.equals(Side.LEFT) ? values().length - 1 : 1)) % values().length ];
	}
}
