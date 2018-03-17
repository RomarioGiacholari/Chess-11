package com.mygdx.game.models;

import static org.junit.Assert.*;

import org.junit.Test;

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

}
