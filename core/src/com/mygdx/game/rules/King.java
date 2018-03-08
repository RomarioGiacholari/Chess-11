package com.mygdx.game.rules;

import java.util.ArrayList;

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
		
		// TODO Auto-generated constructor stub
	}
	public String printPieceType(){
		System.out.println("King");
		return "King";
	}
	
	public String toString() {
		if(team) {
			return "K";
		}
		else {
			return"k";
		}
	}
	
	public ArrayList<Position> arrMove() {
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		possibleMoves.add(new Position(position.getX() - 1, position.getY() - 1));
		possibleMoves.add(new Position(position.getX() - 1, position.getY()));
		possibleMoves.add(new Position(position.getX() - 1, position.getY() + 1));
		possibleMoves.add(new Position(position.getX(), position.getY() - 1));
		possibleMoves.add(new Position(position.getX(), position.getY() + 1));
		possibleMoves.add(new Position(position.getX() + 1, position.getY() - 1));
		possibleMoves.add(new Position(position.getX() + 1, position.getY()));
		possibleMoves.add(new Position(position.getX() + 1, position.getY() + 1));
		
		for (Position pos : possibleMoves) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		possibleMoves.removeAll(outOfBounds);
		
		return possibleMoves;
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
		
		for (Position pos : arrMove()) {
			if (pos.getX() == row && pos.getY() == col) {
				return true;
			}
		}
		
		return false;
		
	}
}