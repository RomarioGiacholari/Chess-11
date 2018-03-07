package com.mygdx.game.rules;

import java.util.ArrayList;

public class Pawn extends Piece {
	/**
	 * A field to hold if the piece has moved or not
	 */
	private boolean moved;
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
	
	public ArrayList<Position> arrMove() {
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		// If the piece is of the WHITE team.
		if (!moved && team) {
			possibleMoves.add(new Position(position.getX() + 1, position.getY()));
			possibleMoves.add(new Position(position.getX() + 2, position.getY()));
		} else if (moved && team) {
			possibleMoves.add(new Position(position.getX() + 1, position.getY()));
		} else if (!moved && !team) {
			
			possibleMoves.add(new Position(position.getX() - 1, position.getY()));
			possibleMoves.add(new Position(position.getX() - 2, position.getY()));
		} else if (moved && !team) {
			possibleMoves.add(new Position(position.getX() - 1, position.getY()));
		}
		
		for (Position pos : possibleMoves) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		possibleMoves.removeAll(outOfBounds);
		
		return possibleMoves;
	}
	
	public String printPieceType(){
		System.out.println("Pawn");
		return "Pawn";
	}
	
	public String toString() {
		if(team) {
			return "P";
		}
		else {
			return "p";
				}
	}

	public boolean move(int row, int col) {
		
		for (Position position : arrMove()) {
			if (position.getX() == row && position.getY() == col) {

				return true;
			}
		}
		
		return false; 
	}
		
}