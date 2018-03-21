package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * a class to represent the blackQueen sprite
 * @author Nathan Livsey
 *
 */
public class BlackQueen extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("blackQueen.png"));
	/**
	 * calls the standard PieceSprite constructor and sets the sprite to blackQueen.png
	 * @param piece the queen to be connected with the sprite
	 */
	public BlackQueen(Piece piece) {
		super(piece);
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
