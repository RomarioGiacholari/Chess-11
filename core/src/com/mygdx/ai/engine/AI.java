package com.mygdx.ai.engine;

import java.util.ArrayList;
import java.util.Hashtable;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Knight;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;
import com.mygdx.game.rules.Rook;

public class AI {
	
	/**
	 * This decides whether the AI will play as WHITE or as BLACK.
	 * If true then the AI plays as WHITE.
	 * If black then the AI plays as BLACK.
	 */
	private boolean team;
	
	/**
	 * An ArrayList containing the positions of all of the AI's 
	 * pieces.
	 */
	private ArrayList<Position> positions;
	
	/**
	 * The Key is the current position of the AI piece.
	 * The Value is an ArrayList of all of the possible places the AI's
	 * piece can move to.
	 */
	private Hashtable<Position, ArrayList<Position>> possibleMoves;
	
	/**
	 * The AI take in a boolean value to know which side it is playing.
	 * @param team
	 */
	public AI(boolean team) {
		this.team = team;
		positions = new ArrayList<Position>();
		possibleMoves = new Hashtable<Position, ArrayList<Position>>();

	}

	public void displayAllPositions() {
		for (Position position : positions) {
			System.out.println(position.getX() + " " + position.getY());
		}
	}

	public void displayBoard(Board currentBoard) {
		// Goes down the column
		for (int i = 0; i < currentBoard.getBoard().length; i++) {
			// Goes through the row
			for (int n = 0; n < currentBoard.getBoard().length; n++) {

				System.out.print(currentBoard.getBoard()[i][n]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}

	// All of the possible positions for the AI is added to position
	public void addPositions(Board currentBoard) {
		positions.clear();
		ArrayList<Position> tempPositions = currentBoard.allPositions();
		for (Position position : tempPositions) {
			try {
				if (currentBoard.getSquare(position).getTeam() == team && currentBoard.getSquare(position) != null) {
					positions.add(position);
				}
			} catch (NullPointerException e) {}
		}
	}
	
	public void createPossibleMoves(Board currentBoard) {
		possibleMoves.clear();
		// Loop through all of the positions
		for (Position position : positions) {
			Position originalPosition = position;
			Piece selectedPiece = currentBoard.getSquare(position);
			// Create an ArrayList that contains all the positions a piece a can move to
			ArrayList<Position> newPositions = new ArrayList<Position>();
			if (selectedPiece instanceof Pawn)
				for (Position pos : ((Pawn) selectedPiece).arrMove()) {
					if (currentBoard.checkMove(selectedPiece, pos.getX(), pos.getY())) {
						newPositions.add(pos);
					}
				}
			else {
				// Loop through all of the columns
				for (int i = 0; i < currentBoard.getBoard().length; i++) {
					// Loop through all of the rows
					for (int n = 0; n < currentBoard.getBoard().length; n++) {
						// If the piece can be moved to a specified location
						try {
//							if (selectedPiece instanceof Pawn) {
//								if (selectedPiece.move(i, n)) newPositions.add(new Position(i, n));
//							}
							if (selectedPiece instanceof Knight) {
								if (selectedPiece.move(i, n)) newPositions.add(new Position(i, n));
							}
							else if (currentBoard.checkMove(selectedPiece, i, n)) {
								newPositions.add(new Position(i, n)); // Add the possible location to the newPositions ArrayList
							}
						} catch (ArrayIndexOutOfBoundsException e) {}
					}
				}
			}
			possibleMoves.put(originalPosition, newPositions);
		}
	}
	
	public void addPossibleMoves(Board currentBoard) {
		possibleMoves.clear();
		addPositions(currentBoard);
		for (Position position : positions) {
			
			Position originalPosition = position;
			Piece selectedPiece = currentBoard.getSquare(originalPosition);
			// Create an ArrayList that contains all the positions a piece can move to
			ArrayList<Position> newPositions = new ArrayList<Position>();
			
			for (int i = 0; i < currentBoard.getBoard().length; i++) {
				for  (int n = 0; n < currentBoard.getBoard().length; n++) {
					try {
						if (currentBoard.getSquare(i, n).getTeam() != team) {
							if (selectedPiece instanceof Pawn) {
								if (selectedPiece.move(i, n)) newPositions.add(new Position(i, n));
							}
							else if (selectedPiece instanceof Knight) {
								if (selectedPiece.move(i, n)) newPositions.add(new Position(i, n));
							}
							else if (currentBoard.checkMove(selectedPiece, i, n)) newPositions.add(new Position(i, n));
						}
					} catch (ArrayIndexOutOfBoundsException e) {}
				}
			}
			newPositions.remove(originalPosition);
			possibleMoves.put(originalPosition, newPositions);
		}
	}
	
//	public void addPossibleMoves(Board currentBoard) {
//		addPositions(currentBoard);
//		Board originalBoard = currentBoard;
//		for (Position position : positions) {
//
//			Position orignalPosition = position;
//			
//			ArrayList<Position> newPositions = new ArrayList<Position>();
//			for (int i = 0; i < 8; i++) {
//				for (int n = 0; n < 8; n++) {
//					try {
//						if (currentBoard.move(currentBoard.getSquare(position), i, n)) {
////							Position newLocation = new Position(i, n);
//							newPositions.add(position);
////							currentBoard = originalBoard;
//						}
//						currentBoard.setPiece(currentBoard.getSquare(position), orignalPosition);
//					} catch (NullPointerException e) {}
//				}				
//			}
//			possibleMoves.put(position, newPositions);
//		}
//	}

	public Hashtable<Position, ArrayList<Position>> getPossibleMoves() { return possibleMoves; }

	public ArrayList<Position> getPositions() { return positions; }
	
}