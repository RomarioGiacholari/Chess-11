package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.*;

public class WhitePawn extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("WhitePawn.png"));

	public WhitePawn() {
		super();
		sprite = texture;
	}
}
