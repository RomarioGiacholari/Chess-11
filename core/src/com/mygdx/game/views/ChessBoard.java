package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.models.Board;

public class ChessBoard extends Actor{

	Texture texture = new Texture(Gdx.files.internal("board.jpg"));
	Board board = new Board();
	
	public ChessBoard() {
		board.setUp();
	}
	
	public void draw(Batch batch) {
		batch.draw(texture, 0, 0);
	}
	
	

}
