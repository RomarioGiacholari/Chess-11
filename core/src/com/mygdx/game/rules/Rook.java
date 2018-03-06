package com.mygdx.game.rules;

import java.util.ArrayList;

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
	
	public ArrayList<Position> arrMove() {
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		
		for (int i = 0; i < 8; i++) {
			
			if (i == position.getX()) continue;
			else possibleMoves.add(new Position(position.getX() + i, position.getY()));
			
			if (i == position.getY()) continue;
			else possibleMoves.add(new Position(position.getY(), position.getX() + i));
		}

		return possibleMoves;
	}
	
	@Override
	public boolean move(int row, int col) {
		
		for (Position position : arrMove()) {
			if (position.getX() == row && position.getY() == col) return true;
		}
		
		return false;
	}

}