package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

import com.mygdx.game.models.Board;

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
	
	/**
	 * This is the override for the Movable move function
	 * it tests if the pawn has moved
	 * if the pawn has not moved it tests if the new location would be within 2 spaces ahead and no spaces across it returns true
	 * otherwise false
	 * 
	 * if the pawn has moved it does the same but within 1 space
	 */
	public void takeLeft(boolean take) {
		this.takeLeft = take;
	}
	
	public void takeRight(boolean take) {
		this.takeRight = take;
	}
	
	public ArrayList<Position> arrMove() {
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();

		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		// If the piece is of the WHITE team.
		if (team) {
			possibleMoves.add(new Position(position.getX() + 1, position.getY()));
			possibleMoves.add(new Position(position.getX() + 2, position.getY()));
//			// Left
//			if (takeLeft) possibleMoves.add(new Position(position.getX() + 1, position.getY() - 1));
//			if (takeRight) possibleMoves.add(new Position(position.getX() + 1, position.getY() + 1));
			// Left
			// Right
//			// Right
//			possibleMoves.add(new Position(position.getX() + 1, position.getY() - 1));
		}
		
		
		// If the piece is of the BLACK team
		else if (!team) {
			possibleMoves.add(new Position(position.getX() - 1, position.getY()));
			possibleMoves.add(new Position(position.getX() - 2, position.getY()));
		}
		
		if (moved) possibleMoves.remove(1);
//		if (!takeLeft) possibleMoves.remove(2);
//		if (!takeRight) possibleMoves.remove(3);
		
		for (Position pos : possibleMoves) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		possibleMoves.removeAll(outOfBounds);
		
		return possibleMoves;
	}
	
	public boolean hasMoved() { return moved; }
	
	public String printPieceType(){
//		System.out.println("Pawn");
		return "Pawn";
	}
	
	public String toString() {
		if(team) return "P";
		else return "p";
	}

	public boolean move(int row, int col) {
		
		for (Position position : arrMove()) {
			if (position.getX() == row && position.getY() == col) {
				moved = true;
				return true;
			}
		}
		
		return false; 
	}
		
}