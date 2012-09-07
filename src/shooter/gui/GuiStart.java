package shooter.gui;

import static shooter.ShooterConstants.START_MENU_OPTIONS;

import org.newdawn.slick.Graphics;

import shooter.Gui;
import shooter.ShooterDisplay;
import shooter.game.World;

public class GuiStart implements Gui {
	public GuiStart() {
		
	}
	
	@Override
	public void render(Graphics graphics, long time) {
		float y = 150;
		for(int i = 0; i < START_MENU_OPTIONS.length; i++) {
			boolean pressed = ShooterDisplay.drawHCenteredText(graphics, START_MENU_OPTIONS[i], y);
			
			if(pressed) {
				onPressed(i); 
			}
			
			y += 50f;
		}
	}

	@Override
	public void update(long delta) {
		// TODO Auto-generated method stub

	}
	
	private void onPressed(int i) {
		System.out.println(START_MENU_OPTIONS[i] + " was pressed.");
		
		switch(START_MENU_OPTIONS[i]) {
		case "Begin New Game":
			World world = World.createNewWorld();
			GuiGame gui = new GuiGame(world);
			ShooterDisplay.getApp().setGui(gui);
			break;
		case "Continue Old Game":
			break;
		case "Credits":
			break;
		default:
			System.err.println("Invalid option selected");
			break;
		}
	}

}
