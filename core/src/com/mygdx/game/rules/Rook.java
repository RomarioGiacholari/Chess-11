package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public HashMap<String, ArrayList<Position>> hashMove() {
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();
		ArrayList<Position> left = new ArrayList<Position>();
		ArrayList<Position> right = new ArrayList<Position>();
		ArrayList<Position> up = new ArrayList<Position>();
		ArrayList<Position> down = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		for (int i = 0; i < 8; i++) {
			// Up
			up.add(new Position(position.getX() + i, position.getY()));
			// Down
			down.add(new Position(position.getX() - i, position.getY()));
			// Right
			right.add(new Position(position.getX(), position.getY() + i));
			// Left
			left.add(new Position(position.getX(), position.getY() - i));
		}
		
		while (true) {
			if (up.contains(position)) up.remove(position);
			if (down.contains(position)) down.remove(position);
			if (left.contains(position)) left.remove(position);
			if (right.contains(position)) right.remove(position);
			else break;
		}
		
		for (Position pos : up) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : down) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		up.removeAll(outOfBounds);
		down.removeAll(outOfBounds);
		right.removeAll(outOfBounds);
		left.removeAll(outOfBounds);
		
		moves.put("up", up);
		moves.put("down", down);
		moves.put("left", left);
		moves.put("right", right);
		
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