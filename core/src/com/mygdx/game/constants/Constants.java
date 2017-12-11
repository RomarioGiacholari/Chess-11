package com.mygdx.game.constants;

import com.mygdx.game.rules.Piece;

public final class Constants{

	public static int count = 0;
	public static Piece piece = null;
	public static int x = 0;
	public static int y = 0;
	
	public static void reset() {
		count = 0;
	}
	
	public static void increment() {
		count ++;
	}
	
	public static void setPiece(Piece thePiece) {
		piece = thePiece;
	}
	
	public static void setY(int theY) {
		y = theY;
	}
	
	public static void setX(int theX) {
		x = theX;
	}
}