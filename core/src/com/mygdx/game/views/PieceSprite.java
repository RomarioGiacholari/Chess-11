package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Texture; 
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.rules.Piece;
/**A class to model the generic behavoir for all the sprites of chess pieces that will appear on screen
 * 
 * @author Nathan Livsey
 *
 */
public abstract class PieceSprite extends Actor {
	/**
	 * A variable to hold the sprite of the Piece. is defined in child classes
	 */
	Texture sprite;
	/**
	 * A variable to connect the sprite to the piece that it represents
	 */
	Piece piece;
	/**
	 * A variable to represent how far each piece should move to move up one 
	 */
	private static final int PIECE_MOVEMENT =60;
	/**
	 * a variable representing what X position on the board the sprite should occupy
	 */
	protected int pieceX=0;
	/**
	 * a variable representing what Y position on the board the piece should occupy
	 */
	protected int pieceY=0;
	

	
	/**
	 * The main constructor for the PieceSprite class
	 * @param piece the piece within the rule model that the sprite will represent
	 */
	public PieceSprite(Piece piece) {
		this.piece = piece;
	}
	/**
	 * The method that will draw the sprite on screen
	 * @param batch the batch in which the sprite will be drawn
	 */
	public void draw(Batch batch) {
		batch.draw(sprite,getPieceX(),getPieceY());
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
}
