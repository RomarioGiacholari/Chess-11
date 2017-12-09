package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;

public class BlackKing extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("blackKing.png"));
	public BlackKing(Piece piece) {
		super(piece);
		sprite = texture;	
	}

}
