package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.models.chessGame;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Position;
import com.mygdx.game.views.*;

public class BoardView extends ScreenAdapter{
	private SpriteBatch batch;
	private WhitePawn white;
	private chessGame chess;
	
	@Override
    public void show()
    {
		chess = new chessGame();
		batch = new SpriteBatch();
		chess.getBoard().move(chess.getBoard().getSquare(new Position(1,1)), 2, 1);

		
    }
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.5f,0.5f,0.5f,1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		showPawns();
	}
	
	public void showKings() {
		
	}
	
	public void showPawns() {
		for (int row =0; row< chess.getBoard().getBoard().length; row++) {
			for(int col =0; col<chess.getBoard().getBoard().length; col++) {
				if(chess.getBoard().getBoard()[row][col] instanceof Pawn && chess.getBoard().getBoard()[row][col].getTeam() == true) {
					PieceSprite pawn = new WhitePawn();
					pawn.movePieceUp(row);
					pawn.movePieceRight(col);
					batch.begin();
					pawn.draw(batch);
					batch.end();
				}
				else  if (chess.getBoard().getBoard()[row][col] instanceof Pawn && chess.getBoard().getBoard()[row][col].getTeam() == false){
					PieceSprite pawn = new BlackPawn();
					pawn.movePieceUp(row);
					pawn.movePieceRight(col);
					batch.begin();
					pawn.draw(batch);
					batch.end();
				}
			}
		}
	}

}
