package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Paddle extends MovingItem{

	private Game game;
	
	public Paddle(int x, int y, int width, int height, int vx, int vy, Game game) {
		super(x, y, width, height, vx, vy);
		this.game = game;
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	public void move(int vx)
	{		
		this.setX(this.getX()+vx);
		
		//if paddle goes out of bounds, reset x position
		if(this.getX()<0)
		{
			this.setX(0);
		}
		if(this.getX()+this.getWidth()>game.getWidth())
		{
			this.setX(game.getWidth()-this.getWidth());
		}
	}

}
