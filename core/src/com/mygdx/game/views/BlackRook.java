package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlackRook extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("blackRook.png"));

	public BlackRook() {
		super();
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
