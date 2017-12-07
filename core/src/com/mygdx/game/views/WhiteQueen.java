package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;

public class WhiteQueen extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteQueen.png"));

	public WhiteQueen(Piece piece) {
		super(piece);
		sprite = texture;		
		// TODO Auto-generated constructor stub
	}

}
