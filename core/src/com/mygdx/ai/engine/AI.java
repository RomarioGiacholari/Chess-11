package com.mygdx.ai.engine;

import java.util.ArrayList;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;

public class AI {
	
	private ArrayList boardStates;
	private Board board;
	private Piece team;
	
	public AI (Board board, boolean team) {
		this.board = board;
		this.team = new Piece();
		boardStates = new ArrayList<Piece[][]>();
		
	}
	
	public void displayAllPositions () {
		for (Position position : board.allPositions()) {
			System.out.println(position.getX() + " " + position.getY());
		}
	}
	
	public void displayBoard (Board currentState) {
		// Goes down the column
		for (int i = 0; i < currentState.getBoard().length; i++) {
			// Goes through the row
			for (int n = 0; n < currentState.getBoard().length; n++) {
				
				System.out.print(currentState.getBoard()[i][n]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
//	public void possibleMoves (Piece[][] currentState) {
//		
//		int count = 0;
//		int row = 0;
//		int col = 0;
//		
//		while (true) {
//			
//			if (board.move(board., row, col))
//			
//		}
//		
//		
//		while (count <= board.numberOfPieces()) {
//			
//			for (int i = 0; i < currentState.length; i++) {
//				for (int n = 0; n < currentState.length; n++) {
//					
//				}
//			}
//			if (board.move(board.getSquare(row, col), row, col))
//			
//		}
//		
//	}
	
//	public void testMethod () {
//		possibleMoves(board);
//	}
	
//	public static void main (String[] args) {
//		System.out.println(board.getBoard()[0][1]);
//		board.move(board.getBoard()[1][0], 2, 0);
//		for (Piece[] row : board.getBoard()) {
//			printRow(row);
//		}
//	
//	}
}