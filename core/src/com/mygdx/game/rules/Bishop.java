package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public HashMap<String, ArrayList<Position>> hashMove() {
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();
		ArrayList<Position> upRight = new ArrayList<Position>();
		ArrayList<Position> downRight = new ArrayList<Position>();
		ArrayList<Position> upLeft = new ArrayList<Position>();
		ArrayList<Position> downLeft = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		for (int i = 0; i < 8; i++) {
			// Up Right moves
			upRight.add(new Position(position.getX() - i, position.getY() + i));
			// Down Right moves
			downRight.add(new Position(position.getX() + i, position.getY() + i));
			// Up Left moves
			upLeft.add(new Position(position.getX() - i, position.getY() - i));
			// Down Left moves
			downLeft.add(new Position(position.getX() + i, position.getY() - i));
		}
		
		while (true) {
			if (upRight.contains(position)) upRight.remove(position);
			if (downRight.contains(position)) downRight.remove(position);
			if (upLeft.contains(position)) upLeft.remove(position);
			if (downLeft.contains(position)) downLeft.remove(position);
			break;
		}
		
		
		for (Position pos : upRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : downRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : upLeft) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : downRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		upRight.removeAll(outOfBounds);
		downRight.removeAll(outOfBounds);
		upLeft.removeAll(outOfBounds);
		downLeft.removeAll(outOfBounds);
		
		moves.put("upRight", upRight);
		moves.put("downRight", downRight);
		moves.put("upLeft", upLeft);
		moves.put("downLeft", downLeft);
		
		return moves;
	}
	
	@Override
	public boolean move(int row, int col) {
		Position choice = new Position(row, col);
		
		for (String direction : hashMove().keySet()) {
			if (hashMove().get(direction).contains(choice)) return true;
		} 
	
		return false;
	
	}
}