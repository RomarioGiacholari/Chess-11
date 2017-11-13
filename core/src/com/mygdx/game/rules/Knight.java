package com.mygdx.game.rules;


public class Knight extends Piece {

	public Knight(int row, int col, boolean player) {
		super(row, col, player);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		if(team) {
			return "H";
		}
		else {
			return "h";
		}
	}
	@Override
	public boolean move(int row, int col) {
		// TODO Auto-generated method stub
		if ((row == position.getX() + 2 && col == position.getY() - 1) || (row == position.getX() + 2 && col == position.getY() + 1)
				|| (row == position.getX() - 2 && col == position.getY() + 1) || (row == position.getX() - 2 && col == position.getY() - 1) 
				|| (row == position.getX() + 1 && col == position.getY() + 2) || (row == position.getX() + 1 && col == position.getY() - 2)
				|| (row == position.getX() - 1 && col == position.getY() + 2) || (row == position.getX() - 1 && col == position.getY() - 2)) {
			if((row < 8 && col < 8) && (row >= 0 && col >= 0)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

}