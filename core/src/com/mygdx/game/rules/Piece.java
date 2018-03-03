package com.mygdx.game.rules;


public abstract class Piece implements Movable {
	/**
	 * A field to hold if the piece belongs to the black or white team.
	 * Where true - white 
	 * Where false - black
	 */
	protected boolean team;
	/**
	 * a field to hold if the piece has been taken or not
	 */
	protected boolean isTaken;
	
	/**
	 * a field to hold the position of the piece
	 */
	protected Position position;
	
	protected int locationRow;
	
	/**
	 * A field to hold the column of the piece
	 */
	protected int locationCol;
	protected String name;
	/**
	 * A constructor that takes an x and y coordinate and a boolean representing if the piece is black or white it then initialises values.
	 * @param row a parameter that takes an integer representing the x position.
	 * @param col a parameter that takes an integer representing the y position.
	 * @param player a parameter that takes a boolean representing if the piece is black or white. True for white, False for black.
	 */
	public Piece(int row, int col, boolean player) {
		position = new Position(row,col);
		setTeam(player);
	}
	
	public Position getPos() {
		return position;
	}
	public void setPos(Position pos) {
		position = pos;
	}
	
	/**
	 * A method for setting the {@link team} field of the piece
	 * @param player the new value for team field
	 */
	public void setTeam (boolean player) {
		team = player;
	}	
	
	public boolean getTeam() {
		return team;
	}

	public String printPieceType() {
		// TODO Auto-generated method stub
		return name;
	}
}