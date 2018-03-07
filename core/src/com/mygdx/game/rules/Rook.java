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
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		for (int i = 0; i < 8; i++) {
			possibleMoves.add(new Position(position.getX() + i, position.getY()));
			possibleMoves.add(new Position(position.getX() - i, position.getY()));
			possibleMoves.add(new Position(position.getX(), position.getY() + i));
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
		
		for (Position pos : arrMove()) {
			if (pos.getX() == row && pos.getY() == col) return true;
		}
		
		return false;
	}

}