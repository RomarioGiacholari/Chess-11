package com.mygdx.game.models;

import java.util.ArrayList;


import com.mygdx.game.rules.*;



/**
 * This class represents the board logic for the chess board game.
 * The game board state is setup and updated here. Collision is
 * checked for the pieces as well as legal moves.
 * 
 * {@link com.mygdx.game.models}
 * 
 * @author Farhan Ali
 * @author Nathan Livsey
 *
 */

public class Board {
	
	/**
	 * If the turn is true then it is the white players turn
	 * If the turn is black then it is the black players turn
	 */
	private boolean turn = true;
	
	/**
	 * A 2d array to hold all the Piece objects in their positions on the chess board
	 */
	private Piece[][] board;
	
	/**
	 * The dimensions of the chess board. Set to static as it can then be accessed by 
	 * other classes.
	 */
	public static final int DIMENSIONS = 8;
	
	/**
	 * An ArrayList that will hold all of the pieces on the board's positions.
	 */
	private ArrayList<Position> positions;
	
	/**
	 * A constructor for a Board object, it initialises the board array to be 8*8, the 
	 * dimensions of a normal chess board.
	 */
	public Board() {
		
		board = new Piece[DIMENSIONS][DIMENSIONS];
		positions = new ArrayList<Position>();
		
	}
	
	/**
	 * A method for setting up the pieces on the chess board. Each Piece object is set to 
	 * its default positions on a chess board within the array.
	 */
	public void setUp() {
		board [0][0] = new Rook(0,0,true);
		board [0][1] = new Knight(0,1,true);
		board [0][2] = new Bishop(0,2,true);
		board [0][3] = new Queen(0,3,true);
		board [0][4] = new King(0,4,true);
		board [0][5] = new Bishop(0,5,true);
		board [0][6] = new Knight(0,6,true);
		board [0][7] = new Rook(0,7,true);
		board [1][0] = new Pawn(1,0,true);
		board [1][1] = new Pawn(1,1,true);
		board [1][2] = new Pawn(1,2,true);
		board [1][3] = new Pawn(1,3,true);
		board [1][4] = new Pawn(1,4,true);
		board [1][5] = new Pawn(1,5,true);
		board [1][6] = new Pawn(1,6,true);
		board [1][7] = new Pawn(1,7,true);
		
		board [7][0] = new Rook(7,0,false);
		board [7][1] = new Knight(7,1,false);
		board [7][2] = new Bishop(7,2,false);
		board [7][3] = new Queen(7,3,false);
		board [7][4] = new King(7,4,false);
		board [7][5] = new Bishop(7,5,false);
		board [7][6] = new Knight(7,6,false);
		board [7][7] = new Rook(7,7,false);
		board [6][0] = new Pawn(6,0,false);
		board [6][1] = new Pawn(6,1,false);
		board [6][2] = new Pawn(6,2,false);
		board [6][3] = new Pawn(6,3,false);
		board [6][4] = new Pawn(6,4,false);
		board [6][5] = new Pawn(6,5,false);
		board [6][6] = new Pawn(6,6,false);
		board [6][7] = new Pawn(6,7,false);
	}
	
	/**
	 * A method that checks to see if a pawn can be promoted. If the pawn can be promoted
	 * then the designated pawn is then changed into a Queen piece.
	 */
	public void promoteCheck() {
		
		for(int i = 0; i <= 7; i++) {
			
			if (board[0][i] instanceof Pawn && board[0][i].getTeam() == false) {
				
				board[0][i] = null;
				
				board[0][i] = new Queen(0, i, false);
			
			}
			
			if (board[7][i] instanceof Pawn && board[7][i].getTeam() == true) {
				
				board[7][i] = null;
				
				board[7][i] = new Queen(7,i,true);
			
			}
		}
		
	}
	
	/**
	 * Moves the underlying pieces and switches the turn counter to the other player if the move is 
	 * successful.
	 * 
	 * @param x - the x coordinate of the target position
	 * @param y - the y coordinate of the target position
	 * @param oldX - the x coordinate of the original piece
	 * @param oldY - the y coordinate of the original piece
	 */
	public void getPieceAtSquare(int x, int y, int oldX, int oldY){
		switch (x) {
			case 0:
				x = 7;
				break;
			case 1:
				x = 6;
				break;
			case 2:
				x = 5;
				break;
			case 3:
				x = 4;
				break;
			case 4:
				x = 3;
				break;
			case 5:
				x = 2;
				break;
			case 6:
				x = 1;
				break;
			case 7:
				x = 0;
				break;
				
		}
		
		switch (oldX) {
			case 0:
				oldX = 7;
				break;
			case 1:
				oldX = 6;
				break;
			case 2:
				oldX = 5;
				break;
			case 3:
				oldX = 4;
				break;
			case 4:
				oldX = 3;
				break;
			case 5:
				oldX = 2;
				break;
			case 6:
				oldX = 1;
				break;
			case 7:
				oldX = 0;
				break;
		}
		
		Piece piece = getSquare(oldX, oldY);
		
		if(piece != null) {
			System.out.println(piece.printPieceType());
			
			if(piece.getTeam() == turn) {
				
				if (checkCheck(turn)) {
					System.out.println("CHECK");
				}
				
				if (checkMove(piece, x, y)) {

					setPiece(piece, new Position(x, y));
					turn = !turn;
					
				}
			} 
			
		} else System.out.println("This square is empty.");
	}
	
	
	/**
	 * Sets the new location to the piece
	 * Then sets the piece's original location to null
	 * then set the position to the new one
	 * @param piece
	 * @param end
	 */
	public void setPiece(Piece piece, Position end) {
		board[end.getX()][end.getY()] = piece;
		board[piece.getPos().getX()][piece.getPos().getY()] = null;
		piece.setPos(end);
	}
	
	/**
	 * A method to move a piece to a new location. It takes a piece object and a new location and, 
	 * if the pieces move function returns true, will move the piece to its new location
	 * @param piece the Piece object to moved
	 * @param row the x coordinate of the new location
	 * @param col the y coordinate of the new location
	 */
	public void move(Piece piece, int row, int col)  {
		if(checkMove(piece, row, col)) setPiece(piece, new Position(row, col));
	}
	
	/**
	 * A method that returns the contents of a given chessboard square
	 * @param position the chess position representing the target location
	 */
	public Piece getSquare (Position position) {
		return board[position.getX()][position.getY()];
	}
	
	/**
	 * A method to return a specific piece for a given location on the board
	 * @param row the x coordinate of the piece to be returned
	 * @param col the y coordinate of the piece to be returned
	 * @return the piece requested
	 */
	public Piece getSquare(int row, int col) { return board[row][col]; }
	
	/**
	 * A method to return the current board.
	 * @return the current state of the board
	 */
	public Piece [][] getBoard() { return board; }
	
	
	public ArrayList<Position> allPositions () {
		
		positions.clear();
		
		for (int i = 0; i < DIMENSIONS; i++) {
			
			for (int n = 0; n < DIMENSIONS; n++) {
				
				if (getSquare(i, n) instanceof Piece) {
					
					positions.add(getBoard()[i][n].getPos());
					
				}
			}
		}
		
		return positions;
		
	}
	
	private ArrayList<Position> createPath(Piece piece, Position newPosition) {
		
		ArrayList<Position> path = new ArrayList<Position>();
		
		piece.hashMove();
		
			
		for (String move : piece.hashMove().keySet()) {
			
			if (piece.hashMove().get(move).contains(newPosition)) {
				
				path = piece.hashMove().get(move);
				
				int location = path.indexOf(newPosition);
				
				for (int i = path.size() - 1; i > location; i--) path.remove(i);
			}
		}
		
		return path;
	}
	
	/**
	 * This method checks for collision for a piece with other pieces.
	 * @param piece - the piece that is to be moved
	 * @param x - the x coordinate of the new location
	 * @param y - the y coordinate of the new location
	 * @return - true if there is collision or false if there is no collision
	 */
	public boolean collision(Piece piece, int x, int y) {
		Position newPosition = new Position(x, y);
		// The last element in the ArrayList is the new position
		ArrayList<Position> path = createPath(piece, newPosition);
		
		for (int i = 0; i < path.size() - 1; i++) {
			
			if (getSquare(path.get(i)) != null) {
				return true;
			}
			
		}
		
		if (getSquare(newPosition) != null && getSquare(newPosition).getTeam() == piece.getTeam()) {
			return true;
		}
		
		if (getSquare(newPosition) != null && piece instanceof Pawn) {
			if(y == piece.getPos().getY()) {
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * This checks if a move is valid. Taking collision into account.
	 * @param piece - the selected piece
	 * @param x - the x coordinate of the new position for the selected piece
	 * @param y - the y coordinate of the new position for the selected piece
	 * @return - true is the move is possible & false if the move is not possible
	 */
	public boolean checkMove(Piece piece, int x, int y) {
		
		Position newLocation = new Position(x, y);
		
		if (piece.getPos().equals(newLocation)) return false;
		
		if (piece instanceof Pawn) {
			
			Position left = ((Pawn) piece).getLeft();
			Position right = ((Pawn) piece).getRight();
			
			try {
				if (getSquare(left) != null && getSquare(left).getTeam() != piece.getTeam()) {
					((Pawn) piece).takeLeft(true);
				}
				else ((Pawn) piece).takeLeft(false);
				
				if (getSquare(right) != null && getSquare(right).getTeam() != piece.getTeam()) {
					((Pawn) piece).takeRight(true);
				}
				else ((Pawn) piece).takeRight(false);
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		
		if (piece.move(x, y)) {
			
			if (collision(piece, x, y)) return false;
			
			else {
				
				if (piece instanceof Pawn) {
					((Pawn) piece).hasMoved();
				}
				
				return true;
			}
		}
		
		return false;
		
	}
	
	
	public boolean getTurn() {
		return turn;
	}
	
	public boolean checkCheck(boolean teamType) {
		
		Position kingPosition = null;
		
		ArrayList<Position> enemyPositions = new ArrayList<Position>();
		
		for (Position position : allPositions()) {
			
			if (getSquare(position) instanceof King && getSquare(position).getTeam() == teamType) {
				
				kingPosition = position;
				
			}
			
			if (getSquare(position).getTeam() != teamType) enemyPositions.add(position);
		
		}
		
		if (kingPosition != null) {
			
			for (Position enemyPosition : enemyPositions) {
				
				if (checkMove(getSquare(enemyPosition), kingPosition.getX(), kingPosition.getY())) {
					
					return true;
					
				}
				
			}
			
		}
		
//		Position kingPos = null;
//		for (int i = 0; i < getBoard().length; i++) {
//			for (int n = 0; n < getBoard().length; n++) {
//				if(getSquare(i, n) instanceof Piece && getSquare(i,n) .getTeam() == teamType && ( getSquare(i, n) instanceof King)) {
//					kingPos = new Position(i,n);
//				}
//			}
//		}
//		for (int i = 0; i < getBoard().length; i++) {
//			for (int n = 0; n < getBoard().length; n++) {
//				if (getSquare(i, n) instanceof Piece && getSquare(i,n) .getTeam() == !teamType) {
//					if(getSquare(i,n) instanceof Pawn) {
//					Pawn pawn = (Pawn) getSquare(i,n);
//					pawn.takeLeft(true);
//					pawn.takeRight(true);
//					HashMap<String, ArrayList<Position>> testing = pawn.hashMove();
//					for(String key: testing.keySet()) {
//						ArrayList<Position> pos = testing.get(key);
//						for(Position pos2:pos) {
//					
//						if(pos2.equals(kingPos)) {
//							if(collision(pawn,pos2.getX(),pos2.getY())) {
//							
//							}
//							else {
//								return true;
//							}
//							
//							
//							}
//						}
//					}
//					}
//					else {
//						HashMap<String, ArrayList<Position>> testing = getSquare(i,n).hashMove();
//						for(String key: testing.keySet()) {
//							ArrayList<Position> pos = testing.get(key);
//							for(Position pos2:pos) {
//						
//							if(pos2.equals(kingPos)) {
//								if(collision(getSquare(i,n),pos2.getX(),pos2.getY())) {
//								
//								}
//								else {
//									return true;
//								}
//								
//								
//								}
//							}
//						}
//					}
//					
//				}
//			}
//		}
		return false;
	}
	
	public void AIMove(int oldX, int oldY, int x, int y) {
		Piece piece = getSquare(oldX, oldY);
		
			if(piece != null) {
				
				System.out.println(piece.printPieceType());
			
				if(piece.getTeam() == turn) {
					if (checkMove(piece, x, y)) {

						setPiece(piece, new Position(x, y));
						turn = !turn;
					
				}
			}
		}
	}
	
	public boolean checkMate(boolean team) {
		if(checkCheck(team)) {
			//check all the squares around king using checkCheck  
		}
	}
}	
	