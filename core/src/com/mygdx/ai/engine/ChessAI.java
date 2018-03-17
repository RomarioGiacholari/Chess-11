package com.mygdx.ai.engine;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Knight;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;

/**
 * The artificial intelligence for the chess game 
 * @author Farhan Ali
 *
 */
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
	
	private Random random;
	
	
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
		random = new Random();
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
		positions(currentBoard);
		possibleMoves.clear();
		
		/**
		 * 1. Loop through all of the AI's positions
		 * 2. Get the piece at the selected position
		 * 3. Go through every square on the board and the ones
		 * 	  that are possible will be added to the Hashtable
		 */
		
		for (Position location : positions) {
			
			Piece selectedPiece = currentBoard.getSquare(location);
			ArrayList<Position> newLocations = new ArrayList<Position>();
			
			for (int i = 0; i < Board.DIMENSIONS; i++) {
				
				for (int y = 0; y < Board.DIMENSIONS; y++) {
					try {
						if (currentBoard.checkMove(selectedPiece, i, y)) {
							
							newLocations.add(new Position(i, y));
							
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
					
				}
				
			}
			if (newLocations.size() > 0) possibleMoves.put(location, newLocations);
		}
	}
	
	/**
	 * Selects a random move from the possibleMoves Hashtable
	 * @return position where the piece will be placed.
	 */
	public ArrayList<Position> selectAMove(Board currentBoard) {
		
		possibleMoves(currentBoard);
		
		ArrayList<Position> moveInfo = new ArrayList<Position>();
		
		ArrayList<Position> currentPositions = new ArrayList<Position>();
		
		for (Position pos : possibleMoves.keySet()) currentPositions.add(pos);
		
		Position currentPosition = currentPositions.get(random.nextInt(currentPositions.size()));
		
		ArrayList<Position> newLocations = possibleMoves.get(currentPosition);
		
		Position newPosition = newLocations.get(random.nextInt(newLocations.size()));
		
		moveInfo.add(currentPosition);
		moveInfo.add(newPosition);
		
		return moveInfo;
	}
	
	public boolean getTeam() {
		return this.team;
	}
	
	
	public ArrayList<Position> getPositions() {
		return positions;
	}
	
	public Hashtable<Position, ArrayList<Position>> getPossibleMoves() {
		return possibleMoves;
	}
	
	
	// Methods below are for testing purposes only
	public void displayBoard(Board currentBoard) {
		
		for (int i = 0; i < Board.DIMENSIONS; i++) {
			
			for(int n = 0; n < Board.DIMENSIONS; n++) {
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
