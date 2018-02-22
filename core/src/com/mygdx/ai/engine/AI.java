package com.mygdx.ai.engine;

import java.util.ArrayList;
import java.util.Hashtable;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;

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
	
	
	private Hashtable<Position, ArrayList<Position>> possibleMoves;

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
				if (currentBoard.getSquare(position).getTeam() == team) {
					positions.add(position);
				}
			} catch (NullPointerException e) {}
		}
	}

	public void addPossibleMoves(Board currentBoard) {
		for (Position position : positions) {
			ArrayList<Position> newPositions = new ArrayList<Position>();
			for (int i = 0; i < currentBoard.getBoard().length; i++)
				for (int n = 0; n < currentBoard.getBoard().length; n++)
					try {
						if (currentBoard.move(currentBoard.getSquare(position), i, n))
							newPositions.add(new Position(i, n));
						possibleMoves.put(position, newPositions);

					} catch (NullPointerException e) {}
		}
	}

	public Hashtable<Position, ArrayList<Position>> getPossibleMoves() {
		return possibleMoves;
	}

	public ArrayList<Position> getPositions() {
		return positions;
	}

	// public void possibleMoves (Piece[][] currentState) {
	//
	// int count = 0;
	// int row = 0;
	// int col = 0;
	//
	// while (true) {
	//
	// if (board.move(board., row, col))
	//
	// }
	//
	//
	// while (count <= board.numberOfPieces()) {
	//
	// for (int i = 0; i < currentState.length; i++) {
	// for (int n = 0; n < currentState.length; n++) {
	//
	// }
	// }
	// if (board.move(board.getSquare(row, col), row, col))
	//
	// }
	//
	// }

	// public void testMethod () {
	// possibleMoves(board);
	// }

	// public static void main (String[] args) {
	// System.out.println(board.getBoard()[0][1]);
	// board.move(board.getBoard()[1][0], 2, 0);
	// for (Piece[] row : board.getBoard()) {
	// printRow(row);
	// }
	//
	// }
}