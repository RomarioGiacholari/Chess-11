package com.mygdx.game.rules;

import java.util.ArrayList;

import com.mygdx.game.models.Board;

public class Knight extends Piece {
	
	public Knight(int row, int col, boolean player) {
		super(row, col, player);
		// TODO Auto-generated constructor stub
	}
	public String printPieceType(){
		System.out.println("Knight");
		return "Knight";
	}
	
	public String toString() {
		if(team) {
			return "H";
		}
		else {
			return "h";
		}
	}
	
	public ArrayList<Position> arrMove() {
		ArrayList<Position> possibleMoves = new ArrayList<Position>();
		
		possibleMoves.add(new Position(position.getX() - 2, position.getY() - 1));
		possibleMoves.add(new Position(position.getX() - 2, position.getY() + 1));
		possibleMoves.add(new Position(position.getX() - 1, position.getY() + 2));
		possibleMoves.add(new Position(position.getX() - 1, position.getY() - 2));
		possibleMoves.add(new Position(position.getX() + 1, position.getY() - 2));
		possibleMoves.add(new Position(position.getX() + 1, position.getY() + 2));
		possibleMoves.add(new Position(position.getX() + 2, position.getY() + 1));
		possibleMoves.add(new Position(position.getX() + 2, position.getY() - 1));
		
		for (Position position : possibleMoves) {
			if ((position.getX() > 7 && position.getX() < 0)) {
				possibleMoves.remove(position);
			}
		}
		return possibleMoves;
	}
	
	/**
	 * The user supplies this method with the row and col. If that row and column exist in
	 * possibleMoves ArrayList then returns true.
	 * Other wise false.
	 * @Warning This method does not check if another piece is on the new tile location.
	 */
	@Override
	public boolean move(int row, int col) {
		
		for (Position position : arrMove()) {
			if (position.getX() == row && position.getY() == col) return true;
		}
		
		return false;
	
	}
	
}