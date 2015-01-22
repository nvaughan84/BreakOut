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
		if(this.getVY()>0 && (this.getY()+this.getHeight())>=item.getY())
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
		System.out.println(this.getVX()>0 && (this.getX()+this.getWidth())>=item.getX());
		//if traveling in a positive Y direction and collides with top of an object
		if(this.getVX()>0 && (this.getX()+this.getWidth())>=item.getX())
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
