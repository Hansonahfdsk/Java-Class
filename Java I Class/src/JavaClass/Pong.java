// filler code for pong provided by Mr. David
package JavaClass;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1500, HEIGHT = 1000, WINDOW_HEIGHT = 1050;
	private final int PADDLE_WIDTH = 20, DIAM = 30, PADDLE_HEIGHT = 100;
	private final int PADDLE_SPEED = 4;
	private int ballX = WIDTH / 2, ballY = HEIGHT / 2, paddleX1 = 0, paddleX2 = WIDTH - PADDLE_WIDTH, paddleY1 = 0, paddleY2 = 0, ballSpeedX = 5, ballSpeedY = -5, paddleSpeed = 5;

	
	// your instance variables here, I've given you a few 
	private boolean up1 = false, down1 = false, up2 = false, down2 = false; 		// booleans to keep track of paddle movement
	private boolean solo = false, dangerBall = false;
	private int p1Score = 0, p2Score = 0;
	
	// this method moves the ball at each timestep
	public void move_ball() {
		
		ballX += ballSpeedX;
		ballY += ballSpeedY;
		
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (up1 == true) {
			paddleY1 -= paddleSpeed;
		}
		if (down1 == true) {
			paddleY1 += paddleSpeed;
		}
//		Checks if it is 1 player or 2 player mode, if 1, then can't move the other paddle.
		if (solo == false) {
			if (up2 == true) {
				paddleY2 -= paddleSpeed;
			}
			if (down2 == true) {
				paddleY2 += paddleSpeed;
			}
		}
		else {
			if (ballY >= paddleY2) {
				paddleY2 += paddleSpeed;
			}
			else {
				paddleY2 -= paddleSpeed;
			}
		}
//		Limit the paddles on screen
		if (paddleY1 < 0) {
			paddleY1 = 0;
		}
		if (paddleY2 < 0) {
			paddleY2 = 0;
		}
		if (paddleY1 > HEIGHT - PADDLE_HEIGHT) {
			paddleY1 = HEIGHT - PADDLE_HEIGHT;
		}
		if (paddleY2 > HEIGHT - PADDLE_HEIGHT) {
			paddleY2 = HEIGHT - PADDLE_HEIGHT;
		}
	}
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
//		Checks if the ball is going out of the screen vertically
		if (ballY >= HEIGHT || ballY <= 0) {
			ballSpeedY *= -1;
		}
//		Checks if the ball bounces on the paddles
		if (ballY >= paddleY1 && ballY <= paddleY1 + PADDLE_HEIGHT && ballX >= paddleX1 && ballX <= paddleX1 + PADDLE_WIDTH) {
			ballSpeedX *= -1.2;
//			If dangerball is active when the paddle touches the ball, minus a point
			if (dangerBall == true) {
				p1Score --;
				ballX = WIDTH / 2; ballY = HEIGHT / 2;
				dangerBall = false;
			}
		}
		if (ballY >= paddleY2 && ballY <= paddleY2 + PADDLE_HEIGHT && ballX >= paddleX2 - PADDLE_WIDTH && ballX <= paddleX2 + PADDLE_WIDTH) {
			ballSpeedX *= -1.2;
			if (dangerBall == true) {
				p2Score --;
				ballX = WIDTH / 2; ballY = HEIGHT / 2;
				dangerBall = false;
			}
		}
//		Checks if the balls are out of right or left bounds and add score
		if (ballX > WIDTH) {
			ballX = WIDTH / 2;
			ballY = HEIGHT / 2;
			ballSpeedX = 5;
			p1Score++;
		}
		if (ballX < 0) {
			ballX = WIDTH / 2;
			ballY = HEIGHT / 2;
			ballSpeedX = 5;
			p2Score++;
		}
//		Checks if the ball hits the red ball that turns it into dangerball
		if (ballX >= WIDTH / 2 && ballX <= WIDTH / 2 + DIAM && ballY >= HEIGHT / 3 && ballY <= HEIGHT / 3 + DIAM) {
			dangerBall = true;
		}
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is white, but if dangerball change to yellow
		if (dangerBall == true) {
			g.setColor(Color.yellow);
		}
		else {
			g.setColor(Color.white);
		}
		g.fillRect(0, 0, WIDTH, HEIGHT);
		

		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
//		if ball is dangerball then change color of the paddles
		if (dangerBall == true) {
			g.setColor(Color.red);
		}
		else {
			g.setColor(Color.black);
		}
		g.drawString(("P1 Score: " + p1Score), WIDTH/5, 20);
//		Checks whether it is pvp or pve
		if (solo == false) {
			g.drawString(("P2 Score: " + p2Score), WIDTH*3/5, 20);
		}
		else {
			g.drawString(("Computer Score: " + p2Score), WIDTH*3/5, 20);
		}
		g.fillRect(paddleX1, paddleY1, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(paddleX2, paddleY2, PADDLE_WIDTH, PADDLE_HEIGHT);
//		Changes the ball's color when dangerball
		if (dangerBall == true) {
			g.setColor(Color.red);
		}
		else {
			g.setColor(Color.blue);
		}
		g.fillOval(ballX, ballY, DIAM, DIAM);
		g.setColor(Color.red);
		g.fillOval(WIDTH / 2, HEIGHT / 3, DIAM, DIAM);
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) {
			down2 = true;
		}
		
		if (keyCode == KeyEvent.VK_UP) {
			up2 = true;
		}

		if (e.getKeyChar() == 'w') {
			up1 = true;
		}
		
		if (e.getKeyChar() =='s') {
			down1 = true;
		}
			
		// turn 1-player mode on
		if (e.getKeyChar() == '1'){
			solo = true;
		}
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2'){
			solo = false;
		}
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) {
			up2 = false;
		}

		if (keyCode == KeyEvent.VK_DOWN) {
			down2 = false;
		}
  
		if(e.getKeyChar() == 'w') {
			up1 = false;
		}
		
		if (e.getKeyChar() == 's'){
			down1 = false;
		}
	}
	
	// restarts the game, including scores
	public void restart() {
		p1Score = 0; p2Score = 0;
		ballX = WIDTH / 2; ballY = HEIGHT / 2;
		ballSpeedX = 5; ballSpeedY = -5;
		paddleY1 = 0; paddleY2 = 0;
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}