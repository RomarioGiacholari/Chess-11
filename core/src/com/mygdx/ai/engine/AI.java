package com.mygdx.ai.engine;

import java.util.ArrayList;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Piece;

public class AI {
	
	private ArrayList boardStates;
	private Board board;
	private Piece piece;
	
	public AI () {
		board = new Board();
		boardStates = new ArrayList<Piece[][]>();
		board.setUp();
	}
	
	public void checkPossibleMoves (Piece[][] currentState) {
		// Goes down the column
		for (int i = 0; i < currentState.length; i++) {
			// Goes through the row
			for (int n = 0; n < currentState.length; n++) {
				
				if (board.checkUp(currentState[i][n], board.get))
				System.out.print(currentState[i][n]);
				System.out.print("\t");
			}
			System.out.println();
		}
	}
	
	public static void printRow (Piece[] row) {
		for (Piece i : row) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.println();
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