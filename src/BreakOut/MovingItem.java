package BreakOut;
import java.awt.Graphics;

public abstract class MovingItem extends GameItem{

	private int vx;
	private int vy;
	
	public MovingItem(int x, int y, int width, int height, int vx, int vy) {
		super(x, y, width, height);
		this.vx = vx;
		this.vy = vy;
	}
	
	public boolean hitTop(GameItem item)
	{
		//if traveling in a positive Y direction and collides with top of an object
		if(this.getY()+this.getHeight()>=item.getY())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean hitLeft(GameItem item)
	{
		if(this.getX()+this.getWidth()>=item.getX())
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	
	
	public boolean hitBottom(GameItem item)
	{
		if(this.getY()<=item.getY()+item.getHeight())
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public boolean hitRight(GameItem item)
	{
		if(this.getX()<=item.getX()+item.getWidth())
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}
	
	public int getVX()
	{
		return vx;
	}
	
	public int getVY()
	{
		return vy;
	}
	
	public void setVX(int vx)
	{
		this.vx = vx;
	}
	
	public void setVY(int vy)
	{
		this.vy = vy;
	}
	
	public abstract void render(Graphics g);
	

}
