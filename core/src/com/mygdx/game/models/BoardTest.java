package com.mygdx.game.models;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mygdx.game.rules.Piece;

public class BoardTest {

	@Test
	public void test_that_the_rook_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Rook", board.getSquare(0, 0).printPieceType());
	}
	
	@Test
	public void test_that_the_knight_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Knight", board.getSquare(0, 1).printPieceType());
	}
	
	@Test
	public void test_that_the_bishop_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Bishop", board.getSquare(0, 2).printPieceType());
	}
	
	@Test
	public void test_that_the_queen_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Queen", board.getSquare(0, 3).printPieceType());
	}
	
	@Test
	public void test_that_the_king_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("King", board.getSquare(0, 4).printPieceType());
	}
	
	@Test
	public void test_that_the_secondBishop_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Bishop", board.getSquare(0, 5).printPieceType());
	}
	
	@Test
	public void test_that_the_secondKnight_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Knight", board.getSquare(0, 6).printPieceType());
	}
	
	@Test
	public void test_that_the_secondRook_is_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		assertEquals("Rook", board.getSquare(0, 7).printPieceType());
	}
	
	@Test
	public void test_that_the_pawns_are_allocated_to_the_correct_position_once_the_board_is_set_up() {
		
		Board board = new Board();
		
		board.setUp();
		
		for(int i = 0; i < 8; i++) {
			assertEquals("Pawn", board.getSquare(1, i).printPieceType());
		}
		
	}
	
	@Test
	public void test_that_it_checks_for_collision() {
		
		Board board = new Board();
		
		board.setUp();
		
		Piece pawn = board.getSquare(1, 0);
		
		assertTrue(board.collision(pawn, 6, 0));
	
	}

}
