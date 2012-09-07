package shooter.game;

import org.newdawn.slick.Image;

import shooter.ShooterDisplay;

public abstract class Entity {
	private World world;
	private Image image;
	private float xVelocity;
	private float yVelocity;
	
	private float x;
	private float y;
	
	private byte direction; // A byte to allow up-down later, if necessary
	
	public Entity(World world) { 
		this.world = world;
		image = ShooterDisplay.getImage("filler");
	}
	
	/**
	 * Use a polling method to update the input,
	 * for AI this would be simulating the next step.
	 */
	public abstract void updateInput();
	
	public void doTick(long time) {
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
