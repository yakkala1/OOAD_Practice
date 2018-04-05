import org.junit.Test;

public class UITest {
	
	@Test
	public void testDisplay() {
		Board board = new Board();
		UI ui = new UI();
		ui.updateDisplay(board);
	}

	@Test
	public void testDisplay1() {
		Board board = new Board();
		board.set(new BoardPosition(0,0), Player.P1.marker);
		board.set(new BoardPosition(1,1), Player.P2.marker);
		board.set(new BoardPosition(1,0), Player.P1.marker);
		board.set(new BoardPosition(0,2), Player.P2.marker);
		UI ui = new UI();
		ui.updateDisplay(board);
	}
	
}
