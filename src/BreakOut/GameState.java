package BreakOut;

import java.awt.Graphics;

public abstract class GameState {
	
	GameStateManager gsm;

	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
		
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public abstract void keyTyped(int k);

}
