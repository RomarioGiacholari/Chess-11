package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * A class to represent the white knight sprite
 * @author Nathan Livsey
 *
 */
public class WhiteKnight extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("WhiteKnight.png"));
	/**
	 * calls the standard PieceSprite constructor then sets the sprite to be whiteKnight.png
	 * @param piece the knight to be connected with the sprite
	 */
	public WhiteKnight(Piece piece) {
		super(piece);
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
