package shooter;

import org.newdawn.slick.Graphics;

public interface Gui {
	public void render(Graphics graphics, long time);
	public void update(long delta);
}
