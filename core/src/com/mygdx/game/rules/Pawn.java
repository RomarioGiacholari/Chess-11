package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

public class Pawn extends Piece {
	/**
	 * A field to hold if the piece has moved or not
	 */
	private boolean moved = false;
	
	private boolean takeLeft, takeRight = false;

	/**
	 * A constructor for Pawn taking an initial x and y coordinate and the team it is playing for
	 * @param row the x coordinate
	 * @param col the y coordinate
	 * @param player if the player is white or black
	 */
	public Pawn(int row, int col, boolean player) {
		super(row, col,player);
		
		
	}
	
	public void hasMoved() {
		
		this.moved = true;
		
	}
	
	public void takeLeft(boolean take) {
		
		this.takeLeft = take;
		
	}
	
	public void takeRight(boolean take) {
		
		this.takeRight = take;
		
	}
	/**
	 * This is the override for the Movable move function
	 * it tests if the pawn has moved
	 * if the pawn has not moved it tests if the new location would be within 2 spaces ahead and no spaces across it returns true
	 * otherwise false
	 * 
	 * if the pawn has moved it does the same but within 1 space
	 */
	
	public HashMap<String, ArrayList<Position>> hashMove() {
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();
		ArrayList<Position> vertical = new ArrayList<Position>();
		ArrayList<Position> left = new ArrayList<Position>();
		ArrayList<Position> right = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		// If the piece is of the WHITE team.
		if (team) {
			vertical.add(new Position(position.getX() + 1, position.getY()));
			vertical.add(new Position(position.getX() + 2, position.getY()));
			if (takeLeft) left.add(new Position(position.getX() + 1, position.getY() - 1));
			if (takeRight) right.add(new Position(position.getX() + 1, position.getY() + 1));
		}
		// If the piece is of the BLACK team
		else if (!team) {
			vertical.add(new Position(position.getX() - 1, position.getY()));
			vertical.add(new Position(position.getX() - 2, position.getY()));
			if (takeLeft) left.add(new Position(position.getX() - 1, position.getY() - 1));
			if (takeRight) right.add(new Position(position.getX() - 1, position.getY() + 1));
		}
		
		if (moved) vertical.remove(1);
		for (Position pos : vertical) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		vertical.removeAll(outOfBounds);
		right.removeAll(outOfBounds);
		left.removeAll(outOfBounds);
		moves.put("vertical", vertical);
		moves.put("left", left);
		moves.put("right", right);
		return moves;
	}
	
	public String printPieceType(){
//		System.out.println("Pawn");
		return "Pawn";
	}
	
	public String toString() {
		if(team) return "P";
		else return "p";
	}

	@Override
	public boolean move(int row, int col) {
		Position choice = new Position(row, col);
		
		for (String direction : hashMove().keySet()) {
			if (hashMove().get(direction).contains(choice)) return true;
		}
		
		return false;
		
	}
		
}