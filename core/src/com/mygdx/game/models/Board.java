package com.mygdx.game.models;

import com.mygdx.game.models.*;
import com.mygdx.game.rules.*;



/**
 * A class to represent the board of a game of chess
 * @author Student
 *
 */
public class Board {
	/**
	 * A 2d array to hold all the Piece objects in their positions on the chess board
	 */
	private Piece[][] board;
	
	/**
	 * A constructor for a Board object, it initialises the board array to be 8*8, the dimensions of a normal chess board
	 */
	public Board() {
		board = new Piece[8][8];
	}
	/**
	 * A method for setting up the pieces on the chess board
	 * Each Piece object is set to its defualt positions on a chess board within the array
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
	
	public Piece getSquare (Position position) {
		return board[position.getX()][position.getY()];
	}
	
	public Piece [][] getBoard(){
		return board;
	}
	public boolean checkRight(Piece piece,Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX(),pointer.getY()+1);
			if (getSquare(pointer) != null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkLeft(Piece piece, Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX(),pointer.getY()-1);
			if (getSquare(pointer) != null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkUp(Piece piece, Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX()+1,pointer.getY());
			if (getSquare(pointer) != null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkDown(Piece piece,Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX()-1,pointer.getY());
			if (getSquare(pointer) != null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
				}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkupRight(Piece piece, Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX()+1,pointer.getY()+1);
			if(getSquare(pointer)!= null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
			}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkUpLeft(Piece piece, Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX()+1,pointer.getY()-1);
			if(getSquare(pointer)!= null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
			}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkDownLeft(Piece piece,Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX()-1,pointer.getY()-1);
			if(getSquare(pointer)!= null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
			}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean checkDownRight(Piece piece, Position end) {
		Position pointer = piece.getPos();
		while(pointer.equals(end) == false) {
			pointer = new Position(pointer.getX()-1,pointer.getY()+1);
			if(getSquare(pointer)!= null) {
				if(getSquare(pointer).getTeam() != piece.getTeam() && pointer.equals(end)) {
					return true;
			}
				else {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * A method to move a piece to a new location. It takes a piece object and a new location and, 
	 * if the pieces move function returns true, will move the piece to its new location
	 * @param piece the Piece object to moved
	 * @param row the x coordinate of the new location
	 * @param col the y coordinate of the new location
	 */
	public void move( Piece piece, int row, int col) throws InvalidMoveExcpeption {
		Position end = new Position(row,col);
		
		if (piece instanceof Knight) {
			if (getSquare(end) != null) {
				if (getSquare(end).getTeam() != piece.getTeam()) {
					board[end.getX()][end.getY()] = piece;
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					piece.setPos(end);
				}
			}
			else {
				board[end.getX()][end.getY()] = piece;
				board[piece.getPos().getX()][piece.getPos().getY()] = null;
				piece.setPos(end);
			}
		}
		else {
			if(end.getX() == piece.getPos().getX()) {
				if(end.getY()>piece.getPos().getY()) {
					if(checkRight(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
				else {
					if(checkLeft(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
			}
			else if (end.getY() == piece.getPos().getY()) {
				if (end.getX()>piece.getPos().getX()) {
					if(checkUp(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
				else if (end.getX()<piece.getPos().getX()) {
					if (checkDown(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
			}
			else if (end.getX()>piece.getPos().getX()) {
				if (end.getY()>piece.getPos().getY()) {
					if (checkupRight(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
				else if (end.getY()<piece.getPos().getY()) {
					if(checkUpLeft(piece,end)) 
					{
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
			}
			else if(end.getX()< piece.getPos().getX()) {
				if (end.getY() > piece.getPos().getY()) {
					if (checkDownRight(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
				else if (end.getY()<piece.getPos().getY()) {
					if(checkDownLeft(piece,end)) {
						board[end.getX()][end.getY()] = piece;
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						piece.setPos(end);
					}
				}
			}
		
		}
		throw new InvalidMoveExcpeption();
	}
}
		
			/*if (piece.move(row, col)) {
				if(piece instanceof Pawn) {
					movePawn(new Position(row,col),(Pawn) piece);
				}
				else if(piece instanceof Rook) {
					moveRook(new Position(row,col),(Rook) piece);
				}
				else if (piece instanceof King) {
					moveKing(new Position(row,col),(King) piece);
				}
				else if (piece instanceof Bishop) {
					moveBishop(new Position(row,col),(Bishop) piece);
				}
				else if(piece instanceof Knight) {
					moveKnight(new Position(row,col),(Knight) piece);
				}
				else if (piece instanceof Queen) {
					moveQueen(new Position(row,col),(Queen) piece);
				}
			}*/
		

	/*private boolean moveKing(Position position, King piece) {
		while (position.getX() != piece.getPos().getX() || position.getY() != piece.getPos().getY()) {
			if(position.getX() == piece.getPos().getX()) {
				if(position.getY() > piece.getPos().getY()) {
					if(board[piece.getPos().getX()][piece.getPos().getY()+1] != null) {
						if(board[piece.getPos().getX()][piece.getPos().getY()+1].getTeam() != piece.getTeam()) {
							board [piece.getPos().getX()][piece.getPos().getY()] = null;
							board [piece.getPos().getX()][piece.getPos().getY()+1] = piece;
							piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()+1));
						}
						else {
							return false;
						}
					}
					else {
						board [piece.getPos().getX()][piece.getPos().getY()] = null;
						board [piece.getPos().getX()][piece.getPos().getY()+1] = piece;
						piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()+1));
					}
				}
				else if (position.getY()< piece.getPos().getY()) {
					if(board[piece.getPos().getX()][piece.getPos().getY()-1] != null) {
						if(board[piece.getPos().getX()][piece.getPos().getY()-1].getTeam() != piece.getTeam()) {
							board [piece.getPos().getX()][piece.getPos().getY()] = null;
							board [piece.getPos().getX()][piece.getPos().getY()-1] = piece;
							piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()-1));
						}
						else {
							return false;
						}
					}
					else {
						board [piece.getPos().getX()][piece.getPos().getY()] = null;
						board [piece.getPos().getX()][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()-1));
					}
				}
			}
			else if(position.getY() == piece.getPos().getY()) {
				if(position.getX()> piece.getPos().getX()) {
					if(board[piece.getPos().getX()+1][piece.getPos().getY()] != null) {
						if(board[piece.getPos().getX()+1][piece.getPos().getY()].getTeam() != piece.getTeam() ) {
							board[piece.getPos().getX()][piece.getPos().getY()] = null;
							board[piece.getPos().getX()+1][piece.getPos().getY()] = piece;
							piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()));
						}
						else {
							return false;
						}
					}
					else {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()] = piece;
						piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()));
					}
				}
				else if(position.getX() < piece.getPos().getX()){
					if(board[piece.getPos().getX()-1][piece.getPos().getY()] != null) {
						if(board[piece.getPos().getX()-1][piece.getPos().getY()].getTeam() != piece.getTeam() ) {
							board[piece.getPos().getX()][piece.getPos().getY()] = null;
							board[piece.getPos().getX()-1][piece.getPos().getY()] = piece;
							piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()));
						}
						else {
							return false;
						}
					}
					else {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()-1][piece.getPos().getY()] = piece;
						piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()));
					}
				}
			}
			else if (position.getX() > piece.getPos().getX() && position.getY() > piece.getPos().getY()) {
				if (board[piece.getPos().getX()+1][piece.getPos().getY()+1] != null) {
					if(board[piece.getPos().getX() +1 ][piece.getPos().getY()+1].getTeam() != piece.getTeam())   {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()+1] = piece;
						piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()+1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()+1][piece.getPos().getY()+1] = piece;
					piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()+1));
				}
			}
			else if (position.getX()> piece.getPos().getX() && position.getY() < piece.getPos().getY()) {
				if(board[piece.getPos().getX()+1][piece.getPos().getY()-1] != null) {
					if(board[piece.getPos().getX()+1][piece.getPos().getY()-1].getTeam() != piece.team) {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position (piece.getPos().getX()+1, piece.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()+1][piece.getPos().getY()-1] = piece;
					piece.setPos(new Position (piece.getPos().getX()+1, piece.getPos().getY()-1));
				}
			}
		
		else if (position.getX() < piece.getPos().getX() && position.getY() < piece.getPos().getY()) {
				if(board[piece.getPos().getX()-1][piece.getPos().getY()-1] != null) {
					if(board[piece.getPos().getX()-1][piece.getPos().getY()-1].getTeam() != piece.getTeam()) {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()-1][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position (piece.getPos().getX()-1, piece.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()-1][piece.getPos().getY()-1] = piece;
					piece.setPos(new Position (piece.getPos().getX()-1, piece.getPos().getY()-1));
				}
			}
		else if (position.getX() < piece.getPos().getX() && position.getY()> piece.getPos().getY()) {
			if (board[piece.getPos().getX()-1][piece.getPos().getY()+1] != null) {
				if(board[piece.getPos().getX()-1][piece.getPos().getY()+1].getTeam() != piece.getTeam()) {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()-1][piece.getPos().getY()+1] = piece;
					piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()+1));
				}
				else {
					return false;
				}
			}
			else {
				board[piece.getPos().getX()][piece.getPos().getY()] = null;
				board[piece.getPos().getX()-1][piece.getPos().getY()+1] = piece;
				piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()+1));
			}
		}
		}
		return true;
	}*/
	/*private boolean moveBishop(Position position, Bishop piece) {
		// TODO Auto-generated method stub
		while (position.getX() != piece.getPos().getX() || position.getY() != piece.getPos().getY()) {
			if (position.getX() > piece.getPos().getX() && position.getY() > piece.getPos().getY()) {
				if (board[piece.getPos().getX()+1][piece.getPos().getY()+1] != null) {
					if(board[piece.getPos().getX() +1 ][piece.getPos().getY()+1].getTeam() != piece.getTeam())   {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()+1] = piece;
						piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()+1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()+1][piece.getPos().getY()+1] = piece;
					piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()+1));
				}
			}
			else if (position.getX()> piece.getPos().getX() && position.getY() < piece.getPos().getY()) {
				if(board[piece.getPos().getX()+1][piece.getPos().getY()-1] != null) {
					if(board[piece.getPos().getX()+1][piece.getPos().getY()-1].getTeam() != piece.team) {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position (piece.getPos().getX()+1, piece.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()+1][piece.getPos().getY()-1] = piece;
					piece.setPos(new Position (piece.getPos().getX()+1, piece.getPos().getY()-1));
				}
			}
		
		else if (position.getX() < piece.getPos().getX() && position.getY() < piece.getPos().getY()) {
				if(board[piece.getPos().getX()-1][piece.getPos().getY()-1] != null) {
					if(board[piece.getPos().getX()-1][piece.getPos().getY()-1].getTeam() != piece.getTeam()) {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()-1][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position (piece.getPos().getX()-1, piece.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()-1][piece.getPos().getY()-1] = piece;
					piece.setPos(new Position (piece.getPos().getX()-1, piece.getPos().getY()-1));
				}
			}
		else if (position.getX() < piece.getPos().getX() && position.getY()> piece.getPos().getY()) {
			if (board[piece.getPos().getX()-1][piece.getPos().getY()+1] != null) {
				if(board[piece.getPos().getX()-1][piece.getPos().getY()+1].getTeam() != piece.getTeam()) {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()-1][piece.getPos().getY()+1] = piece;
					piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()+1));
				}
				else {
					return false;
				}
			}
			else {
				board[piece.getPos().getX()][piece.getPos().getY()] = null;
				board[piece.getPos().getX()-1][piece.getPos().getY()+1] = piece;
				piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()+1));
				}
			}
		}
		return true;
	}*/

	/*private boolean moveQueen(Position position, Queen piece) {
		// TODO Auto-generated method stub
		while (position.getX() != piece.getPos().getX() || position.getY() != piece.getPos().getY()) {
			if(position.getX() == piece.getPos().getX()) {
				if(position.getY() > piece.getPos().getY()) {
					if(board[piece.getPos().getX()][piece.getPos().getY()+1] != null) {
						if(board[piece.getPos().getX()][piece.getPos().getY()+1].getTeam() != piece.getTeam()) {
							board [piece.getPos().getX()][piece.getPos().getY()] = null;
							board [piece.getPos().getX()][piece.getPos().getY()+1] = piece;
							piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()+1));
						}
						else {
							return false;
						}
					}
					else {
						board [piece.getPos().getX()][piece.getPos().getY()] = null;
						board [piece.getPos().getX()][piece.getPos().getY()+1] = piece;
						piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()+1));
					}
				}
				else if (position.getY()< piece.getPos().getY()) {
					if(board[piece.getPos().getX()][piece.getPos().getY()-1] != null) {
						if(board[piece.getPos().getX()][piece.getPos().getY()-1].getTeam() != piece.getTeam()) {
							board [piece.getPos().getX()][piece.getPos().getY()] = null;
							board [piece.getPos().getX()][piece.getPos().getY()-1] = piece;
							piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()-1));
						}
						else {
							return false;
						}
					}
					else {
						board [piece.getPos().getX()][piece.getPos().getY()] = null;
						board [piece.getPos().getX()][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position(piece.getPos().getX(), piece.getPos().getY()-1));
					}
				}
			}
			else if(position.getY() == piece.getPos().getY()) {
				if(position.getX()> piece.getPos().getX()) {
					if(board[piece.getPos().getX()+1][piece.getPos().getY()] != null) {
						if(board[piece.getPos().getX()+1][piece.getPos().getY()].getTeam() != piece.getTeam() ) {
							board[piece.getPos().getX()][piece.getPos().getY()] = null;
							board[piece.getPos().getX()+1][piece.getPos().getY()] = piece;
							piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()));
						}
						else {
							return false;
						}
					}
					else {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()] = piece;
						piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()));
					}
				}
				else if(position.getX() < piece.getPos().getX()){
					if(board[piece.getPos().getX()-1][piece.getPos().getY()] != null) {
						if(board[piece.getPos().getX()-1][piece.getPos().getY()].getTeam() != piece.getTeam() ) {
							board[piece.getPos().getX()][piece.getPos().getY()] = null;
							board[piece.getPos().getX()-1][piece.getPos().getY()] = piece;
							piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()));
						}
						else {
							return false;
						}
					}
					else {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()-1][piece.getPos().getY()] = piece;
						piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()));
					}
				}
			}
			else if (position.getX() > piece.getPos().getX() && position.getY() > piece.getPos().getY()) {
				if (board[piece.getPos().getX()+1][piece.getPos().getY()+1] != null) {
					if(board[piece.getPos().getX() +1 ][piece.getPos().getY()+1].getTeam() != piece.getTeam())   {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()+1] = piece;
						piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()+1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()+1][piece.getPos().getY()+1] = piece;
					piece.setPos(new Position(piece.getPos().getX()+1,piece.getPos().getY()+1));
				}
			}
			else if (position.getX()> piece.getPos().getX() && position.getY() < piece.getPos().getY()) {
				if(board[piece.getPos().getX()+1][piece.getPos().getY()-1] != null) {
					if(board[piece.getPos().getX()+1][piece.getPos().getY()-1].getTeam() != piece.team) {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()+1][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position (piece.getPos().getX()+1, piece.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()+1][piece.getPos().getY()-1] = piece;
					piece.setPos(new Position (piece.getPos().getX()+1, piece.getPos().getY()-1));
				}
			}
		
		else if (position.getX() < piece.getPos().getX() && position.getY() < piece.getPos().getY()) {
				if(board[piece.getPos().getX()-1][piece.getPos().getY()-1] != null) {
					if(board[piece.getPos().getX()-1][piece.getPos().getY()-1].getTeam() != piece.getTeam()) {
						board[piece.getPos().getX()][piece.getPos().getY()] = null;
						board[piece.getPos().getX()-1][piece.getPos().getY()-1] = piece;
						piece.setPos(new Position (piece.getPos().getX()-1, piece.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()-1][piece.getPos().getY()-1] = piece;
					piece.setPos(new Position (piece.getPos().getX()-1, piece.getPos().getY()-1));
				}
			}
		else if (position.getX() < piece.getPos().getX() && position.getY()> piece.getPos().getY()) {
			if (board[piece.getPos().getX()-1][piece.getPos().getY()+1] != null) {
				if(board[piece.getPos().getX()-1][piece.getPos().getY()+1].getTeam() != piece.getTeam()) {
					board[piece.getPos().getX()][piece.getPos().getY()] = null;
					board[piece.getPos().getX()-1][piece.getPos().getY()+1] = piece;
					piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()+1));
				}
				else {
					return false;
				}
			}
			else {
				board[piece.getPos().getX()][piece.getPos().getY()] = null;
				board[piece.getPos().getX()-1][piece.getPos().getY()+1] = piece;
				piece.setPos(new Position(piece.getPos().getX()-1,piece.getPos().getY()+1));
			}
		}
		}
		return true;
		
	}*/
	/*public void move(Pawn piece, Position pos) {
		boolean valid = false;
		for (Position x:  piece.arrMove()) {
			if ((x.getX()==pos.getX())&& x.getY()==pos.getY()) {
				board[pos.getX()][pos.getY()] = piece;
				board[piece.getPos().getX()][piece.getPos().getY()]= null;
				piece.setPos(pos);
				valid = true;
			}
		}
		if(!valid) {
			System.out.println("Not a valid move");
		}
	}*/
	/**
	 * A method to return a specic piece for a given location on the board
	 * @param row the x coordinate of the piece to be returned
	 * @param col the y coordinate of the piece to be returned
	 * @return the piece requested
	 */
	
	/*public boolean moveKing(Position endPos, King king) {
		while(king.getPos().getX() != endPos.getX() || king.getPos().getY() != endPos.getY()) {
			if(endPos.getX() > king.getPos().getX()) {
				if(endPos.getY() > king.getPos().getY()) {
					if(board[king.getPos().getX()+1][king.getPos().getY()+1] != null) {
						if(board[king.getPos().getX()+1][king.getPos().getY()+1].team != king.team) {
							board[king.getPos().getX()][king.getPos().getY()] = null;
							board[king.getPos().getX()+1][king.getPos().getY()+1] = king;
							king.setPos(new Position(king.getPos().getX()+1,king.getPos().getY()+1));
						
						}
						else {
							return false;
						}
					}
					else {
						board[king.getPos().getX()][king.getPos().getY()] = null;
						board[king.getPos().getX()+1][king.getPos().getY()+1] = king;
						king.setPos(new Position(king.getPos().getX()+1,king.getPos().getY()+1));
					}
				}
				else {
					if(board[king.getPos().getX()+1][king.getPos().getY()] != null) {
						if(board[king.getPos().getX()+1][king.getPos().getY()].team != king.team) {
							board[king.getPos().getX()][king.getPos().getY()] = null;
							board[king.getPos().getX()+1][king.getPos().getY()] = king;
							king.setPos(new Position(king.getPos().getX()+1,king.getPos().getY()));
						}
						else {
							return false;
						}
					}
					else {
						board[king.getPos().getX()][king.getPos().getY()] = null;
						board[king.getPos().getX()+1][king.getPos().getY()] = king;
						king.setPos(new Position(king.getPos().getX()+1,king.getPos().getY()));
					}
				}
			}
			else {
				if(endPos.getY()<king.getPos().getY()) {
					if(board[king.getPos().getX()-1][king.getPos().getY()-1] != null) {
						if(board[king.getPos().getX()-1][king.getPos().getY()-1].team != king.team) {
							board[king.getPos().getX()][king.getPos().getY()] = null;
							board[king.getPos().getX()-1][king.getPos().getY()-1] = king;
							king.setPos(new Position(king.getPos().getX()-1,king.getPos().getY()-1));
						}
						else {
							return false;
						}
					}
					else {
						board[king.getPos().getX()][king.getPos().getY()] = null;
						board[king.getPos().getX()-1][king.getPos().getY()-1] = king;
						king.setPos(new Position(king.getPos().getX()-1,king.getPos().getY()-1));
					}
				}
				else {
					if(board[king.getPos().getX()-1][king.getPos().getY()] != null) {
						if(board[king.getPos().getX()-1][king.getPos().getY()].team != king.team) {
							board[king.getPos().getX()][king.getPos().getY()] = null;
							board[king.getPos().getX()-1][king.getPos().getY()] = king;
							king.setPos(new Position(king.getPos().getX()-1,king.getPos().getY()));
						}
						else {
							return false;
						}
					}
					else {
						board[king.getPos().getX()][king.getPos().getY()] = null;
						board[king.getPos().getX()-1][king.getPos().getY()] = king;
						king.setPos(new Position(king.getPos().getX()-1,king.getPos().getY()));
					}
				}
			}
		}
		return true;
	}*/
	
	/*public boolean moveBishop(Position endPos, Bishop bishop) {
		while(bishop.getPos().getX()!=endPos.getX() || bishop.getPos().getY()!= endPos.getY()) {
			if (endPos.getX() > bishop.getPos().getX()) {
				if(board[bishop.getPos().getX()+1][bishop.getPos().getY()+1]!=null) {
					if (board[bishop.getPos().getX()+1][bishop.getPos().getY()+1].team != bishop.team && (bishop.getPos().getX()+1 == endPos.getX() && bishop.getPos().getY()+1 == endPos.getY())) {
						board[bishop.getPos().getX()][bishop.getPos().getY()] = null;
						board[bishop.getPos().getX()+1][bishop.getPos().getY()+1] = bishop;
						bishop.setPos(new Position(bishop.getPos().getX()+1, bishop.getPos().getY()+1));
					}
					else {
						return false;
					}
				}
				else {
					board[bishop.getPos().getX()][bishop.getPos().getY()] = null;
					board[bishop.getPos().getX()+1][bishop.getPos().getY()+1] = bishop;
					bishop.setPos(new Position(bishop.getPos().getX()+1, bishop.getPos().getY()+1));
				}
			}
			if(endPos.getX()!= bishop.getPos().getX()  || endPos.getY() != bishop.getPos().getY()) {
				if(board [bishop.getPos().getX()-1][bishop.getPos().getY()-1] != null) {
					if (board [bishop.getPos().getX()-1][bishop.getPos().getY()-1].team != bishop.team && (bishop.getPos().getX()-1 == endPos.getX() && bishop.getPos().getY()-1 == endPos.getY())) {
						board [bishop.getPos().getX()][bishop.getPos().getY()] = null;
						board [bishop.getPos().getX()-1][bishop.getPos().getY()-1] = bishop;
						bishop.setPos(new Position(bishop.getPos().getX()-1,bishop.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
				else {
					board [bishop.getPos().getX()][bishop.getPos().getY()] = null;
					board [bishop.getPos().getX()-1][bishop.getPos().getY()-1] = bishop;
					bishop.setPos(new Position(bishop.getPos().getX()-1,bishop.getPos().getY()-1));
				}
			} 
		}
		return true;
	}*/
	
	/*public boolean movePawn(Position endPos, Pawn pawn) {
		while((pawn.getPos().getX()!=endPos.getX()) || (pawn.getPos().getY()!= endPos.getY())) {
			if (pawn.team){
				if(board [pawn.getPos().getX()+1][pawn.getPos().getY()] != null) 
					return false;
				else {
					board[pawn.getPos().getX()][pawn.getPos().getY()] = null;
					board[pawn.getPos().getX()+1][endPos.getY()] = pawn;
					pawn.setPos(new Position(pawn.getPos().getX()+1,pawn.getPos().getY()));
				}
			}
			else if (board [pawn.getPos().getX()-1][pawn.getPos().getY()]!=null) {
				return false;
				}
				else {
					board[pawn.getPos().getX()][pawn.getPos().getY()] = null;
					board[pawn.getPos().getX()-1][endPos.getY()] = pawn;
					pawn.setPos(new Position(pawn.getPos().getX()-1,pawn.getPos().getY()));
				}
		}
		return true;
	}*/
	
	/*public boolean moveRook (Position endPos, Rook rook) {
		while(rook.getPos().getX() != endPos.getX() || rook.getPos().getY() != endPos.getY()) {	
			if(endPos.getX() == rook.getPos().getX()) {
				if(endPos.getY()>rook.getPos().getY()) {
					if (board [rook.getPos().getX()][rook.getPos().getY()+1] !=null && (rook.getPos().getX() == endPos.getX() && rook.getPos().getY()+1 == endPos.getY() )) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()][rook.getPos().getY()+1] = rook;
						rook.setPos(endPos);
					}
					else if (board [rook.getPos().getX()][rook.getPos().getY()+1] ==null) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()][rook.getPos().getY()+1] = rook;
						rook.setPos(new Position(rook.getPos().getX(),rook.getPos().getY()+1));
					}
					else {
						return false;
					}
				}
				else if (endPos.getY()< rook.getPos().getY()) {
					if (board [rook.getPos().getX()][rook.getPos().getY()-1] !=null && (rook.getPos().getX() == endPos.getX() && rook.getPos().getY()-1 == endPos.getY() )) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()][rook.getPos().getY()-1] = rook;
						rook.setPos(endPos);
					}
					else if (board [rook.getPos().getX()][rook.getPos().getY()-1] ==null) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()][rook.getPos().getY()-1] = rook;
						rook.setPos(new Position(rook.getPos().getX(),rook.getPos().getY()-1));
					}
					else {
						return false;
					}
				}
			}
			else {
				if(endPos.getX()>rook.getPos().getX()) {
					if (board [rook.getPos().getX()+1][rook.getPos().getY()] !=null && (rook.getPos().getX()+1 == endPos.getX() && rook.getPos().getY() == endPos.getY() )) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()+1][rook.getPos().getY()] = rook;
						rook.setPos(endPos);
					}
					else if (board [rook.getPos().getX()+1][rook.getPos().getY()] ==null) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()+1][rook.getPos().getY()] = rook;
						rook.setPos(new Position(rook.getPos().getX()+1,rook.getPos().getY()));
					}
					else {
						return false;
					}
				}
				else {
					if (board [rook.getPos().getX()-1][rook.getPos().getY()] !=null && (rook.getPos().getX()+1 == endPos.getX() && rook.getPos().getY() == endPos.getY() )) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()-1][rook.getPos().getY()] = rook;
						rook.setPos(endPos);
					}
					else if (board [rook.getPos().getX()-1][rook.getPos().getY()] ==null) {
						board[rook.getPos().getX()][rook.getPos().getY()] = null;
						board[rook.getPos().getX()-1][rook.getPos().getY()] = rook;
						rook.setPos(new Position(rook.getPos().getX()-1,rook.getPos().getY()));
					}
					else {
						return false;
					}
				}
			}
		}
		return true;
	}*/
	/*public boolean moveKnight(Position endPos, Knight knight) {
		if (board[endPos.getX()][endPos.getY()] != null && board[endPos.getX()][endPos.getY()].team == knight.team) {
			return false;
		}
		else {
			board[knight.getPos().getX()][knight.getPos().getY()] = null;
			board[endPos.getX()][endPos.getY()] = knight;
			knight.setPos(endPos);
		}
		return true;
	}*/
