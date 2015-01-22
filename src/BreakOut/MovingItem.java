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
