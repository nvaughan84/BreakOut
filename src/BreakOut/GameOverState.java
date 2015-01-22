package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class GameOverState extends GameState {

	public GameOverState(GameStateManager gsm) {
		super(gsm);
		this.state = State.GAME_OVER;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		g2d.setColor(Color.RED);
		g2d.drawString("GAME OVER",70,20);			
		g2d.drawString("Press Enter to Start",40,60);
		
	}

	@Override
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_ENTER) 
		{
			gsm.pop();
		}
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
