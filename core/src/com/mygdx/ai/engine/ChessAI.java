package com.mygdx.ai.engine;

import java.util.ArrayList;
import java.util.Hashtable;

import com.mygdx.game.models.Board;
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
			// Possible locations for the piece to move to
			ArrayList<Position> moves = new ArrayList<Position>();
			
			for (int i = 0; i < currentBoard.DIMENSIONS; i++) {
				for (int n = 0; n < currentBoard.DIMENSIONS; n++) {
					
				}
			}
			
		}
	}
	
	public ArrayList<Position> getPositions() {
		return positions;
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
	
}
