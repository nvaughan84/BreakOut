package BreakOut;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game extends JPanel implements KeyListener{
	
	GameStateManager gsm = new GameStateManager();
	
		
	public Game() {
		
		createFrame();
		//add menu state to GameStateManager
		gsm.add(new MenuState(gsm));
		
		while(true)
		{
			gsm.update();
			repaint();
			try{
				Thread.sleep(10);
			}
			catch(InterruptedException e)
			{
				
			}
		}
	}
	
	
	public void createFrame()
	{
		JFrame frame = new JFrame("Mini Tennis");
		frame.add(this);
		frame.setSize(200, 200);
		frame.setVisible(true);
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		this.setFocusable(true);	
	}
	
	
	public void paint(Graphics g)
	{
		super.paint(g);	
		//render the current GameState
		gsm.render(g);
	}


	public void keyPressed(KeyEvent k) {
		switch(gsm.getState())
		{
			case MAIN_MENU:
			if(k.getKeyCode()==KeyEvent.VK_ENTER)
			{
				//add the PlayState to the Stack and update enum value
				gsm.add(new PlayState(gsm, this));
			}
			break;
			case PLAYING:
				if(k.getKeyCode()==KeyEvent.VK_P)
				{
					//add the PlayState to the Stack and update enum value
					gsm.add(new PauseState(gsm));
				}
				break;
			case PAUSE:
				if(k.getKeyCode()==KeyEvent.VK_P)
				{
					//add the PlayState to the Stack and update enum value
					gsm.pop();
				}
				break;
		}
		//send input to GameStateManager
		gsm.keyPressed(k.getKeyCode());	
	}

	public void keyReleased(KeyEvent k) {
		gsm.keyReleased(k.getKeyCode());		
	}

	public void keyTyped(KeyEvent k) {
		gsm.keyTyped(k.getKeyCode());	
	}
	

	public static void main(String[] args) {
		new Game();

	}

}
