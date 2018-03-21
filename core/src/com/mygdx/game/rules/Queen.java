package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public HashMap<String, ArrayList<Position>> hashMove() {
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();
		ArrayList<Position> left = new ArrayList<Position>();
		ArrayList<Position> right = new ArrayList<Position>();
		ArrayList<Position> up = new ArrayList<Position>();
		ArrayList<Position> down = new ArrayList<Position>();
		ArrayList<Position> upRight = new ArrayList<Position>();
		ArrayList<Position> downRight = new ArrayList<Position>();
		ArrayList<Position> upLeft = new ArrayList<Position>();
		ArrayList<Position> downLeft = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		for (int i = 0; i < 8; i++) {
			upRight.add(new Position(position.getX() - i, position.getY() + i));
			downRight.add(new Position(position.getX() + i, position.getY() + i));
			upLeft.add(new Position(position.getX() - i, position.getY() - i));
			downLeft.add(new Position(position.getX() + i, position.getY() - i));
			down.add(new Position(position.getX() + i, position.getY()));
			up.add(new Position(position.getX() - i, position.getY()));
			right.add(new Position(position.getX(), position.getY() + i));
			left.add(new Position(position.getX(), position.getY() - i));
		}
		
		while (true) {
			if (up.contains(position)) up.remove(position);
			if (down.contains(position)) down.remove(position);
			if (left.contains(position)) left.remove(position);
			if (right.contains(position)) right.remove(position);
			if (upRight.contains(position)) upRight.remove(position);
			if (downRight.contains(position)) downRight.remove(position);
			if (upLeft.contains(position)) upLeft.remove(position);
			if (downLeft.contains(position)) downLeft.remove(position);
			else break;
		}
		
		for (Position pos : up) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : down) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : upRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : downRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : upLeft) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : downRight) if (pos.checkOutOfBounds()) outOfBounds.add(pos);

		up.removeAll(outOfBounds);
		down.removeAll(outOfBounds);
		right.removeAll(outOfBounds);
		left.removeAll(outOfBounds);
		upRight.removeAll(outOfBounds);
		downRight.removeAll(outOfBounds);
		upLeft.removeAll(outOfBounds);
		downLeft.removeAll(outOfBounds);
		
		moves.put("up", up);
		moves.put("down", down);
		moves.put("left", left);
		moves.put("right", right);
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
