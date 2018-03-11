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
		
		Piece p = board.getSquare(new Position(1, 4));
		System.out.println(p.printPieceType() + " Coordinates: " + p.getPos().getX() + ", " + p.getPos().getY());
		
		for (Position pos : p.arrMove()) {
			System.out.println("Possible Move: " + pos.getX() + ", " + pos.getY());
		}
		
		board.move(p, 3, 4);
		deepBlue.displayBoard(board);
		
		System.out.println();
		
		System.out.println(p.printPieceType() + " Coordinates: " + p.getPos().getX() + ", " + p.getPos().getY());
		for (Position pos : p.arrMove()) {
			System.out.println("Possible Move: " + pos.getX() + ", " + pos.getY());
		}
		
		board.move(p, 4, 4);
		deepBlue.displayBoard(board);
		
		System.out.println();
		
		System.out.println(p.printPieceType() + " Coordinates: " + p.getPos().getX() + ", " + p.getPos().getY());
		for (Position pos : p.arrMove()) {
			System.out.println("Possible Move: " + pos.getX() + ", " + pos.getY());
		}
		
		board.move(p, 5, 4);
		deepBlue.displayBoard(board);
		
		System.out.println();
		
		System.out.println(p.printPieceType() + " Coordinates: " + p.getPos().getX() + ", " + p.getPos().getY());
		for (Position pos : p.arrMove()) {
			System.out.println("Possible Move: " + pos.getX() + ", " + pos.getY());
		}
		
		System.out.println();
		
		Piece en = board.getSquare(new Position(p.getPos().getX() + 1, p.getPos().getY() - 1));
		
		System.out.println(en.getTeam());
//		System.out.println(p.getPos().getX() + ", " + p.getPos().getY());
//		for (Position pos : (((Pawn) p).arrMove())) {
//			System.out.println(pos.getX() + ", " + pos.getY());
//		}
//		System.out.println(((Pawn) p).hasMoved());
//		board.move(p, 3, 4);
//		Piece n = board.getSquare(new Position(3, 4));
//		System.out.println(((Pawn) n).hasMoved());
//		System.out.println(n.toString());
//		for (Position pos : (((Pawn) n).arrMove())) {
//			System.out.println(pos.getX() + ", " + pos.getY());
//		}
		
//		deepBlue.positions(board);
//		
//		deepBlue.displayAllPositions();
//		
//		deepBlue.possibleMoves(board);
//		
//		deepBlue.displayAllPossibleMoves(board);
	}
	
}
