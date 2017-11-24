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