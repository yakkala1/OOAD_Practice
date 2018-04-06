import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

public class GameTest {
	
	@Test
	public void testGame() {
		String inputString = ""
				+ "PUT 0 0\n"
				+ "PUT 1 0\n"
				+ "PUT 0 1\n"
				+ "PUT 1 1\n"
				+ "PUT 0 2\n"
				+ "PUT 1 2";
		InputStream input = new ByteArrayInputStream(inputString.getBytes(StandardCharsets.UTF_8));
		Game game = new Game(input);
		game.startGame();
	}

}
