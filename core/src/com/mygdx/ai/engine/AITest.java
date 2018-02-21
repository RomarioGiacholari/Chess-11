package com.mygdx.ai.engine;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.Position;

public class AITest {

	public static void main(String[] args) {
		
		Board board = new Board();
		board.setUp();
		AI ai = new AI(board);
		ai.displayBoard(board);
		System.out.println(board.allPositions().size());
//		ai.displayAllPositions();
		
//		System.out.println("\n\n");
//		
//		board.move(board.getSquare(1, 0), 2, 0);
//		ai.displayBoard(board);
//		System.out.println();
//		ai.displayAllPositions();
		
	}

}
