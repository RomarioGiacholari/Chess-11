package com.mygdx.game.rules;


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
		moved = false;
	}
	/**
	 * This is the override for the Movable move function
	 * it tests if the pawn has moved
	 * if the pawn has not moved it tests if the new location would be within 2 spaces ahead and no spaces across it returns true
	 * otherwise false
	 * 
	 * if the pawn has moved it does the same but within 1 space
	 */
	
	public Position[] arrMove () {
		Position[] possibleMoves = new Position[2] ;
		if (!moved && team == true) {
			possibleMoves[0] = new Position(position.getX() + 1, position.getY());
			possibleMoves[1] = new Position(position.getX() + 2,position.getY());
		}
		else if (!moved && !team) {
			possibleMoves[0] = new Position(position.getX() - 1, position.getY());
			possibleMoves[1] = new Position(position.getX() - 2,position.getY());
		}
		else if (moved && team) {
			possibleMoves[0] = new Position(position.getX() + 1, position.getY());
		}
		else if (moved && !team) {
			possibleMoves[0] = new Position(position.getX() - 1, position.getY());
		}
		
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
		// TODO Auto-generated method stub
		if (team == true) {
			if ((row == position.getX() + 1 && col == position.getY() + 1) || (row == position.getX() + 1 && col == position.getY() - 1))
				return true;
		}
		else if (team == false) {
			if ((row == position.getX() - 1 && col == position.getY() + 1) || (row == position.getX() - 1 && col == position.getY() - 1))
				return true;
		}
		
		if (!moved) {
			if ((row == position.getX() + 1 || row == position.getX() + 2) && col == position.getY() || (row == position.getX() - 1 || row == position.getX() - 2) && col == position.getY()) {
				if (row < 8) {
					moved = true;
					return true;
				}
				return false;
			}
			else return false;
		}
		else {
			if (row == position.getX() + 1 && col == position.getY()) {
				if (row < 8) return true;
				
				return false;
			}
			
			else return false;
		}
	}
		
}