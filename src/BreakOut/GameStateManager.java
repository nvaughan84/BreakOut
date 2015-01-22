package BreakOut;

import java.awt.Graphics;
import java.util.Stack;

public class GameStateManager {

	private Stack<GameState> states = new Stack<GameState>();
	
	public GameStateManager() {
		
	}
	
	public Stack<GameState> getStates()
	{
		return states;
	}
	
	public void render(Graphics g)
	{
		states.peek().render(g);
	}
	
	public void update()
	{
		states.peek().update();
	}
	
	public void keyPressed(int k)
	{
		states.peek().keyPressed(k);
	}
	
	public void keyReleased(int k)
	{
		states.peek().keyReleased(k);
	}
	
	public void keyTyped(int k)
	{
		states.peek().keyTyped(k);
	}
	
	public void add(GameState gs)
	{
		states.add(gs);
	}
	
	public void pop()
	{
		states.pop();
	}
	
	public void push(GameState gs)
	{
		states.push(gs);
	}

}
