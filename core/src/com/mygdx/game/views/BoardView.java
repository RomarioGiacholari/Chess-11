package com.mygdx.game.views;



import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.ai.engine.ChessAI;
import com.mygdx.game.models.chessGame;
import com.mygdx.game.rules.Bishop;
import com.mygdx.game.rules.King;
import com.mygdx.game.rules.Knight;
import com.mygdx.game.rules.Pawn;
import com.mygdx.game.rules.Position;
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
	private Texture indicator;
	private Texture selected;
	private static float MOVE_TIME = 0.275f;
	private float timer = MOVE_TIME;
	private int oldX = -1;
	private int oldY = -1;
	private boolean isSelected;
	private boolean AIEnabled = true;
	private boolean singleteam = true;
	private ChessAI AI;

	public BoardView(boolean ai, boolean team) {
		AIEnabled = ai;
		singleteam = team;
	}
	
	public BoardView() {
		AIEnabled = false;
		singleteam = false;
	}

	@Override
	/**
	 * acts as the constructor and initialises objects
	 */
	public void show() {
		chess = new chessGame();
		batch = new SpriteBatch();	
		AI = new ChessAI(!singleteam);
		indicator = new Texture (Gdx.files.internal("indicator.png"));
		selected = new Texture (Gdx.files.internal("indicator3.png"));
	}

	@Override
	/**
	 * draws the sprites each turn cycle and checks for user input 
	 */
	public void render(float delta) {
		
		Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 1f);
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		timer -= delta;
		
		if (timer <= 0) {
			
			timer=MOVE_TIME;
		
			if(AIEnabled) {
					if(chess.getBoard().getTurn() == singleteam) inputs();
					
					else {
						
						ArrayList<Position> moveList = AI.selectAMove(chess.getBoard());
						int moveX = moveList.get(0).getX();
						int moveY = moveList.get(0).getY();
						
						int oldX = moveList.get(1).getX();
						int oldY = moveList.get(1).getY();
						
						chess.getBoard().AIMove(moveX, moveY, oldX, oldY);
					}
				}
			
			else if (!AIEnabled) inputs();
		
		}
		chess.getBoard().promoteCheck();
		switchIndicator();
		showBoard();
		/*showPawns();
		showKings();
		showKnights();
		showRooks();
		showBishops();
		showQueens();*/
		showPiece();
		
		batch.begin();
		
		batch.draw(indicator,480,240);
		
		if(isSelected) batch.draw(selected,480,300);
		

		batch.end();

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
	
	private void switchIndicator() {
		if(chess.getBoard().getTurn()) {
			indicator.dispose();
			indicator  = new Texture (Gdx.files.internal("indicator.png"));
		}
		else {
			indicator.dispose();
			indicator  = new Texture (Gdx.files.internal("indicator2.png"));
		}
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
	
	
	public void setTimers(float x) {
		MOVE_TIME = x;
		timer = x;
	}
	
	private void inputs() {
		if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
			int mouseGridX = Integer.parseInt(Integer.toString(Gdx.input.getX() / 60).substring(0, 1));
			int mouseGridY = Integer.parseInt(Integer.toString(Gdx.input.getY() / 60).substring(0, 1));
			
			if(oldX == -1) {
				oldX = mouseGridX;
				oldY = mouseGridY;
				isSelected = true;
			}
			if (mouseGridX <= 7 && mouseGridX >= 0 && mouseGridY <= 7 && mouseGridY >= 0 && (oldX != mouseGridX || oldY != mouseGridY)) {
				//showIfSelected(mouseGridX, mouseGridY);
				System.out.println("selcted square (x, y): " + mouseGridX + ", " + mouseGridY);		
				chess.getBoard().getPieceAtSquare(mouseGridY, mouseGridX, oldY, oldX);
				System.out.println("old square (x, y): "+oldX+ ", "+ oldY );				
				oldX = -1;
				oldY = -1;
				isSelected = false;
			}
			else if(mouseGridX <= 7 && mouseGridX >= 0 && mouseGridY <= 7 && mouseGridY >= 0) {
			}
			System.out.println(chess.getBoard().checkCheck(true));
			System.out.println(chess.getBoard().checkCheck(false));
		}
		
	}
	
	public void setTeam(boolean team) {
		singleteam = team;
	}

}
