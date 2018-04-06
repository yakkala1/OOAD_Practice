public class Board {
	
	private static final int nRows = 3;
	private static final int nCols = 3;
	String[][] matrix = new String[nRows][nCols];
	public static final String emptyMarker = "";
	GameOverLogic gameOverLogic = new GameOverLogic(this);
	
	public Board() {
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				matrix[i][j] = emptyMarker;
			}
		}
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

	public boolean checkGameOver() {
		return gameOverLogic.checkGameOver();
	}

}
