package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class PawnTest {

	@Test
	public void test_it_prints_the_piece_type() {
		
		Pawn pawn = new Pawn(2,1,true);
		
		assertEquals("Pawn", pawn.printPieceType());
	}
	
	@Test
	public void test_it_validates_the_moves() {
		
		Pawn pawn = new Pawn(2,1,true);
		
		assertTrue(pawn.move(3,1));
	}
}
