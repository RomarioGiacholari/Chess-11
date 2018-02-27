package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * A class representing the Black Bishop sprite
 * @author Student
 *
 */
public class BlackBishop extends PieceSprite {
	/**
	 * the sprite allocated to the BlackBishop
	 */
	private Texture texture = new Texture(Gdx.files.internal("blackBishop.png"));
	/**
	 * calls the standard constructor for the PieceSprite and sets the texture value to blackBishop sprite
	 * @param piece the bishop to be connected to this sprite
	 */
	public BlackBishop(Piece piece) {
		super(piece);
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
