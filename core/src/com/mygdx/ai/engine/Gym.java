package com.mygdx.ai.engine;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Position;

public class Gym {
	
	public static void main(String[] args) {
		Board board = new Board();
		ChessAI deepBlue = new ChessAI(false);
		
		board.setUp();
		
		deepBlue.displayBoard(board);
		
		deepBlue.positions(board);
		
		deepBlue.displayAllPositions();
		
		System.out.println(board.checkMove(board.getSquare(new Position(1, 0)), 4, 0));
	}
	
}
