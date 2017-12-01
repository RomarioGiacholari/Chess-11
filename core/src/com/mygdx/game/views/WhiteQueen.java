package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WhiteQueen extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteQueen.png"));

	public WhiteQueen() {
		super();
		sprite = texture;	
		// TODO Auto-generated constructor stub
	}

}
