package com.mygdx.game.rules;


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
	@Override
	public boolean move(int row, int col) {
		/**
		 * To-Do:
		 * - The queen needs to be able to check if there is a piece in front of it.
		 * - The queen needs to know if it is moving off the board.
		 */
		if(row < 8 && col < 8 && row >= 0 && col >= 0) {
			 if (row == position.getX()) {
					for(int i = 0;i<8;i++) {
						if(i == col) {
							return true;
						}
					}
				}
				else if(col == position.getY()) {
					for( int i = 0 ; i<8;i++) {
						if(i==row) {
							return true;
						}
					}
				}
			else {
				for( int i=1; i<8;i++) {
					if((row == position.getX() + i && col == position.getY() +i ) || (row == position.getX() - i && col ==position.getY() -i )||(row == position.getX() + i && col ==position.getY() -i || (row == position.getX() - i && col ==position.getY() +i ))){
						return true;
					}
				}
			}
		}
		return false;
		
		
	}

}
