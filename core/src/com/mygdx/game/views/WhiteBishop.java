package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * A class to represent the white bishop sprite
 * @author Nathan Livsey
 *
 */
public class WhiteBishop extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteBishop.png"));
	/**
	 * calls the standard PieceSprite constructor then sets the sprite to whiteBishop.png
	 * @param piece the piece to be connected with the sprite
	 */
	public WhiteBishop(Piece piece) {
		super(piece);
		sprite = texture;		
		// TODO Auto-generated constructor stub
	}

}
