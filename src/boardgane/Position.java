package boardgane;

public class Position {
	
	private int  row;
	private int collunm;
	
	public Position(int rown, int collunm) {
		this.row = rown;
		this.collunm = collunm;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int rown) {
		this.row = rown;
	}

	public int getCollunm() {
		return collunm;
	}

	public void setCollunm(int collunm) {
		this.collunm = collunm;
	}
	
	
	@Override
	public String toString() {
		return row + "," + collunm;  
	}
	
	
	
	

}
