package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.*;
/**
 * a class to represent the white pawn sprite
 * @author Nathan Livsey
 *
 */
public class WhitePawn extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("WhitePawn.png"));
	/**
	 * calls the standard PieceSprite constructor then sets the sprite to be WhitePawn.png
	 * @param piece the pawn to be connected with the sprite
	 */
	public WhitePawn(Piece piece) {
		super(piece);
		sprite = texture;	
	}
}
