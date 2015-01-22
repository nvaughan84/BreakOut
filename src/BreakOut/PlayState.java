package BreakOut;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class PlayState extends GameState {

	private Ball ball;
	private Paddle paddle;
	private boolean paddleLeft = false;
	private boolean paddleRight = false;
	
	public PlayState(GameStateManager gsm, Game game) {
		super(gsm);
		
		this.ball = new Ball(20,20,20,20,1,1, game);
		this.paddle = new Paddle(20, game.getHeight()-20, 30, 10, 0, 0, game);
	}

	@Override
	public void update() {
		
		ball.move(ball.getVX(), ball.getVY());
		if(ball.isOutOfBounds())
		{
		}
		if(paddleRight){
			paddle.move(5);
		}
		if(paddleLeft)
		{
			paddle.move(-5);
		}
	}
	
	public void checkBallCollisions()
	{
		//collides with paddle
		if(ball.collision(paddle))
		{
			if(ball.hitTop(paddle))
			{
				ball.setVY(-1*ball.getVY());
			}
			if(ball.hitLeft(paddle))
			{
				ball.setVX(-1*ball.getVX());
			}
			
		}
	}

	@Override
	public void render(Graphics g) {
		ball.render(g);
		paddle.render(g);
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
