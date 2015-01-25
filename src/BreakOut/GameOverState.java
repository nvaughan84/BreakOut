package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState {
	
	Game game;

	public GameOverState(GameStateManager gsm, Game game) {
		super(gsm);
		this.state = State.GAME_OVER;
		this.game = game;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		g2d.setColor(Color.RED);
		g2d.drawString("GAME OVER",(int)game.getWidth()/2-70,20);			
		g2d.drawString("Press Enter to return to Menu",(int)game.getWidth()/2-120,60);
		
	}

	@Override
	public void keyPressed(int k) {		
	}

	@Override
	public void keyReleased(int k) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(int k) {
		// TODO Auto-generated method stub
		
	}
	

}
