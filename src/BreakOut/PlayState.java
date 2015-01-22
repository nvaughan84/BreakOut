package BreakOut;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import BreakOut.GameState.State;

public class PlayState extends GameState {

	private Ball ball;
	private Paddle paddle;
	private boolean paddleLeft = false;
	private boolean paddleRight = false;
	
	public PlayState(GameStateManager gsm, Game game) {
		super(gsm);
		this.state = State.PLAYING;
		this.ball = new Ball(20,20,20,20,1,1, game);
		this.paddle = new Paddle(20, game.getHeight()-60, 50, 10, 0, 0, game);
	}

	@Override
	public void update() {
		checkBallCollisions();
		ball.move(ball.getVX(), ball.getVY());
		if(ball.isOutOfBounds())
		{
			gsm.pop();//if the ball goes out of bounds, return to the main menu
			gsm.add(new GameOverState(gsm));
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
			else if(ball.hitBottom(paddle))
			{
				ball.setVY(-1*ball.getVY());
			}
			else if(ball.hitLeft(paddle))
			{
				ball.setVX(-1*ball.getVX());
			}
			else if(ball.hitRight(paddle))
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
