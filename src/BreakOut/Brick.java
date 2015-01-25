package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Brick extends GameItem	{

	public Brick(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	

}
