package com.mygdx.game.views;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.models.chessGame;
import com.mygdx.game.rules.Bishop;
import com.mygdx.game.rules.King;
import com.mygdx.game.rules.Knight;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Piece;
import com.mygdx.game.rules.Position;
import com.mygdx.game.rules.Queen;
import com.mygdx.game.rules.Rook;

public class BoardView extends ScreenAdapter {
	private SpriteBatch batch;
	private chessGame chess;
	private ChessBoard chessBoard = new ChessBoard();
	private static final float MOVE_TIME=0.375f;
	private float timer = MOVE_TIME;
	private int oldX = -1;
	private int oldY = -1;


	@Override
	public void show() {
		chess = new chessGame();
		batch = new SpriteBatch();	
		}

	@Override
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		timer-=delta;
		if(timer<=0) {
			timer=MOVE_TIME;
		

		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int mouseGridX = Integer.parseInt(Integer.toString(Gdx.input.getX() / 60).substring(0, 1));
			int mouseGridY = Integer.parseInt(Integer.toString(Gdx.input.getY() / 60).substring(0, 1));
			
			if(oldX == -1) {
				oldX = mouseGridX;
				oldY = mouseGridY;
			}
			if (mouseGridX <= 7 && mouseGridX >= 0 && mouseGridY <= 7 && mouseGridY >= 0 && (oldX != mouseGridX || oldY != mouseGridY)) {
				//showIfSelected(mouseGridX, mouseGridY);
				System.out.println("selcted square (x, y): " + mouseGridX + ", " + mouseGridY);		
				chess.getBoard().getPieceAtSquare(mouseGridY, mouseGridX, oldY, oldX);
				System.out.println("old square (x, y): "+oldX+ ", "+ oldY );				
				oldX = -1;
				oldY = -1;
			}
			else if(mouseGridX <= 7 && mouseGridX >= 0 && mouseGridY <= 7 && mouseGridY >= 0) {
			}
		}
		}

		showBoard();
		showPawns();
		showKings();
		showKnights();
		showRooks();
		showBishops();
		showQueens();
	

	}

	public void select() {

	}

	/*public void showIfSelected(int row, int col) {

		IsSelectedSprite highlighted = new IsSelectedSprite();
		// queen.movePieceUp(row);
		// queen.movePieceRight(col);
		batch.begin();
		highlighted.draw(batch);
		batch.end();

		// queen.setBounds(queen.pieceX *60, queen.pieceY*60, 60, 60);
	}*/

	public void showBoard() {
		batch.begin();
		chessBoard.draw(batch);
		batch.end();
		
	}

	public void teleportQueen(Piece piece) {
		piece.setPos(new Position(5, 5));
	}

	public void showQueens() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				if (chess.getBoard().getBoard()[row][col] instanceof Queen) {
					if (chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite queen = new WhiteQueen(chess.getBoard().getBoard()[row][col]);
						queen.movePieceUp(row);
						queen.movePieceRight(col);
						batch.begin();
						queen.draw(batch);
						batch.end();
						queen.sprite.dispose();
					} else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite queen = new BlackQueen(chess.getBoard().getBoard()[row][col]);
						queen.movePieceUp(row);
						queen.movePieceRight(col);
						batch.begin();
						queen.draw(batch);
						batch.end();
						queen.sprite.dispose();
					}
				}
			}
		}
		
	}
	

	public void showBishops() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				if (chess.getBoard().getBoard()[row][col] instanceof Bishop) {
					if (chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite bishop = new WhiteBishop(chess.getBoard().getBoard()[row][col]);
						bishop.movePieceUp(row);
						bishop.movePieceRight(col);
						batch.begin();
						bishop.draw(batch);
						batch.end();
						bishop.sprite.dispose();
					} else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite bishop = new BlackBishop(chess.getBoard().getBoard()[row][col]);
						bishop.movePieceUp(row);
						bishop.movePieceRight(col);
						batch.begin();
						bishop.draw(batch);
						batch.end();
						bishop.sprite.dispose();
					}
				}
			}
		}
	}

	public void showRooks() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				if (chess.getBoard().getBoard()[row][col] instanceof Rook) {
					if (chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite rook = new WhiteRook(chess.getBoard().getBoard()[row][col]);
						rook.movePieceUp(row);
						rook.movePieceRight(col);
						batch.begin();
						rook.draw(batch);
						batch.end();
						rook.sprite.dispose();
					} else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite rook = new BlackRook(chess.getBoard().getBoard()[row][col]);
						rook.movePieceUp(row);
						rook.movePieceRight(col);
						batch.begin();
						rook.draw(batch);
						batch.end();
						rook.sprite.dispose();
					}
				}
			}
		}
	}

	public void showKnights() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				if (chess.getBoard().getBoard()[row][col] instanceof Knight) {
					if (chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite knight = new WhiteKnight(chess.getBoard().getBoard()[row][col]);
						knight.movePieceUp(row);
						knight.movePieceRight(col);
						batch.begin();
						knight.draw(batch);
						batch.end();
						knight.sprite.dispose();
					} else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite knight = new BlackKnight(chess.getBoard().getBoard()[row][col]);
						knight.movePieceUp(row);
						knight.movePieceRight(col);
						batch.begin();
						knight.draw(batch);
						batch.end();
						knight.sprite.dispose();
					}
				}
			}
		}
	}

	public void showKings() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				if (chess.getBoard().getBoard()[row][col] instanceof King) {
					if (chess.getBoard().getBoard()[row][col].getTeam() == true) {
						PieceSprite king = new WhiteKing(chess.getBoard().getBoard()[row][col]);
						king.movePieceUp(row);
						king.movePieceRight(col);
						batch.begin();
						king.draw(batch);
						batch.end();
						king.sprite.dispose();
					} else if (chess.getBoard().getBoard()[row][col].getTeam() == false) {
						PieceSprite king = new BlackKing(chess.getBoard().getBoard()[row][col]);
						king.movePieceUp(row);
						king.movePieceRight(col);
						batch.begin();
						king.draw(batch);
						batch.end();
						king.sprite.dispose();
					}
				}
			}
		}
	}

	public void showPawns() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				if (chess.getBoard().getBoard()[row][col] instanceof Pawn
						&& chess.getBoard().getBoard()[row][col].getTeam() == true) {
					PieceSprite pawn = new WhitePawn(chess.getBoard().getBoard()[row][col]);
					pawn.movePieceUp(row);
					pawn.movePieceRight(col);
					batch.begin();
					pawn.draw(batch);
					batch.end();
					pawn.sprite.dispose();
				} else if (chess.getBoard().getBoard()[row][col] instanceof Pawn
						&& chess.getBoard().getBoard()[row][col].getTeam() == false) {
					PieceSprite pawn = new BlackPawn(chess.getBoard().getBoard()[row][col]);
					pawn.movePieceUp(row);
					pawn.movePieceRight(col);
					batch.begin();
					pawn.draw(batch);
					batch.end();
					pawn.sprite.dispose();
				}
			}
		}
	}

}
