package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;
/**
 * A class to represent the white queen sprite
 * @author Nathan Livsey
 *
 */
public class WhiteQueen extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteQueen.png"));
	/**
	 * Calls the standard PieceSprite constructor then sets the sprite to whiteQueen.png
	 * @param piece the queen to be connected with the sprite
	 */
	public WhiteQueen(Piece piece) {
		super(piece);
		sprite = texture;		
		setBounds(pieceX *60, pieceY*60, 60, 60);
		// TODO Auto-generated constructor stub
	}
	
	

}
