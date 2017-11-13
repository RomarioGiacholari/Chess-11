public class Bishop extends Piece{

	protected boolean moved = false;

	public Bishop(int row, int col, boolean player) {
		super(row, col, player);
	}
	public String toString() {
		if(team) {	
			return "B";
		} else {
			return "b";
		}
	}

	@Override
	public boolean move(int row, int col) {

	if(row <8 && col < 8){
		for( int i=1; i<8;i++) {
			if((row == position.getX() + i && col == position.getY() +i ) || (row == position.getX() - i && col ==position.getY() -i )||(row == position.getX() + i && col ==position.getY() -i || (row == position.getX() - i && col ==position.getY() +i ))){
				return true;
			}
		}
		return false;
	}

	return false;
	}
}