package com.mygdx.game.rules;

import java.util.ArrayList;

public class Bishop extends Piece{

	protected boolean moved = false;

	public Bishop(int row, int col, boolean player) {
		super(row, col, player);
	}
	public String printPieceType(){
		System.out.println("Bishop");
		return "Bishop";
	}
	
	public String toString() {
		if(team) {	
			return "B";
		} else {
			return "b";
		}
	}
	
	public ArrayList<Position> arrMove() {
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		for (int i = 0; i < 8; i++) {
			// Up Right moves
			possibleMoves.add(new Position(position.getX() - i, position.getY() + i));
			// Down Right moves
			possibleMoves.add(new Position(position.getX() + i, position.getY() + i));
			// Up Left moves
			possibleMoves.add(new Position(position.getX() - i, position.getY() - i));
			// Down Left moves
			possibleMoves.add(new Position(position.getX() + i, position.getY() - i));
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