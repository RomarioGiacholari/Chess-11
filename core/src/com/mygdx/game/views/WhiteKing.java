package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * a class to represent the white king sprite
 * @author Nathan Livsey
 *
 */
public class WhiteKing extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteKing.png"));
	/**
	 * calls the standard PieceSprite constructor then sets the sprite to whiteKing.png
	 * @param piece the piece to be connected with teh sprite
	 */
	public WhiteKing (Piece piece) {
		super(piece);
		sprite = texture;		
		}

}
