package com.mygdx.ai.engine;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Position;

public class AITest {

	public static void main(String[] args) {
		
		Board board = new Board();
		AI ai = new AI(true);
		
		board.setUp();
		ai.displayBoard(board);
		ai.addPositions(board);
		ai.displayAllPositions();
		System.out.println("Number of Positions: " + ai.getPositions().size());
		
		board.move(board.getSquare(1, 0), 2, 0);
		ai.displayBoard(board);
		ai.addPositions(board);
		ai.displayAllPositions();
		System.out.println("Number of Positions: " + ai.getPositions().size());
		
		board.move(board.getSquare(2, 0), 3, 0);
		ai.displayBoard(board);
		ai.addPositions(board);
		ai.displayAllPositions();
		System.out.println("Number of Positions: " + ai.getPositions().size());
		
	}

}
