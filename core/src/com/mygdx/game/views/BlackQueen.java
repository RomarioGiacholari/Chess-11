package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class BlackQueen extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("blackQueen.png"));

	public BlackQueen() {
		super();
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
