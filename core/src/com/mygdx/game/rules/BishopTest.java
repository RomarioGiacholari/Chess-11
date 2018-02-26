package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

import com.badlogic.gdx.ai.utils.Location;

public class BishopTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		Bishop bishop = new Bishop(1,4,true);
		assertEquals("Bishop",bishop.printPieceType());	
	}
	
	@Test
	public void test_it_returns_the_position_of_the_piece() {
		
		Bishop bishop = new Bishop(1,4,true);
		
		Position position = bishop.getPos();
		
		assertEquals(4, position.getY());
	}
	
	@Test
	public void test_it_allows_a_piece_to_be_moved_to_location_withn_the_board() {
		
		Bishop bishop = new Bishop(1,4,true);
	
		assertTrue(bishop.move(2,3));	
	}
	
	@Test
	public void test_it_cannot_move_the_piece_to_a_location_outside_the_board_limits() {
		
		Bishop bishop = new Bishop(1,4,true);
	
		assertFalse(bishop.move(9,9));	
	}

}
