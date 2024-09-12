package boardgane;



public class Board {

	private int rows;
	private int collumns;
	private Piece[][] pieces;

	public Board(int rows, int collumns) {

		if (rows < 1 || collumns < 1) {
			throw new BoardException("Error creating Board: there must be at leat 1 rown and 1 collumn");
		}

		this.rows = rows;
		this.collumns = collumns;
		pieces = new Piece[rows][collumns];
	}

	public int getRows() {
		return rows;
	}

	public int getCollumns() {
		return collumns;
	}

	public Piece piece(int rown, int collumn) {
		if (!positionExists(rown, collumn)) {
			throw new BoardException("Positon not on the board");
		}

		return this.pieces[rown][collumn];
	}
	

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Positon not on the board");
		}
		return pieces[position.getRow()][position.getCollunm()];
	}
	
	
	
	public void placePiece(Piece piece, Position position) {
		
		if(thereIsAPiece(position)) {
			throw new BoardException("There is a already a piece on positon: " + position);
		}
		
		pieces[position.getRow()][position.getCollunm()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if (!positionExists(position)) {
			throw new BoardException("Positon not on the board");
		}
		
		if(piece(position) == null) {
			return null;
		}
		
		
		Piece pieceToRemove = piece(position);
		
		pieceToRemove.position = null;
		
		pieces[position.getRow()][position.getCollunm()] = null;
		
		return pieceToRemove;
		
	}

	private boolean positionExists(int row, int collumn) {
		return row >= 0 && row < this.rows && collumn >= 0 && collumn < this.collumns;
	}

	private boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getCollunm());
	}

	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("Positon not on the board");
		}
		
		return piece(position) != null;
	}

}
