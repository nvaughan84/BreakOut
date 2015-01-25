package BreakOut;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class PlayState extends GameState {

	private Ball ball;
	private Paddle paddle;
	private boolean paddleLeft = false;
	private boolean paddleRight = false;
	private ArrayList<Brick> bricks = new ArrayList<Brick>();
	Game game;
	
	public PlayState(GameStateManager gsm, Game game) {
		super(gsm);
		this.state = State.PLAYING;
		this.game = game;
		this.ball = new Ball(20,40,20,20,3,3, game);
		this.paddle = new Paddle(20, game.getHeight()-60, 50, 10, 0, 0, game);
		layBricks();
	}


	public void update() {
		//Check if the ball collides with bricks or the paddle
		ball.checkBallCollisions(paddle);
		Iterator<Brick> brickList = bricks.iterator();
		while (brickList.hasNext()) {
			if(ball.checkBallCollisions(brickList.next()))
			{
				brickList.remove();
			}
		}
		
		//Move ball based on x/y velocity components
		ball.move(ball.getVX(), ball.getVY());
		//Determine whether the ball is out of bounds. Of so, pop the PlayState from the GSM and add the GameOverState
		if(ball.isOutOfBounds())
		{
			gsm.pop();//if the ball goes out of bounds, remove PlayState			
			gsm.add(new GameOverState(gsm, game)); //add Game Over State to GSM Stack
		}
		//Move paddle based on Key Press
		if(paddleRight){
			paddle.move(5);
		}
		if(paddleLeft)
		{
			paddle.move(-5);
		}
	}
	
	

	
	public void layBricks()
	{
		for(int i = 0; i < 10; i++)
		{
			bricks.add(new Brick(10+30*i,20,30,10));
		}
	}

	@Override
	public void render(Graphics g) {
		ball.render(g);
		paddle.render(g);
		Iterator<Brick> brickList = bricks.iterator();
		while (brickList.hasNext()) {
			brickList.next().render(g);
		}
	}

	@Override
	public void keyPressed(int k) {
		if(k==KeyEvent.VK_RIGHT) //right
		{
			paddleRight = true;
		}
		if(k==KeyEvent.VK_LEFT)//left
		{
			paddleLeft = true;
		}
	}

	@Override
	public void keyReleased(int k) {
		if(k==KeyEvent.VK_RIGHT) //right
		{
			paddleRight = false;
		}
		if(k==KeyEvent.VK_LEFT)//left
		{
			paddleLeft = false;
		}	
		
	}

	@Override
	public void keyTyped(int k) {
		// TODO Auto-generated method stub
		
	}

}
