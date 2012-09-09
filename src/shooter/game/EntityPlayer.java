package shooter.game;

import static org.lwjgl.input.Keyboard.*;

public class EntityPlayer extends Entity {

	public EntityPlayer(World world) {
		super(world, "player");
	}

	@Override
	public void updateInput() {
		if(isKeyDown(KEY_A) || isKeyDown(KEY_LEFT)) {
			if(xVelocity > -1.4) {
				xVelocity -= 0.1f;
			}else {
				xVelocity = -1.5f;
			}
			
			direction = 0;
		}else if(xVelocity < 0) {
			if(xVelocity < -0.5) {
				xVelocity += 0.5f;
			}else {
				xVelocity = 0;
			}
		}
		
		if(isKeyDown(KEY_D) || isKeyDown(KEY_RIGHT)) {
			if(xVelocity < 1.4) {
				xVelocity += 0.1f;
			}else {
				xVelocity = 1.5f;
			}
			
			direction = 1;
		}else if(xVelocity > 0) {
			if(xVelocity > 0.5) {
				xVelocity -= 0.5f;
			}else {
				xVelocity = 0;
			}
		}
	}
}
