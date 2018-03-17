package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class BishopTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		Bishop bishop = new Bishop(1,4,true);
		
		assertEquals("Bishop", bishop.printPieceType());
	}
	
	@Test
	public void test_it_validates_the_moves() {
		
		Bishop bishop = new Bishop(1,4,true);
		
		assertTrue(bishop.move(2,3));
	}
	
	@Test
	public void test_it_validates_invalid_moves() {
		
		Bishop bishop = new Bishop(1,4,true);
		
		assertTrue(bishop.move(12,12));
	}

}
