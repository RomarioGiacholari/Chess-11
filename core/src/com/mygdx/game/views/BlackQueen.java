package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;

public class BlackQueen extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("blackQueen.png"));

	public BlackQueen(Piece piece) {
		super(piece);
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
