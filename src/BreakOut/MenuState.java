package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuState extends GameState {
	
	Game game;

	public MenuState(GameStateManager gsm, Game game) {
		super(gsm);
		//set State
		this.state = State.MAIN_MENU;
		this.game = game;
	}

	public void update() {		
	}

	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		g2d.setColor(Color.RED);
		g2d.drawString("Super Bricks", (int)game.getWidth()/2-50,20);			
		g2d.drawString("Press Enter to Start", (int)game.getWidth()/2-70,60);
	}

	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER) 
		{
			
		}		
	}

	public void keyReleased(int k) {
		
	}

	public void keyTyped(int k) {
		
	}
	

}
