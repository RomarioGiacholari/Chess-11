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
	
	@Override
	public boolean move(int row, int col) {
		
		if ((row < 8 && col < 8) && (row >= 0 && col >= 0)) {
			
			if ((row == position.getX() + 2 && col == position.getY() - 1) || (row == position.getX() + 2 && col == position.getY() + 1)
					|| (row == position.getX() - 2 && col == position.getY() + 1) || (row == position.getX() - 2 && col == position.getY() - 1) 
					|| (row == position.getX() + 1 && col == position.getY() + 2) || (row == position.getX() + 1 && col == position.getY() - 2)
					|| (row == position.getX() - 1 && col == position.getY() + 2) || (row == position.getX() - 1 && col == position.getY() - 2)) {
				return true;
			}
		}
		return false;
	}
	
}