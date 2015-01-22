package BreakOut;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Ball extends MovingItem{

	private Game game;
	private boolean outOfBounds = false;

	public Ball(int x, int y, int width, int height, int vx, int vy, Game game) {
		super(x, y, width, height, vx, vy);
		this.game = game;
	}
	
	public void render(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.RED);
		g2d.fillOval(this.getX(), this.getY(), this.getWidth(), this.getHeight());
	}
	
	public void move(int vx, int vy)
	{
		//check if the ball hits the walls
		if(this.getY()+this.getHeight()>=game.getHeight())
		{
			this.setVY(-vy);//reverse direction of y-velocity component
			this.outOfBounds = true;
		}
		if(this.getY()<=0)
		{
			this.setVY(-vy);//reverse direction of y-velocity component
		}
		if(this.getX()<=0)
		{
			this.setVX(-vx);//reverse direction of y-velocity component
		}
		if(this.getX()+this.getWidth()>=game.getWidth())
		{
			this.setVX(-vx);//reverse direction of y-velocity component
		}
		
		this.setX(this.getX()+this.getVX());
		this.setY(this.getY()+this.getVY());		
	}
	public boolean isOutOfBounds()
	{
		return outOfBounds;
	}
	
	

}
