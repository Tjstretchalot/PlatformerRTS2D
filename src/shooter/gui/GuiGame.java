package shooter.gui;

import org.newdawn.slick.Graphics;

import shooter.Gui;
import shooter.game.EntityPlayer;
import shooter.game.World;

public class GuiGame implements Gui {

	private World world;
	private EntityPlayer mPlayer;

	public GuiGame(World world) {
		this.world = world;
		mPlayer = new EntityPlayer(world);
		spawnPlayer();
	}
	
	private void spawnPlayer() {
		mPlayer.x = 50;
		mPlayer.y = 448;
	}

	@Override
	public void render(Graphics graphics, long time) {
		world.render(graphics);
		mPlayer.render(graphics);
	}

	@Override
	public void update(long delta) {
		mPlayer.doTick(delta);
	}

}
