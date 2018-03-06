package com.mygdx.ai.engine;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Position;

public class Gym {
	
	public static void main(String[] args) {
		Board board = new Board();
		ChessAI deepBlue = new ChessAI(true);
		
		board.setUp();
		
		deepBlue.displayBoard(board);
		
		deepBlue.positions(board);
		
		deepBlue.displayAllPositions();
		
		deepBlue.possibleMoves(board);
		
		deepBlue.displayAllPossibleMoves(board);
	}
	
}
