package com.mygdx.game.rules;


public class Position {

	private int xPosition;
	private int yPosition;
	
	public Position(int x, int y) {
		xPosition = x;
		yPosition = y;
	}
	
	public int getX() {
		return xPosition;
	}
	
	public int getY() {
		return yPosition;
	}
	
	public boolean equals(Position testPos) {
		if (this.getX() == testPos.getX() && this.getY() ==testPos.getY()) {
			return true;
		}
		else {
			return false;
		}
		
	}
}