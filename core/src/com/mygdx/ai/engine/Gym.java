package com.mygdx.ai.engine;

import java.util.Random;

import com.mygdx.game.models.Board;

public class Gym {
	
	
	public static void main(String[] args) {
		Board board = new Board();
		ChessAI deepBlue = new ChessAI(true);
		
		Random rand = new Random();
		
		
		board.setUp();
		
		deepBlue.displayBoard(board);
		
		System.out.println();
		
		System.out.println("All Positions: ");
		deepBlue.positions(board);
		deepBlue.displayAllPositions();
		
		System.out.println();
		
		deepBlue.possibleMoves(board);
		
		deepBlue.displayAllPossibleMoves(board);
		
		int selectPosition = rand.nextInt(deepBlue.getPossibleMoves().size());
		
		System.out.println();
		
		
		
		
	}
	
}
