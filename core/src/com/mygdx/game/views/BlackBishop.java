package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlackBishop extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("blackBishop.png"));

	public BlackBishop() {
		super();
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
