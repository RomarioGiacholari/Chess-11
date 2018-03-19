package com.mygdx.ai.engine;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.*;
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
	
	private final int pawnValue = 1;
	
	private final int knightValue = 3;
	
	private final int bishopValue = 3;
	
	private final int kingValue = 10000;
	
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
		
		/*
		 * 1. Go through each original position and its new positions
		 * 2. If the new position has an enemy piece log that as a move
		 * 3. Otherwise pick a random move
		 */
		possibleMoves(currentBoard);
		
		// Contains the original position and new position
		ArrayList<Position> moveInfo = new ArrayList<Position>();
		
		ArrayList<Position> pawnPieces = new ArrayList<Position>();
		
		ArrayList<Position> rookPieces = new ArrayList<Position>();
		
		ArrayList<Position> knightPieces = new ArrayList<Position>();
		
		ArrayList<Position> bishopPieces = new ArrayList<Position>();
		
		ArrayList<Position> queenPieces = new ArrayList<Position>();
		
		ArrayList<Position> kingPieces = new ArrayList<Position>();
		
		for (Position originalPosition : possibleMoves.keySet()) {
			
			for (Position newPosition : possibleMoves.get(originalPosition)) {

				if (currentBoard.getSquare(newPosition) != null && currentBoard.getSquare(newPosition).getTeam() != this.team) {
					
					if (currentBoard.getSquare(originalPosition) instanceof Pawn) {
						pawnPieces.add(originalPosition);
						pawnPieces.add(newPosition);
					}
					
					else if (currentBoard.getSquare(originalPosition) instanceof Rook) {
						rookPieces.add(originalPosition);
						rookPieces.add(newPosition);
					}
					
					else if (currentBoard.getSquare(originalPosition) instanceof Knight) {
						knightPieces.add(originalPosition);
						knightPieces.add(newPosition);
					}
					
					else if (currentBoard.getSquare(originalPosition) instanceof Bishop) {
						bishopPieces.add(originalPosition);
						bishopPieces.add(newPosition);
					}
					
					else if (currentBoard.getSquare(originalPosition) instanceof Queen) {
						queenPieces.add(originalPosition);
						queenPieces.add(newPosition);
					}
					
					else if (currentBoard.getSquare(originalPosition) instanceof King) {
						kingPieces.add(originalPosition);
						kingPieces.add(newPosition);
					}
				
				}
				
			}
		}
		
		if (!pawnPieces.isEmpty()) {
			
			moveInfo.addAll(pawnPieces);
			return moveInfo;
			
		}
		
		else if (!knightPieces.isEmpty()) {
			
			moveInfo.addAll(knightPieces);
			return moveInfo;
			
		}
		
		else if (!bishopPieces.isEmpty()) {
			
			moveInfo.addAll(bishopPieces);
			return moveInfo;
			
		}
		else if (!rookPieces.isEmpty()) {
			
			moveInfo.addAll(rookPieces);
			return moveInfo;
			
		}
		else if (!queenPieces.isEmpty()) {
			
			moveInfo.addAll(queenPieces);
			return moveInfo;
			
		}
		else if (!kingPieces.isEmpty()) {
			
			moveInfo.addAll(kingPieces);
			return moveInfo;
			
		}
		
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
	
	
}
