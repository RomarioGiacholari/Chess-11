package com.mygdx.ai.engine;

import java.util.ArrayList;
import java.util.Hashtable;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Knight;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;

public class ChessAI {
	
	/**
	 * Team the AI is playing as.
	 * WHITE - TRUE
	 * BLACK - FALSE
	 */
	private boolean team;
	
	/**
	 * ArrayList to hold all of the positions of the 
	 * AI's pieces.
	 */
	private ArrayList<Position> positions;
	
	/**
	 * Hashtable for all of the possible moves the AI can play
	 * KEY - POSITION -> original position of the piece
	 * VALUE - ARRAYLIST<POSITION> -> the possible positions the piece can move to
	 */
	private Hashtable<Position, ArrayList<Position>> possibleMoves;
	
	public ChessAI(boolean team) {
		this.team = team;
		positions = new ArrayList<Position>();
		possibleMoves = new Hashtable<Position, ArrayList<Position>>();
	}
	
	/**
	 * Adds all of the positions of pieces that are of the AI's
	 * team and adds it to the positions ArrayList.
	 * @param currentBoard -> the current state of the board
	 */
	public void positions(Board currentBoard) {
		positions.clear();
		ArrayList<Position> allPositions = currentBoard.allPositions();
		for (Position position : allPositions) {
			if (currentBoard.getSquare(position).getTeam() == team) {
				positions.add(position);
			}
		}
	}
	
	public void possibleMoves(Board currentBoard) {
		possibleMoves.clear();
		
		for (Position position : positions) {
			// Store the original position
			Position originalPosition = position;
			// Selected piece to be moved
			Piece selectedPiece = currentBoard.getSquare(originalPosition);
			// Possible locations for the piece to move to
			ArrayList<Position> newPositions = new ArrayList<Position>();
			
			if (selectedPiece instanceof Pawn) {
				for (Position pos : ((Pawn) selectedPiece).arrMove()) {
					if (currentBoard.checkMove(selectedPiece, pos.getX(), pos.getY())) {
						newPositions.add(pos);
					}
				}
			}
			else if (selectedPiece instanceof Knight) {
				for (Position pos : ((Knight) selectedPiece).arrMove()) {
					if (selectedPiece.move(pos.getX(), pos.getY()) && currentBoard.checkMove(selectedPiece, pos.getX(), pos.getY())) {
						newPositions.add(pos);
					}
				}
			}
			else {
				// Loop through all of the columns
				for (int i = 0; i < Board.DIMENSIONS; i++) {
					// Loop through all of the rows
					for (int n = 0; n < Board.DIMENSIONS; n++) {
						try {
							if (currentBoard.checkMove(selectedPiece, i, n)) {
								newPositions.add(new Position(i, n));
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					}
				}
			}
			possibleMoves.put(originalPosition, newPositions);
		}
	}
	
	public ArrayList<Position> getPositions() {
		return positions;
	}
	
	public Hashtable<Position, ArrayList<Position>> getPossibleMoves() {
		return possibleMoves;
	}
	
	
	// Methods below are for testing purposes only
	public void displayBoard(Board currentBoard) {
		
		for (int i = 0; i < currentBoard.DIMENSIONS; i++) {
			
			for(int n = 0; n < currentBoard.DIMENSIONS; n++) {
				System.out.print(currentBoard.getBoard()[i][n] + "\t");
			}
			System.out.println();
		}
		
	}
	
	public void displayAllPositions() {
		for (Position position : positions) System.out.println(position.getX() + ", " + position.getY());
	}
	
	public void displayAllPossibleMoves(Board currentBoard) {
		for (Position location : possibleMoves.keySet()) {
			System.out.println("Original Location: " + location.getX() + ", " + location.getY());
			for (Position newLocation : possibleMoves.get(location)) {
				System.out.println(newLocation.getX() + ", " + newLocation.getY());
			}
		}
	}
	
}
