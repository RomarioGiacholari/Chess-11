package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * a class to represent the blackRook sprite
 * @author Nathan Livsey
 *
 */
public class BlackRook extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("blackRook.png"));
	/**
	 * calls the standard PieceSprite constructor then sets the sprite as blackRook.png
	 * @param piece the rook to be connected with the sprite
	 */
	public BlackRook(Piece piece) {
		super(piece);
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
