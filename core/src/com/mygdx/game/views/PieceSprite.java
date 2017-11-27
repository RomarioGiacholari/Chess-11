package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.rules.Piece;

public abstract class PieceSprite {

	Texture sprite;
	
	
	private static final int PIECE_MOVEMENT =64;
	
	private int pieceX=0;
	private int pieceY=0;
	
	public PieceSprite() {
		
	}
	
	public void draw(Batch batch) {
		batch.draw(sprite,getPieceX(),getPieceY());
	}
	
	public int getPieceX() {
		return pieceX;
	}
	
	public int getPieceY() {
		return pieceY;
	}
	
	public void setPos(int x, int y) {
		pieceX = x;
		pieceY = y;
	}
	
	public void setX(int x) {
		pieceX = x;
	}
	
	public void setY(int y) {
		pieceY = y;
	}
	
	public int getMovement() {
		return PIECE_MOVEMENT;
	}
	
	public void movePieceUp(int x) {
		pieceY += x * PIECE_MOVEMENT;
	}
	
	public void movePieceRight(int x) {
		pieceX= x * PIECE_MOVEMENT;
	}
}
