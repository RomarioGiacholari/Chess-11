package com.mygdx.game.rules;


public class Position {

	private int xPosition;
	private int yPosition;
	private Position[] surrounding;
	
	public Position(int x, int y) {
		xPosition = x;
		yPosition = y;
		surrounding = new Position[8];
	}
	
	public int getX() {
		return xPosition;
	}
	
	public int getY() {
		return yPosition;
	}
	
	public Position[] surroundings() {
		Position checkRight = new Position(xPosition, yPosition + 1);
		Position checkLeft = new Position(xPosition, yPosition - 1);
		Position checkUp = new Position(xPosition + 1, yPosition);
		Position checkDown = new Position(xPosition - 1, yPosition);
		Position checkUpRight = new Position(xPosition + 1, yPosition + 1);
		Position checkUpLeft = new Position(xPosition + 1, yPosition - 1);
		Position checkDownRight = new Position(xPosition - 1, yPosition - 1);
		Position checkDownLeft = new Position(xPosition - 1, yPosition + 1);
		surroundings[0] = checkRight;
		return surrounding;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Position) {
			Position pos = (Position) obj;
			if(pos.getX() == this.getX()) {
				if(pos.getY() == this.getY()) {
					return true;
				}
			}
		}
		
		return false;
		
	}
}