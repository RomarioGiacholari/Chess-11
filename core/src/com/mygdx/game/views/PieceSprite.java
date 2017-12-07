package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.rules.Piece;

public abstract class PieceSprite extends Actor {

	Texture sprite;
	Piece piece;
	
	private static final int PIECE_MOVEMENT =60;
	
	private int pieceX=0;
	private int pieceY=0;
	
	private int highX = 60;
	private int highY = 60;
	
	public PieceSprite(Piece piece) {
		this.piece = piece;
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
