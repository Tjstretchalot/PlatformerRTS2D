package shooter;

import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.util.HashMap;

import org.lwjgl.Sys;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import shooter.gui.GuiGame;
import shooter.gui.GuiStart;

public class ShooterDisplay extends BasicGame {
	private Gui mGui;
	private static long lastButtonPress;
	private static HashMap<String, Image> resources;
	private static ShooterDisplay application;
	
	public ShooterDisplay() {
		super(ShooterConstants.GAME_NAME);
		mGui = new GuiStart();
	}

	@Override
	public void render(GameContainer arg0, Graphics graphics) throws SlickException {
		mGui.render(graphics, getTime());
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		resources = new HashMap<>();
		resources.put("filler", new Image("resources/filler.png"));
		resources.put("player", new Image("resources/player.png"));
		resources.put("sky", new Image("resources/sky.png"));
	}

	@Override
	public void update(GameContainer arg0, int delta) throws SlickException {
		mGui.update(delta);
	}

	public static void main(String[] args) {
		AppGameContainer container;
		try {
			application = new ShooterDisplay();
			container = new AppGameContainer(application);
			container.setTargetFrameRate(60);
			container.start();
		} catch (SlickException e) {
			Sys.alert(ShooterConstants.GAME_NAME, "Failed to load shooter display.  Make sure your graphics drivers are up to date");
		}
		
	}
	
	/**
	 * Returns the time in milliseconds
	 * @return the time in milliseconds
	 */
	public static long getTime()
	{
		/*
		 * I changed this part
		 */
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	public static Rectangle2D.Float drawCenteredText(Graphics graphics, String text, float y) {
		float width = graphics.getFont().getWidth(text);
		float x = Display.getWidth() / 2 - width / 2;
		return drawText(graphics, text, x, y);
	}

	private static Rectangle2D.Float drawText(Graphics graphics, String text, float x,
			float y) {
		graphics.drawString(text, x, y);
		return new Rectangle2D.Float(x, y, graphics.getFont().getWidth(text), graphics.getFont().getHeight(text));
	}

	/**
	 * Draws a highlightable text and returns if it is currently being
	 * pressed
	 * @param graphics the graphics
	 * @param string the text
	 * @param y y-axis
	 * @return if it is being pressed
	 */
	public static boolean drawHCenteredText(Graphics graphics, String string,
			float y) {
		Rectangle2D.Float size = drawCenteredText(graphics, string, y);
		
		if(size.contains(Mouse.getX(), 480 - Mouse.getY())) {
			drawCenteredText(graphics, string, y); // This has a cool effect.
			if(Mouse.isButtonDown(0) && getTime() - lastButtonPress > 100) // Simple, but effective
			{
				lastButtonPress = getTime();
				return true;
			}
		}
		return false;
	}

	public static Image getImage(String string) {
		return resources.get(string);
	}

	public static ShooterDisplay getApp() {
		return application;
	}

	public void setGui(GuiGame gui) {
		mGui = gui;
	}
}
