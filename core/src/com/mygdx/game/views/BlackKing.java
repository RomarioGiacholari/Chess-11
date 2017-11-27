package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlackKing extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("blackKing.png"));
	public BlackKing() {
		super();
		sprite = texture;	
	}

}
