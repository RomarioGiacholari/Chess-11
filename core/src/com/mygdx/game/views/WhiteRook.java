package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * a class to represent the white rook sprite
 * @author Nathan Livsey
 *
 */
public class WhiteRook extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteRook.png"));
	/**
	 * Calls the standard PieceSprite constructor then sets the whiteRook.png as sprite
	 * @param piece the rook to be connected with the sprite
	 */
	public WhiteRook(Piece piece) {
		super(piece);
		sprite = texture;		
		// TODO Auto-generated constructor stub
	}

}
