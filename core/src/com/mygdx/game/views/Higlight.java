package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Higlight extends Actor {
	Texture sprite;
	private static final int PIECE_MOVEMENT =60;
	protected int pieceX=0;
	protected int pieceY=0;

	public Higlight()   {
		sprite = new Texture(Gdx.files.internal("transparentBlue60x60.png"));
	}
	public void draw(Batch batch) {
		batch.begin();
		batch.draw(sprite,getPieceX(),getPieceY());
		batch.end();
	}
	/**
	 * returns an int representing the X position on the board
	 * @return the pieceX variable
	 */
	public int getPieceX() {
		return pieceX;
	}
	/**
	 * returns an int representing the Y position on the board
	 * @return the pieceY variable
	 */
	public int getPieceY() {
		return pieceY;
	}
	/**
	 * Acceses the PIECE_MOVEMENT cosntant
	 * @return the PIECE_MOVEMENT constants value
	 */
	public int getMovement() {
		return PIECE_MOVEMENT;
	}
	/**
	 * moves the sprite up the requested number of squares
	 * @param x the number of squares to be moved up
	 */
	public void movePieceUp(int x) {
		pieceY += x * PIECE_MOVEMENT;
	}
	/**
	 * moves the sprite right the requested number of squares
	 * @param x the number of squares to be moved right
	 */
	public void movePieceRight(int x) {
		pieceX= x * PIECE_MOVEMENT;
	}
	public void reset() {
		pieceX = 0;
		pieceY = 0;
	}
}

