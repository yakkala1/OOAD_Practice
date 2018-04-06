import static org.junit.Assert.*;

import org.junit.Test;

public class BoardTest {

	@Test
	public void testGameOverFalse() {
		Board board = new Board();
		String marker = "m";
		board.set(new BoardPosition(1, 0), marker);
		board.set(new BoardPosition(2, 2), marker);
		board.set(new BoardPosition(0, 0), marker);
		assertEquals(false, board.checkGameOver());
	}
	
	@Test
	public void testGameOverOnRow() {
		Board board = new Board();
		String marker = "m";
		board.set(new BoardPosition(1, 0), marker);
		board.set(new BoardPosition(1, 1), marker);
		board.set(new BoardPosition(1, 2), marker);
		assertEquals(true, board.checkGameOver());
	}

	@Test
	public void testGameOverOnColumn() {
		Board board = new Board();
		String marker = "m";
		board.set(new BoardPosition(1, 0), marker);
		board.set(new BoardPosition(2, 0), marker);
		board.set(new BoardPosition(0, 0), marker);
		assertEquals(true, board.checkGameOver());
	}

	@Test
	public void testGameOverOnDiagonal1() {
		Board board = new Board();
		String marker = "m";
		board.set(new BoardPosition(0, 0), marker);
		board.set(new BoardPosition(1, 1), marker);
		board.set(new BoardPosition(2, 2), marker);
		assertEquals(true, board.checkGameOver());
	}

	@Test
	public void testGameOverOnDiagonal2() {
		Board board = new Board();
		String marker = "m";
		board.set(new BoardPosition(0, 2), marker);
		board.set(new BoardPosition(1, 1), marker);
		board.set(new BoardPosition(2, 0), marker);
		assertEquals(true, board.checkGameOver());
	}

	@Test
	public void testGameOverOnEmptyBoard() {
		Board board = new Board();
		assertEquals(false, board.checkGameOver());
	}

}
