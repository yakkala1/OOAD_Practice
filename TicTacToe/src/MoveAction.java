public class MoveAction extends PlayerAction {
	
	public BoardPosition from, to;
	
	public MoveAction(BoardPosition from, BoardPosition to) {
		this.from = from;
		this.to = to;
	}

}