package com.mygdx.ai.engine;

import com.mygdx.game.models.Board;
import com.mygdx.game.rules.*;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;

public class Gym {
	
	public static void main(String[] args) {
		Board board = new Board();
		ChessAI deepBlue = new ChessAI(true);
		
		board.setUp();
		
		deepBlue.displayBoard(board);
		
		System.out.println();
		
		Piece p = board.getSquare(new Position(0, 4));
		System.out.println(p.getPos().getX() + ", " + p.getPos().getY());
		System.out.println(p.toString());
		for (Position pos : (((King) p).arrMove())) {
			System.out.println(pos.getX() + ", " + pos.getY());
		}
		
//		deepBlue.positions(board);
//		
//		deepBlue.displayAllPositions();
//		
//		deepBlue.possibleMoves(board);
//		
//		deepBlue.displayAllPossibleMoves(board);
	}
	
}
