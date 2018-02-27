package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * a class to represent the blackKnight sprite
 * @author Nathan Livsey
 *
 */
public class BlackKnight extends PieceSprite{

	
	private Texture texture = new Texture(Gdx.files.internal("blackKnight.png"));
	/**
	 * calls the standard PieceSprite constructor and sets the sprite to blackKnight.png
	 * @param piece the Knight to which the sprite will represent
	 */
	public BlackKnight(Piece piece) {
		super(piece);
		sprite = texture;		
		// TODO Auto-generated constructor stub
	}

}
