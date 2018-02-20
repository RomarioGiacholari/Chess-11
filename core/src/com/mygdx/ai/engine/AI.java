package com.mygdx.ai.engine;

import java.util.ArrayList;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;

public class AI {
	
	private ArrayList boardStates;
	private Board board;
	private Piece piece;
	
	public AI () {
		board = new Board();
		boardStates = new ArrayList<Piece[][]>();
		board.setUp();
		System.out.println(board.numberOfPieces());
	}
	
	public void checkPossibleMoves (Piece[][] currentState) {
		// Goes down the column
		for (int i = 0; i < currentState.length; i++) {
			// Goes through the row
			for (int n = 0; n < currentState.length; n++) {
				
				System.out.print(currentState[i][n]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public void possibleMoves (Board currentState) {
		int count = 0;
		while (count <= board.getNumberOfPieces()) {
			/* Search for pieces increment count if piece found */
			
		}
		Piece somePiece = currentState.getSquare(new Position(1, 0));
		if (somePiece instanceof Pawn) {
			for (int i = 0; i < 3; i++) {
				
			}
			System.out.println(((Pawn) somePiece).arrMove());
			
		}
//		if (board.checkUp(currentState[1][0], new Position(4, 0))) {
//			System.out.println("DONE");
//		} else {
//			System.out.println("CANNOT BE DONE");
//		}
	}
	
	public void testMethod () {
		possibleMoves(board);
	}
	
//	public static void main (String[] args) {
//		System.out.println(board.getBoard()[0][1]);
//		board.move(board.getBoard()[1][0], 2, 0);
//		for (Piece[] row : board.getBoard()) {
//			printRow(row);
//		}
//	
//	}
}