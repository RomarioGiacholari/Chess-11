package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.rules.Piece;

public class BlackPawn extends PieceSprite {

	private Texture texture = new Texture(Gdx.files.internal("blackPawn.png"));
	
	public BlackPawn(Piece piece) {
		super(piece);
		sprite = texture;	
		}

}
