package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueenTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		Queen queen = new Queen(1,4,true);
		
		assertEquals("Queen", queen.printPieceType());
	}
	
	@Test
	public void test_it_validates_the_moves() {
		
		Queen queen = new Queen(1,4,true);
		
		assertTrue(queen.move(2,4));
	}
	
	@Test
	public void test_it_checks_for_invalid_moves() {
		
		Queen queen = new Queen(1,4,true);
		
		assertFalse(queen.move(12,12));
	}

}
