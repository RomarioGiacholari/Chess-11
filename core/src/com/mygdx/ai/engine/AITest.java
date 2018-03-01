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
		
		ai.createPossibleMoves(board);
		
		
//		
//		System.out.println("\n");
//		ai.createPossibleMoves(board);

		for (Position location : ai.getPossibleMoves().keySet()) {
			System.out.println("Original Location: " + location.getX() + ", " + location.getY());
			for(Position newLocation : ai.getPossibleMoves().get(location)) {
				System.out.println(newLocation.getX() + ", " + newLocation.getY());
			} 
		}
		
		System.out.println("\n\n");
		board.move(board.getSquare(new Position(1, 3)), 4, 3);
		ai.displayBoard(board);
		ai.addPositions(board);
		ai.displayAllPositions();
		System.out.println("Number of Positions: " + ai.getPositions().size());
		ai.createPossibleMoves(board);
		for (Position location : ai.getPossibleMoves().keySet()) {
			System.out.println("Original Location: " + location.getX() + ", " + location.getY());
			for(Position newLocation : ai.getPossibleMoves().get(location)) {
				System.out.println(newLocation.getX() + ", " + newLocation.getY());
			} 
		}
//		

//		ai.displayBoard(board);
//		ai.addPositions(board);
//		ai.displayAllPositions();
//		System.out.println("Number of Positions: " + ai.getPositions().size());
		
	}

}
