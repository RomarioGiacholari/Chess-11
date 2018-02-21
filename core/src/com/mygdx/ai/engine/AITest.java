package com.mygdx.ai.engine;

import com.mygdx.game.models.Board;

public class AITest {

	public static void main(String[] args) {
		
		AI ai = new AI();
		Board board = new Board();
		board.setUp();
		ai.displayBoard(board.getBoard());
		board.move(board.getSquare(1, 0), 5, 0);
		System.out.println("------------------------------------------------------------");
		ai.displayBoard(board.getBoard());
	}

}
