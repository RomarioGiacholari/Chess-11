package com.mygdx.game.rules;

import java.util.ArrayList;

public class Queen extends Piece {
	/**
	 * A field to hold if the piece has moved or not from its starting place.
	 */
	private boolean moved;
	/**
	 * A constructor for Pawn taking an initial x and y coordinate and the team it is playing for
	 * @param row - the x coordinate
	 * @param col - the y coordinate
	 * @param player - if the player is white of black
	 */
	public Queen(int row, int col, boolean player) {
		super(row, col, player);
		this.moved = false;
	}
	public String printPieceType(){
		System.out.println("Queen");
		return "Queen";
	}
	
	public String toString() {
		if(team) {
			return "Q";
		}
		else {
			return "q";
		}
	}
	
	public ArrayList<Position> arrMove() {
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		for (int i = 0; i < 8; i++) {
			// Up Right Moves
			possibleMoves.add(new Position(position.getX() - i, position.getY() + i));
			// Down Right moves
			possibleMoves.add(new Position(position.getX() + i, position.getY() + i));
			// Up Left Moves
			possibleMoves.add(new Position(position.getX() - i, position.getY() - i));
			// Down Left moves
			possibleMoves.add(new Position(position.getX() + i, position.getY() - i));
			// Down Moves
			possibleMoves.add(new Position(position.getX() + i, position.getY()));
			// Up Moves
			possibleMoves.add(new Position(position.getX() - i, position.getY()));
			// Right Moves
			possibleMoves.add(new Position(position.getX(), position.getY() + i));
			// Left Moves
			possibleMoves.add(new Position(position.getX(), position.getY() - i));
		}
		
		while (true) {
			if (possibleMoves.contains(position)) possibleMoves.remove(position);
			else break;
		}
		
		for (Position pos : possibleMoves) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		possibleMoves.removeAll(outOfBounds);
		
		return possibleMoves;
		
	}
	@Override
	public boolean move(int row, int col) {
		/**
		 * To-Do:
		 * - The queen needs to be able to check if there is a piece in front of it.
		 * - The queen needs to know if it is moving off the board.
		 */
		
		for (Position pos : arrMove()) {
			if (pos.getX() == row && pos.getY() == col) return true;
		}
		
		return false;
//		if(row < 8 && col < 8 && row >= 0 && col >= 0) {
//			 if (row == position.getX()) {
//					for(int i = 0;i<8;i++) {
//						if(i == col) {
//							return true;
//						}
//					}
//				}
//				else if(col == position.getY()) {
//					for( int i = 0 ; i<8;i++) {
//						if(i==row) {
//							return true;
//						}
//					}
//				}
//			else {
//				for( int i=1; i<8;i++) {
//					if((row == position.getX() + i && col == position.getY() +i ) || (row == position.getX() - i && col ==position.getY() -i )||(row == position.getX() + i && col ==position.getY() -i || (row == position.getX() - i && col ==position.getY() +i ))){
//						return true;
//					}
//				}
//			}
//		}
//		return false;
		
		
	}

}
