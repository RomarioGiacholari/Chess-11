package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class KnightTest {


	@Test
	public void test_it_prints_the_piece_type() {
		
		Knight knight = new Knight(1,2,true);
		
		assertEquals("Knight", knight.printPieceType());
	}
	
	@Test
	public void test_it_validates_the_moves() {
		
		Knight knight = new Knight(1,2,true);
		
		assertTrue(knight.move(3,1));
	}
	
	@Test
	public void test_it_checks_for_invalid_moves() {
		
		Knight knight = new Knight(1,2,true);
		
		assertFalse(knight.move(12,12));
	}


}
