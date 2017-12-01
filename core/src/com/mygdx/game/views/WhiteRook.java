package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WhiteRook extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteRook.png"));

	public WhiteRook() {
		super();
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
