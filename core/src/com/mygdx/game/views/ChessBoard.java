package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.models.Board;
/**
 * a class to represent the chessboard sprite
 * @author Nathan Livsey
 *
 */
public class ChessBoard extends Actor{

	Texture texture = new Texture(Gdx.files.internal("board.jpg"));
	Board board = new Board();
	/**
	 * the chessboard constructor
	 */
	public ChessBoard() {
		board.setUp();
	}
	/**
	 * draws the chessboard sprite at position 0,0
	 * @param batch the batch in which sprite will be drawn
	 */
	public void draw(Batch batch) {
		batch.draw(texture, 0, 0);
	}
	
	

}
