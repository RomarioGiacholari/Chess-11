package com.mygdx.game.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class PositionTest {

	@Test
	public void test_it_returns_true_if_position_is_out_of_bounds() {
		
		Position position = new Position(12,5);
		
		assertTrue(position.checkOutOfBounds());
	}
	
	@Test
	public void test_it_returns_false_if_position_is_within_bounds() {
		
		Position position = new Position(5,5);
		
		assertFalse(position.checkOutOfBounds());
	}


}
