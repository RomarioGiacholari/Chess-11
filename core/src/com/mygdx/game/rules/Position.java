package com.mygdx.game.rules;


public class Position {

	private int xPosition;
	private int yPosition;
	private Position right;
	private Position left;
	private Position up;
	private Position down;
	private Position upRight;
	private Position upLeft;
	private Position downRight;
	private Position downLeft;
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
		if (xPosition < 8 && yPosition < 8) {
			right = new Position(xPosition, yPosition + 1);
			left = new Position(xPosition, yPosition - 1);
			up = new Position(xPosition + 1, yPosition);
			down = new Position(xPosition - 1, yPosition);
			upRight = new Position(xPosition + 1, yPosition + 1);
			upLeft = new Position(xPosition + 1, yPosition - 1);
			downRight = new Position(xPosition - 1, yPosition - 1);
			downLeft = new Position(xPosition - 1, yPosition + 1);
		}
		
		surrounding[0] = right;
		surrounding[1] = left;
		surrounding[2] = up;
		surrounding[3] = down;
		surrounding[4] = upRight;
		surrounding[5] = upLeft;
		surrounding[6] = downRight;
		surrounding[7] = downLeft;
		
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