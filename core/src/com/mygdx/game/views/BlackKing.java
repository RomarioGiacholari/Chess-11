package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * A class representing the BlackKing sprite
 * @author Nathan Livsey
 *
 */
public class BlackKing extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("blackKing.png"));
	/**
	 * calls the standard PieceSprite constructor and sets the sprite value to that of the blackKing.png
	 * @param piece
	 */
	public BlackKing(Piece piece) {
		super(piece);
		sprite = texture;	
	}

}
