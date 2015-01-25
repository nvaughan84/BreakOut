package BreakOut;

import javax.swing.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements KeyListener{
	
	GameStateManager gsm = new GameStateManager();
	BufferStrategy strategy;
	
	long lastLoopTime = System.nanoTime();
	final int TARGET_FPS = 60;
	final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
		
	public Game() {
		
		//add menu state to GameStateManager
		gsm.add(new MenuState(gsm, this));
		createFrame();
		
		while(true){
		    Thread t = new Thread(new Runnable(){
		         public void run() {
		            gsm.update(); //say it takes 1 min
		         }
		    });
		    t.start();
		    draw();
		}
		
		
//		while(true)
//		{
//			long now = System.nanoTime();
//		      long updateLength = now - lastLoopTime;
//		      lastLoopTime = now;
//		      double delta = updateLength / ((double)OPTIMAL_TIME);
//
//		      System.out.println(delta);
//			
//			
//			gsm.update();
//			draw();
//			//render();
//			try{
//				Thread.sleep(10);
//			}
//			catch(InterruptedException e)
//			{
//				
//			}
//		}
	}
	
	
	public void createFrame()
	{
		JFrame frame = new JFrame("Mini Tennis");
		//frame.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400,400));
		frame.add(this);		
		frame.pack();		
		frame.setBackground(Color.BLACK);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		this.setFocusable(true);
		frame.createBufferStrategy(2);
		strategy = frame.getBufferStrategy();
		frame.setVisible(true);
		System.out.println(frame.getInsets());
	}
	
		
//	public void paint(Graphics g)
//	{
//		//Graphics g = strategy.getDrawGraphics();
//		super.paint(g);
//		gsm.render(g);
//		g.dispose();
//		strategy.show();
//	}
//	
	public void draw(){
		   BufferStrategy bs = getBufferStrategy();
		   if (bs== null){
		   createBufferStrategy(2);
		   return;
		   }

		   Graphics g = bs.getDrawGraphics();
		   super.paint(g);
		   gsm.render(g);
		   g.dispose();
		   bs.show();
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
					gsm.pop();
				}
				break;
			case GAME_OVER:
				if(k.getKeyCode()==KeyEvent.VK_ENTER)
				{					
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
