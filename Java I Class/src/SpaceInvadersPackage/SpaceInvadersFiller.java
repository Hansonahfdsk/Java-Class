package SpaceInvadersPackage;

// Space Invaders Filler Code by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class SpaceInvadersFiller {
	
	// constants for various aspects of the game
	// feel free to change them to make the game harder/easier
	private final int WIDTH = 1000, HEIGHT = 700, NUMALIENS = 20, ALIENSPEED = 4, LASERSPEED = 7, PLAYERSPEED = 6,
			LASERWIDTH = 8, LASERHEIGHT = 25, PLAYERENEMYWIDTH = 50, PLAYERENEMYHEIGHT = 35, POWERUPWIDTH = 20, POWERUPHEIGHT = 20;
	
	// determines the difficulty. The closer to 1.0, the easier the game 
	private final double DIFFICULTY = .99;
	
	// our list of aliens
	private ArrayList<SpaceThing> aliens = new ArrayList<SpaceThing>();
	
	// our list of list of lasers for both the player and the aliens
	private ArrayList<Laser> alienLasers = new ArrayList<Laser>();
	private ArrayList<Laser> playerLasers = new ArrayList<Laser>();
	
	// the shield and boost variable and booleans to see if they are active
	// EXTRA FEATURE: powerups
	// the shield powerup is a green square that when activated "player touches" gives the player a shield that blocks one laser
	// the attack boost powerup is a blue square that when activated removes the cap of lasers on the screen and lets the player fire two lasers at once with space. After several shots the powerup will deactivate
	private Shield s;
	private boolean shield = false;
	private AtkBoost ab;
	private boolean atkboost = false;
	private int shots = 0;
	
	// the player
	private SpaceThing player;
	
	// the current speed of the player as well as their remaining lives
	private int lives = 3, playerSpeed = 0;
	
	// booleans to keep track of the game's progress
	private boolean lost = false, paused = true;
	private boolean won = false;
	
	
	// move the aliens, the lasers, and the player. Loops aliens when necessary, 
	// and randomly shoots lasers from the aliens
	public void move() {
		//if the game is either won or lost we don't want the move method to do anything
		if (lost || won) {
			return;
		}
		//moves the player by speed
		player.moveX(playerSpeed);
		//if the player reaches the right edge of the screen the ship teleports to the left, vice versa.
		if(player.x > WIDTH) {
			player.x = 0;
		}
		if (player.x < 0) {
			player.x = WIDTH;
		}
		//moves the player lasers up the screen, thus -LASERSPEED
		for (int i = 0; i < playerLasers.size(); i++) {
			playerLasers.get(i).moveY(-LASERSPEED);
		}
		//moves the aliens to the right, if an alien is at the right edge of the screen it teleports to the left and down.
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).moveX(ALIENSPEED);
			if (aliens.get(i).x > WIDTH) {
				aliens.get(i).x = 0;
				aliens.get(i).y += PLAYERENEMYHEIGHT * 1.5;
			}
			//determines the amount of lasers that aliens are going to shoot based on DIFFICULTY
			if (Math.random() > DIFFICULTY) {
				alienLasers.add(new Laser(aliens.get(i).x + PLAYERENEMYWIDTH / 2, aliens.get(i).y + PLAYERENEMYHEIGHT / 2, LASERWIDTH, LASERHEIGHT));
			}
		}
		//moves the alien lasers down the screen
		for (int i = 0; i < alienLasers.size(); i++) {
			alienLasers.get(i).moveY(LASERSPEED);
		}
		//check if the game is lost
		if (lives == 0) {
			lost = true;
		}
		//check if all aliens are dead, thus player won
		if (aliens.size() == 0) {
			won = true;
		}
	}
	
	// check for collisions between alien lasers and the player
	// and between player lasers and the aliens
	// check if the aliens have reached the ground
	public void checkCollisions() {
		// your code here
		// we also don't want collision to run if either lost or won
		if (lost || won) {
			return;
		}
		//checks if alien lasers hits the player, if the player has a shield active, the shield is broken, else a life is lost
		for (int i = 0; i < alienLasers.size(); i++) {
			if (player.intersects(alienLasers.get(i))) {
				alienLasers.remove(i);
				i--;
				if (shield) {
					shield = false;
				}
				else {
					lives--;
				}
			}
		}
		//if alien get hit by player laser it disappears
		for (int i = 0; i < aliens.size(); i++) {
			for (int j = 0; j < playerLasers.size(); j++) {
				if (aliens.get(i).intersects(playerLasers.get(j))) {
					aliens.remove(i);
					playerLasers.remove(j);
					i--;
					break;
				}
			}
		}
		//if alien laser and player laser hit both disappears
		for (int i = 0; i < alienLasers.size(); i++) {
			for (int j = 0; j < playerLasers.size(); j++) {
				if (alienLasers.get(i).intersects(playerLasers.get(j))) {
					alienLasers.remove(i);
					playerLasers.remove(j);
					i--;
					break;
				}
			}
		}
		//if aliens went past the bottom of the screen the player lost
		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).y > HEIGHT) {
				lost = true;
			}
		}
		//if player laser went past the top of the screen remove the laser
		for (int i = 0; i < playerLasers.size(); i++) {
			if(playerLasers.get(i).y < 0) {
				playerLasers.remove(i);
			}
		}
		//checks if the player hits the two powerup squares
		if (s != null && player.intersects(s) ) {
			shield = true;
			s = null;
		}
		if (ab != null && player.intersects(ab)) {
			atkboost = true;
			ab = null;
		}
	}
	
	// set up your variables, lists, etc here
	public void setup() {
		// sets up the position of the aliens, iterate through the x pixels and if x is too large go down and continue
		int currX = 50;
		int currY = 30;
		for (int i = 0; i < NUMALIENS; i++) {
			if(currX > WIDTH - PLAYERENEMYWIDTH - 50) {
				currX = 50;
				currY += PLAYERENEMYHEIGHT * 1.5;
			}
			aliens.add(i, new SpaceThing(currX, currY, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "alien.png"));
			currX += PLAYERENEMYWIDTH * 1.3;
		}
		// sets up the powerup square spawn chance
		if(Math.random() < 0.5) {
			s = new Shield((int)(Math.random() * WIDTH - POWERUPWIDTH), HEIGHT * 5 / 6, POWERUPWIDTH, POWERUPHEIGHT);
		}
		if (Math.random() < 0.5) {
			ab = new AtkBoost((int)(Math.random() * WIDTH - POWERUPWIDTH), HEIGHT * 5 / 6, POWERUPWIDTH, POWERUPHEIGHT);
		}
		// sets up the player
		player = new SpaceThing(WIDTH / 2 - PLAYERENEMYWIDTH / 2, HEIGHT * 5 / 6, PLAYERENEMYWIDTH, PLAYERENEMYHEIGHT, "playerCannon.jpg");
	}
	
	// fires a player laser. if there are currently less than 4 lasers on the screen,
	// adds to the list. if there are 4 lasers on the screen, removes a laser and 
	// replaces it with this new one
	public void fireLaser() {
		// your code here
		//if boost is active the player shoots two lasers at once, counts the number of empowered shots
		if (atkboost) {
			playerLasers.add(new Laser(player.x, player.y, LASERWIDTH, LASERHEIGHT));
			playerLasers.add(new Laser(player.x + PLAYERENEMYWIDTH - LASERWIDTH, player.y, LASERWIDTH, LASERHEIGHT));
			shots++;
		}
		//if boost is not active shoot one laser
		else {
			playerLasers.add(new Laser(player.x + PLAYERENEMYWIDTH / 2 - LASERWIDTH / 2, player.y, LASERWIDTH, LASERHEIGHT));
		}
		//sets the limit of lasers on screen to 4 only if boost is not active
		if (playerLasers.size() > 4 && !atkboost) {
			playerLasers.remove(playerLasers.size() - 1);
		}
		//if 10 empowered shots are reached the boost deactivates
		if(shots > 10) {
			atkboost = false;
			shots = 0;
		}
	}
	
	// draw a black background along with your lasers, aliens, and player here
	public void draw(Graphics g) {
		//draw the background
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		//draws the aliens, alien lasers, player lasers and the player
		for(SpaceThing alien: aliens) {
			alien.draw(g);
		}
		for (Laser alienLaser: alienLasers) {
			alienLaser.draw(g);
		}
		for (Laser playerLaser: playerLasers) {
			playerLaser.draw(g);
		}
		player.draw(g);
		
		g.setColor(Color.red);
		g.drawString("Lives: "+lives, 15, 15);
		
		//if boost is not null, draw it on screen
		if (s != null) {
			s.draw(g);
		}
		if (ab != null) {
			ab.draw(g);
		}
		//if won or lost writes the results in the middle of screen
		if (lost) 
			g.drawString("You lose", WIDTH/2-25, HEIGHT/2);
		if (won) 
			g.drawString("You win!", WIDTH/2-25, HEIGHT/2);
	}
	
	// ******* DON'T TOUCH BELOW CODE ************//
	
	public SpaceInvadersFiller() {
		setup();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {draw(g);}
		};
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "Left");
		canvas.getActionMap().put("Left", new LeftAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "LeftRelease");
		canvas.getActionMap().put("LeftRelease", new LeftReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), " ");
		canvas.getActionMap().put(" ", new SpaceAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "Right");
		canvas.getActionMap().put("Right", new RightAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "RightRelease");
		canvas.getActionMap().put("RightRelease", new RightReleaseAction());
		canvas.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0, false), "Pause");
		canvas.getActionMap().put("Pause", new PauseAction());
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			if (!paused) {
				move();
				checkCollisions();
				frame.getContentPane().repaint();
			}
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = PLAYERSPEED;
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = -PLAYERSPEED;
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			playerSpeed = 0;
		}
	}
	private class SpaceAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			fireLaser();
		}
	}
	private class PauseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			paused = !paused;
		}
	}
	
	public static void main(String[] args) {
		new SpaceInvadersFiller();
	}
}
