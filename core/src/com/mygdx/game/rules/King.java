package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * King class. This contains the attributes for the King piece.
 * All of the moves the King can make. The king will also know 
 * whether it is in check mate or not.
 * 
 * {@link com.mygdx.game.rules}
 * 
 * @author Farhan Ali
 * @author Nathan Livsey
 *
 */
public class King extends Piece{
	
	private boolean inCheck = false;
	
	private boolean moved = false;
	
	/**
	 * A constructor for King taking an initial x and y coordinate and the team it is playing for
	 * @param row the x coordinate
	 * @param col the y coordinate
	 * @param player if the player is white or black
	 */
	public King(int row, int col , boolean player) {
		
		super(row, col, player);
		
	}
	
	public void hasMoved() { this.moved = true; }
	
	public boolean isMoved() { return moved; }
	
	public String printPieceType() { return "King"; }
	
	public String toString() {
		
		if(team) return "K";
		
		else return"k";
		
	}
	
	public void setCheck(boolean check) { this.inCheck = check; }
	
	public boolean isCheck() { return this.inCheck; }
	
	public HashMap<String, ArrayList<Position>> hashMove() {
		
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();
		ArrayList<Position> up = new ArrayList<Position>();
		ArrayList<Position> down = new ArrayList<Position>();
		ArrayList<Position> left = new ArrayList<Position>();
		ArrayList<Position> right = new ArrayList<Position>();
		ArrayList<Position> upRight = new ArrayList<Position>();
		ArrayList<Position> downRight = new ArrayList<Position>();
		ArrayList<Position> upLeft = new ArrayList<Position>();
		ArrayList<Position> downLeft = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		up.add(new Position(position.getX() + 1, position.getY()));
		down.add(new Position(position.getX() - 1, position.getY()));
		left.add(new Position(position.getX(), position.getY() - 1));
		right.add(new Position(position.getX(), position.getY() + 1));
		upLeft.add(new Position(position.getX() + 1, position.getY() - 1));
		upRight.add(new Position(position.getX() + 1, position.getY() + 1));
		downLeft.add(new Position(position.getX() - 1, position.getY() - 1));
		downRight.add(new Position(position.getX() - 1, position.getY() + 1));
		
		for (Position pos : up) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : down) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : upRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : downRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : upLeft) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : downRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		up.removeAll(outOfBounds);
		down.removeAll(outOfBounds);
		right.removeAll(outOfBounds);
		left.removeAll(outOfBounds);
		upRight.removeAll(outOfBounds);
		downRight.removeAll(outOfBounds);
		upLeft.removeAll(outOfBounds);
		downLeft.removeAll(outOfBounds);
		
		moves.put("up", up);
		moves.put("down", down);
		moves.put("left", left);
		moves.put("right", right);
		moves.put("upLeft", upLeft);
		moves.put("upRight", upRight);
		moves.put("downLeft", downLeft);
		moves.put("downRight", downRight);
		
		return moves;
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
		Position choice = new Position(row, col);
		
		for (String direction : hashMove().keySet()) {
			if (hashMove().get(direction).contains(choice)) return true;
		}
		
		return false;
		
	}
}