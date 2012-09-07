package shooter.game;

import java.io.File;
import java.io.IOException;

public class World {
	protected World() {
		
	}
	
	public static World loadWorld(File file) throws IOException {
		return null;
	}
	
	public void saveWorld(File file) throws IOException {
	}
	
	public static World createNewWorld() {
		return new World(); 
	}
}
