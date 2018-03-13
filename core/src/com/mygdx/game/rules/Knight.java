package com.mygdx.game.rules;

import java.util.ArrayList;
import java.util.HashMap;

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
	
	public HashMap<String, ArrayList<Position>> hashMove() {
		HashMap<String, ArrayList<Position>> moves = new HashMap<String, ArrayList<Position>>();
		ArrayList<Position> up1Left = new ArrayList<Position>();
		ArrayList<Position> up2Left = new ArrayList<Position>();
		ArrayList<Position> up1Right = new ArrayList<Position>();
		ArrayList<Position> up2Right = new ArrayList<Position>();
		ArrayList<Position> down1Left = new ArrayList<Position>();
		ArrayList<Position> down2Left = new ArrayList<Position>();
		ArrayList<Position> down1Right = new ArrayList<Position>();
		ArrayList<Position> down2Right = new ArrayList<Position>();
		ArrayList<Position> outOfBounds = new ArrayList<Position>();
		
		down1Left.add(new Position(position.getX() - 2, position.getY() - 1));
		down1Right.add(new Position(position.getX() - 2, position.getY() + 1));
		down2Right.add(new Position(position.getX() - 1, position.getY() + 2));
		down2Left.add(new Position(position.getX() - 1, position.getY() - 2));
		up2Left.add(new Position(position.getX() + 1, position.getY() - 2));
		up2Right.add(new Position(position.getX() + 1, position.getY() + 2));
		up1Left.add(new Position(position.getX() + 2, position.getY() + 1));
		up1Right.add(new Position(position.getX() + 2, position.getY() - 1));
		
		for (Position pos : down1Left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : down1Right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : down2Right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : down2Left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : up2Left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : up2Right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : up1Left) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		for (Position pos : up1Right) if (pos.checkOutOfBounds()) outOfBounds.add(pos);
		
		down1Left.removeAll(outOfBounds);
		down2Left.removeAll(outOfBounds);
		down1Right.removeAll(outOfBounds);
		down2Right.removeAll(outOfBounds);
		up1Left.removeAll(outOfBounds);
		up2Left.removeAll(outOfBounds);
		up1Right.removeAll(outOfBounds);
		up2Right.removeAll(outOfBounds);
				
		moves.put("down1Left", down1Left);
		moves.put("down2Left", down2Left);
		moves.put("down1Right", down1Right);
		moves.put("down2Right", down2Right);
		moves.put("up1Left", up1Left);
		moves.put("up2Left", up2Left);
		moves.put("up1Right", up1Right);
		moves.put("up2Right", up2Right);
		
		return moves;
	}
	
	/**
	 * The user supplies this method with the row and col. If that row and column exist in
	 * possibleMoves ArrayList then returns true.
	 * Other wise false.
	 * @Warning This method does not check if another piece is on the new tile location.
	 */
	@Override
	public boolean move(int row, int col) {
		Position choice = new Position(row, col);
		
		for (String direction : hashMove().keySet()) {
			if (hashMove().get(direction).contains(choice)) return true;
		}
		
		return false;
		
	}
	
}