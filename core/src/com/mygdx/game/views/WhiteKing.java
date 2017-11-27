package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class WhiteKing extends PieceSprite {

	
	private Texture texture = new Texture(Gdx.files.internal("whiteKing.png"));
	public WhiteKing() {
		super();
		sprite = texture;	
		}

}
