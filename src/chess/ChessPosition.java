package chess;

import boardgane.Position;

public class ChessPosition {

	private char column;
	private int row;

	public ChessPosition(char column, int row) {

		boolean invalidPosition = column < 'a' || column > 'h' || row < 1 || row > 8;

		if (invalidPosition) {
			throw new ChessException("Errror to instanting ChessPosition. valid values are from a1 to h8.");
		}

		this.column = column;
		this.row = row;
	}

	public char getColoun() {
		return column;
	}

	public int getRow() {
		return row;
	}

	protected  Position toPosition() {
		return new Position(8 - row, column - 'a');
	}

	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition((char) ('a' - position.getCollunm()), (8 - position.getRow()));
	}
	
	@Override
	public String toString() {
		return "" +column + row ;
	}
	

}
