import java.util.NoSuchElementException;
import java.util.Scanner;

public class UI {

	public PlayerAction getNextMove() {
		do {
			System.out.println("Enter your move");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			scanner.close();
			try {
				return interpret(input);
			} catch(IllegalArgumentException e) {
				System.out.println("Invalid input format. Try again");
			}
		} while(true);
	}

	private PlayerAction interpret(String input) throws IllegalArgumentException {
		try {
			Scanner scanner = new Scanner(input);
			String action = scanner.next();
			switch(action) {
			case "PUT":
				int x = scanner.nextInt();
				int y = scanner.nextInt();
				BoardPosition position = new BoardPosition(x,y);
				scanner.close();
				return new PutAction(position);
			case "MOVE":
				int fromX = scanner.nextInt();
				int fromY = scanner.nextInt();
				int toX = scanner.nextInt();
				int toY = scanner.nextInt();
				scanner.close();
				BoardPosition from = new BoardPosition(fromX, fromY);
				BoardPosition to = new BoardPosition(toX, toY);
				return new MoveAction(from,to);
			default:
				scanner.close();
				throw new IllegalArgumentException();
			}
		} catch(NoSuchElementException e) {
			throw new IllegalArgumentException();
		} 
	}

	public void showInvalidMoveMsg() {
		System.out.println("Invalid Move. Please try another move");
	}

	public void announceWinner(Player currentPlayer) {
		System.out.println(currentPlayer+" won!!");
	}

	public void updateDisplay(Board board) {
		for(int i=0; i<board.getNRows(); i++) {
			for(int j=0; j<board.getCols(); j++) {
				BoardPosition position = new BoardPosition(i,j);
				printMarker(board.get(position));
				if(j != board.getCols()-1)
					System.out.print("----");
			}
			System.out.println();
			if(i != board.getNRows()-1)
				printRowSeperator();
		}
	}

	private void printRowSeperator() {
		for(int i=0; i<4; i++) {
			System.out.println("|      |      |");
		}
	}

	private void printMarker(String marker) {
		if(marker.equals(Board.emptyMarker)) {
			System.out.print("  ");
		} else {
			System.out.print(marker);
		}
	}

}
