import java.io.InputStream;

public class Game {
	
	private Player currentPlayer;
	private Board board;
	private InputStream inputStream;
	private UI ui;
	private int movesDone;
	
	public Game(InputStream stream) {
		this.inputStream = stream;
		this.ui = new UI(inputStream);
		this.board = new Board();
		this.movesDone = 0;
	}
	
	public void startGame() {
		currentPlayer = Player.P1;
		while(true) {
			PlayerAction move = ui.getNextMove();
			try {
				runMove(move);
				ui.updateDisplay(board);
				if( board.checkGameOver() ) {
					ui.announceWinner(currentPlayer);
					return;
				}
				alterPlayer();
			} catch(InvalidMove e) {
				ui.showInvalidMoveMsg();
			}
		}
	}

	private void alterPlayer() {
		if(currentPlayer == Player.P1)
			currentPlayer = Player.P2;
		else
			currentPlayer = Player.P1;
	}

	private void runMove(PlayerAction move) throws InvalidMove {
		try {
			if(movesDone<6) {
				PutAction action = (PutAction)move;
				runPutAction(action);
			} else {
				MoveAction action = (MoveAction)move;
				runMoveAction(action);
			}
			movesDone++;
		} catch(ClassCastException e) {
			throw new InvalidMove();
		}
	}

	private void runMoveAction(MoveAction action) throws InvalidMove {
		if(board.get(action.from) != currentPlayer.marker)
			throw new InvalidMove();
		if(!board.isEmpty(action.to))
			throw new InvalidMove();
		
		board.setEmpty(action.from);
		board.set(action.to, currentPlayer.marker);
	}

	private void runPutAction(PutAction action) throws InvalidMove {
		if( !board.isEmpty(action.position) )
			throw new InvalidMove();
		board.set(action.position, currentPlayer.marker);
	}

}
