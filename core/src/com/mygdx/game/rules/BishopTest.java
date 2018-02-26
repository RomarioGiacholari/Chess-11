package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		Bishop bishop = new Bishop(1,4,true);
		assertEquals("Bishop",bishop.printPieceType());	
	}
	
	@Test
	public void test_it_moves_the_piece_to_a_valid_location() {
		
		Bishop bishop = new Bishop(1,4,true);
	
		assertTrue(bishop.move(2,3));	
	}
	
	@Test
	public void test_it_cannot_move_the_piece_to_a_location_outside_the_board_limits() {
		
		Bishop bishop = new Bishop(1,4,true);
	
		assertFalse(bishop.move(9,9));	
	}

}
