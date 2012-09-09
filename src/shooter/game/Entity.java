package shooter.game;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

import shooter.ShooterDisplay;

public abstract class Entity {
	protected World world;
	private Image image;
	public float xVelocity;
	public float yVelocity;
	
	public float x;
	public float y;
	
	/**
	 * 0 is left, 1 is right
	 */
	protected byte direction; // A byte to allow up-down later, if necessary
	
	public Entity(World world) { 
		this.world = world;
		image = ShooterDisplay.getImage("filler");
	}
	
	public Entity(World world, String img) {
		this.world = world;
		image = ShooterDisplay.getImage(img);
	}
	
	/**
	 * Use a polling method to update the input,
	 * for AI this would be simulating the next step.
	 */
	public abstract void updateInput();
	
	public void render(Graphics graphics) {
		Image temp = image;
		if(direction == 0)
			temp = image.getFlippedCopy(true, false);
		temp.draw(x, y);
	}
	
	public void doTick(long delta) {
		updateInput();
		if(!willHitBoundary()) {
			x += xVelocity;
			y += yVelocity;
		}
	}

	private boolean willHitBoundary() {
		return false;
	}
}
