package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PauseState extends GameState{

	public PauseState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;	
		g2d.setColor(Color.RED);
		g2d.drawString("PAUSED",70,20);		
		g2d.drawString("Press 'P' to Resume",40,60);
		
	}

	@Override
	public void keyPressed(int k) {
		
	}

	@Override
	public void keyReleased(int k) {
		
	}

	@Override
	public void keyTyped(int k) {
		
	}

}
