package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class RookTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		Rook rook = new Rook(1,1,true);
		
		assertEquals("Rook", rook.printPieceType());
	}
	
	@Test
	public void test_it_validates_the_moves() {
		
		Rook rook = new Rook(1,1,true);
		
		assertTrue(rook.move(2,1));
	}
}
