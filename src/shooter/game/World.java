package shooter.game;

import java.io.File;
import java.io.IOException;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import shooter.ShooterDisplay;

public class World {
	private Image image;

	protected World() {
		this.image = ShooterDisplay.getImage("sky");
	}
	
	public static World loadWorld(File file) throws IOException {
		return null;
	}
	
	public void saveWorld(File file) throws IOException {
	}
	
	public static World createNewWorld() {
		return new World(); 
	}

	public void render(Graphics graphics) {
		image.draw(0, 0, 640, 480);
	}
}
