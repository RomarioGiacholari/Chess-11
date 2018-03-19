package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class KingTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		King king = new King(1,5,true);
		
		assertEquals("King", king.printPieceType());
	}
	
	@Test
	public void test_it_validates_the_moves() {
		
		King king = new King(1,5,true);
		
		assertTrue(king.move(2,5));
	}
	
	@Test
	public void test_it_checks_for_invalid_moves() {
		
		King king = new King(1,5,true);
		
		assertFalse(king.move(12,12));
	}

}
