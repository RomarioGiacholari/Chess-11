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
import com.mygdx.game.rules.Queen;
import com.mygdx.game.rules.Rook;
/**
 * A class to manage the sprites and input logic of the main chess game
 * @author Nathan Livsey
 *
 */
public class BoardView extends ScreenAdapter {
	private SpriteBatch batch;
	private chessGame chess;
	private ChessBoard chessBoard = new ChessBoard();
	private static final float MOVE_TIME=0.375f;
	private float timer = MOVE_TIME;
	private int oldX = -1;
	private int oldY = -1;


	@Override
	/**
	 * acts as the constructor and initialises objects
	 */
	public void show() {
		chess = new chessGame();
		batch = new SpriteBatch();	
		}

	@Override
	/**
	 * draws the sprites each turn cycle and checks for user input 
	 */
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
		chess.getBoard().promoteCheck();
		showBoard();
		/*showPawns();
		showKings();
		showKnights();
		showRooks();
		showBishops();
		showQueens();*/
		showPiece();
	

	}

	public void select() {

	}


	private void showBoard() {
		batch.begin();
		chessBoard.draw(batch);
		batch.end();
		
	}

	private PieceSprite assignSprite(int x, int y) {
		if(chess.getBoard().getBoard()[x][y] instanceof Queen) {
			if(chess.getBoard().getBoard()[x][y].getTeam() == true) {
				return new WhiteQueen(chess.getBoard().getBoard()[x][y]);
			}
			else {
				return new BlackQueen(chess.getBoard().getBoard()[x][y]);
			}
		}
		else if(chess.getBoard().getBoard()[x][y] instanceof King) {
			if(chess.getBoard().getBoard()[x][y].getTeam() == true) {
				return new WhiteKing(chess.getBoard().getBoard()[x][y]);
			}
			else {
				return new BlackKing(chess.getBoard().getBoard()[x][y]);
			}
		}
		else if(chess.getBoard().getBoard()[x][y] instanceof Rook) {
			if(chess.getBoard().getBoard()[x][y].getTeam() == true) {
				return new WhiteRook(chess.getBoard().getBoard()[x][y]);
			}
			else {
				return new BlackRook(chess.getBoard().getBoard()[x][y]);
			}
		}
		else if(chess.getBoard().getBoard()[x][y] instanceof Bishop) {
			if(chess.getBoard().getBoard()[x][y].getTeam() == true) {
				return new WhiteBishop(chess.getBoard().getBoard()[x][y]);
			}
			else {
				return new BlackBishop(chess.getBoard().getBoard()[x][y]);
			}
		}
		else if(chess.getBoard().getBoard()[x][y] instanceof Knight) {
			if(chess.getBoard().getBoard()[x][y].getTeam() == true) {
				return new WhiteKnight(chess.getBoard().getBoard()[x][y]);
			}
			else {
				return new BlackKnight(chess.getBoard().getBoard()[x][y]);
			}
		}
		else if(chess.getBoard().getBoard()[x][y] instanceof Pawn) {
			if(chess.getBoard().getBoard()[x][y].getTeam() == true) {
				return new WhitePawn(chess.getBoard().getBoard()[x][y]);
			}
			else {
				return new BlackPawn(chess.getBoard().getBoard()[x][y]);
			}
		}
		return null;
	}
	
	private void showPiece() {
		for (int row = 0; row < chess.getBoard().getBoard().length; row++) {
			for (int col = 0; col < chess.getBoard().getBoard().length; col++) {
				PieceSprite piece = assignSprite(row,col);
				if(piece != null) {
				piece.movePieceUp(row);
				piece.movePieceRight(col);
				batch.begin();
				piece.draw(batch);
				batch.end();
				piece.sprite.dispose();
				}
			}
		}
	}

	/*public void showQueens() {
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
	}*/

}
