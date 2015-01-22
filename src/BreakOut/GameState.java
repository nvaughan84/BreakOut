package BreakOut;

import java.awt.Graphics;

public abstract class GameState {
	
	GameStateManager gsm;
	
	//all possible states
	public enum State{
		MAIN_MENU, PLAYING, PAUSE, GAME_OVER
	}
	
	State state;
	

	public GameState(GameStateManager gsm) {
		this.gsm = gsm;
	}
	
	public State getState()
	{
		return state;
	}
		
	public abstract void update();
	public abstract void render(Graphics g);
	public abstract void keyPressed(int k);
	public abstract void keyReleased(int k);
	public abstract void keyTyped(int k);

}
