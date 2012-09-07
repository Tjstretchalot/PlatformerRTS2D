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
	}
	
	@Override
	public void render(Graphics graphics, long time) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long delta) {
		// TODO Auto-generated method stub

	}

}
