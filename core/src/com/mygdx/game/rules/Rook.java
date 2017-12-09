package com.mygdx.game.rules;


public class Rook extends Piece{


	public Rook(int row, int col, boolean player) {
		super(row, col, player);
		// TODO Auto-generated constructor stub
	}
	public String printPieceType(){
		System.out.println("Rook");
		return "Rook";
	}
	
	public String toString() {
		if(team) {
			return "R";
		}
		else {
			return"r";
		}
	}

	@Override
	public boolean move(int row, int col) {
		// TODO Auto-generated method stub
		if((row <8 && col<8)&&(row >= 0 && col>=0)) {
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
			
		}
		
		return false;
		
	}

}