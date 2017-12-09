package com.mygdx.game.views;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.mygdx.game.models.chessGame;
import com.mygdx.game.rules.Bishop;
import com.mygdx.game.rules.King;
import com.mygdx.game.rules.Knight;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Position;
import com.mygdx.game.rules.Queen;
import com.mygdx.game.rules.Rook;
import com.mygdx.game.views.*;

public class BoardView extends ScreenAdapter{
	private SpriteBatch batch;
	private WhitePawn white;
	private chessGame chess;
	

	OrthographicCamera camera;
	ShapeRenderer shapeRenderer;
	private Sprite sprite;
	
	public void show()
    {
		chess = new chessGame();
		batch = new SpriteBatch();
		
    }
	
	

	public void create () {
	    shapeRenderer = new ShapeRenderer();

	    camera = new OrthographicCamera(500, 500); //FILL THE VALUES HERE
	    sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));  //FILL THE VALUES HERE

	     sprite.setBounds(200, 200, 64, 64);
	}



	public void render () {

	     Gdx.gl.glClearColor(1, 1, 1, 1);
	     Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	     Gdx.gl.glEnable(GL20.GL_BLEND);
	     Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
	     Gdx.gl.glDisable(GL20.GL_BLEND);

	      batch.setProjectionMatrix(camera.combined);

	      batch.begin();  
	      sprite.draw(batch);  
	      batch.end();

	      shapeRenderer.setColor(Color.RED);
	      shapeRenderer.begin(ShapeType.Filled);
	      shapeRenderer.circle(100, 100, 32);
	      shapeRenderer.end();
	};  
	
	
	public void showQueens() {
		for (int row =0; row< chess.getBoard().getBoard().length; row++) {
			for(int col =0; col<chess.getBoard().getBoard().length; col++) {
				if(chess.getBoard().getBoard()[row][col] instanceof Queen) {
					if(chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite queen = new WhiteQueen();
						queen.movePieceUp(row);
						queen.movePieceRight(col);
						batch.begin();
						queen.draw(batch);
						batch.end();
					}
					else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite queen = new BlackQueen();
						queen.movePieceUp(row);
						queen.movePieceRight(col);
						batch.begin();
						queen.draw(batch);
						batch.end();
					}
				}
			}
		}	
	}
	
	public void showBishops() {
		for (int row =0; row< chess.getBoard().getBoard().length; row++) {
			for(int col =0; col<chess.getBoard().getBoard().length; col++) {
				if(chess.getBoard().getBoard()[row][col] instanceof Bishop) {
					if(chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite bishop = new WhiteBishop();
						bishop.movePieceUp(row);
						bishop.movePieceRight(col);
						batch.begin();
						bishop.draw(batch);
						batch.end();
					}
					else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite bishop = new BlackBishop();
						bishop.movePieceUp(row);
						bishop.movePieceRight(col);
						batch.begin();
						bishop.draw(batch);
						batch.end();
					}
				}
			}
		}	
	}
	
	public void showRooks() {
		for (int row =0; row< chess.getBoard().getBoard().length; row++) {
			for(int col =0; col<chess.getBoard().getBoard().length; col++) {
				if(chess.getBoard().getBoard()[row][col] instanceof Rook) {
					if(chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite rook = new WhiteRook();
						rook.movePieceUp(row);
						rook.movePieceRight(col);
						batch.begin();
						rook.draw(batch);
						batch.end();
					}
					else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite rook = new BlackRook();
						rook.movePieceUp(row);
						rook.movePieceRight(col);
						batch.begin();
						rook.draw(batch);
						batch.end();
					}
				}
			}
		}	
	}
	
	public void showKnights() {
		for (int row =0; row< chess.getBoard().getBoard().length; row++) {
			for(int col =0; col<chess.getBoard().getBoard().length; col++) {
				if(chess.getBoard().getBoard()[row][col] instanceof Knight) {
					if(chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite knight = new WhiteKnight();
						knight.movePieceUp(row);
						knight.movePieceRight(col);
						batch.begin();
						knight.draw(batch);
						batch.end();
					}
					else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite knight = new BlackKnight();
						knight.movePieceUp(row);
						knight.movePieceRight(col);
						batch.begin();
						knight.draw(batch);
						batch.end();
					}
				}
			}
		}	
	}
	
	public void showKings() {
		for (int row =0; row< chess.getBoard().getBoard().length; row++) {
			for(int col =0; col<chess.getBoard().getBoard().length; col++) {
				if(chess.getBoard().getBoard()[row][col] instanceof King) {
					if(chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite king = new WhiteKing();
						king.movePieceUp(row);
						king.movePieceRight(col);
						batch.begin();
						king.draw(batch);
						batch.end();
					}
					else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite king = new BlackKing();
						king.movePieceUp(row);
						king.movePieceRight(col);
						batch.begin();
						king.draw(batch);
						batch.end();
					}
				}
			}
		}
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
