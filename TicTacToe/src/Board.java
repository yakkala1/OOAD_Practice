public class Board {
	
	private static final int nRows = 3;
	private static final int nCols = 3;
	String[][] matrix = new String[nRows][nCols];
	public static final String emptyMarker = "";
	
	public Board() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = emptyMarker;
			}
		}
	}

	public boolean checkGameOver() {
		return checkRows() ||
				checkCols() ||
				checkDiagonal1() || 
				checkDiagonal2();
	}

	private boolean checkDiagonal2() {
		BoardPosition p1 = new BoardPosition(0, 2);
		BoardPosition p2 = new BoardPosition(1, 1);
		BoardPosition p3 = new BoardPosition(2, 0);
		if( haveSameMarker(p1, p2, p3) )
			return true;
		else
			return false;
	}

	private boolean checkDiagonal1() {
		BoardPosition p1 = new BoardPosition(0, 0);
		BoardPosition p2 = new BoardPosition(1, 1);
		BoardPosition p3 = new BoardPosition(2, 2);
		if( haveSameMarker(p1, p2, p3) )
			return true;
		else
			return false;	
	}

	private boolean checkCols() {
		for(int i=0; i<3; i++) {
			if(colsFilled(i))
				return true;
		}
		return false;	
	}

	private boolean colsFilled(int i) {
		BoardPosition position1 = new BoardPosition(0, i);
		BoardPosition position2 = new BoardPosition(1, i);
		BoardPosition position3 = new BoardPosition(2, i);
		if( haveSameMarker(position1, position2, position3) )
			return true;
		else
			return false;
	}

	private boolean haveSameMarker(BoardPosition position1, BoardPosition position2, BoardPosition position3) {
		return get(position1)==get(position2) && get(position2)==get(position3) && !isEmpty(position1);
	}

	private boolean checkRows() {
		for(int i=0; i<3; i++) {
			if(rowFilled(i))
				return true;
		}
		return false;
	}

	private boolean rowFilled(int i) {
		BoardPosition p1 = new BoardPosition(i, 0);
		BoardPosition p2 = new BoardPosition(i, 1);
		BoardPosition p3 = new BoardPosition(i, 2);
		if( haveSameMarker(p1, p2, p3) )
			return true;
		else
			return false;
	}

	public String get(BoardPosition position) {
		int row = position.row;
		int col = position.col;
		return matrix[row][col];
	}

	public boolean isEmpty(BoardPosition position) {
		return get(position).equals(emptyMarker);
	}

	public void setEmpty(BoardPosition position) {
		set(position, emptyMarker);
	}

	public void set(BoardPosition position, String marker) {
		int row = position.row;
		int col = position.col;
		matrix[row][col] = marker;
	}

	public int getNRows() {
		return nRows;
	}

	public int getCols() {
		return nCols;
	}

}
