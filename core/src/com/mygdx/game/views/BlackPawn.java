package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * a class to represent the blackPawn sprite
 * @author Nathan Livsey
 *
 */
public class BlackPawn extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("blackPawn.png"));
	/**
	 * Calls the standard PieceSprite constructor then sets the sprite to blackPawn.png
	 * @param piece the pawn to be connected with the sprite
	 */
	public BlackPawn(Piece piece) {
		super(piece);
		sprite = texture;	
		}

}
