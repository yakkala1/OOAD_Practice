
public class App {
	
	static boolean quit = false;
	
	public static void main(String[] args) {
		Display display = new Display();
		CoffeeMachine machine = new CoffeeMachine( new CoffeeMaker() , display );
		while( quit == false ) {
			display.show();
			Command command = getInput();
		}
	}

	private static Command interpretInput() {
		
	}

}
