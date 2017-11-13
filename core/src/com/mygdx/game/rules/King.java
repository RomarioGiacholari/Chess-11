package com.mygdx.game.rules;

public class King extends Piece{
	/**
	 * A field to hold if the King piece has moved or not
	 */
	private boolean moved;
	/**
	 * A constructor for King taking an initial x and y coordinate and the team it is playing for
	 * @param row the x coordinate
	 * @param col the y coordinate
	 * @param player if the player is white or black
	 */
	public King(int row, int col , boolean player) {
		super(row, col, player);
		moved = false;
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		if(team) {
			return "K";
		}
		else {
			return"k";
		}
	}
	/**
	 * This is the override for the Movable move function
	 * it tests if the King has moved. 
	 * if the King has not moved it tests if the new location would be within 1 space within its current location which returns true
	 * otherwise false. 
	 * if King sets in a new location, moved will return true which disable castling. (Requires further implementation.)
	 *
	 * To-do
	 * Castling logic. Castling is not allowed if King has either moved, checked, castling to a location that results in being checked,
	 * either side between king and rook has pieces, or either rook has moved.
	 * Validation check. King cannot move into a location that results in being checked.
	 */
	@Override
	public boolean move(int row, int col) {
		if((row == position.getX() + 1) 
				|| (row == position.getX() + 1 && col == position.getY() + 1) 
				|| (col == position.getY() + 1) 
				|| (row == position.getX() - 1 && col == position.getY() + 1)
				|| (row == position.getX() - 1)
				|| (row == position.getX() - 1 && col == position.getY() - 1)
				|| (col == position.getY() - 1)
				|| (row == position.getX() + 1 && col == position.getY() - 1)) {
			if((row < 8 && col < 8) && (row >= 0 && col >= 0)) {
				return true;
			} else {
				return false;
			}
	
		}
		return moved;
	}
}