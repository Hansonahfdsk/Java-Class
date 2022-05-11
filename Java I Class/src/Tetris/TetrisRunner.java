package Tetris;

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

import SpaceInvadersPackage.SpaceInvadersFiller;
import SpaceInvadersPackage.SpaceInvadersFiller.LeftAction;
import SpaceInvadersPackage.SpaceInvadersFiller.LeftReleaseAction;
import SpaceInvadersPackage.SpaceInvadersFiller.PauseAction;
import SpaceInvadersPackage.SpaceInvadersFiller.RightAction;
import SpaceInvadersPackage.SpaceInvadersFiller.RightReleaseAction;
import SpaceInvadersPackage.SpaceInvadersFiller.SpaceAction;

public class TetrisRunner {
	private final int WIDTH = 500, HEIGHT = 700, bWidth = WIDTH / 10, bHeight = HEIGHT / 10;
	
	private Piece board[][] = new Piece[bWidth][bHeight];
	private ArrayList<Piece> next = new ArrayList<Piece>();
	
	private boolean lost = false, won = false;
	private boolean nextPiece;
	public void move() {
		Thread.sleep();
	}
	public void checkCollisions() {
		
	}
	public void setup() {
		
	}
	public void draw() {
		
	}
	
	public TetrisRunner() {
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
		frame.add(canvas);
		frame.setVisible(true);
		
		while (true) {
			move();
			checkCollisions();
			frame.getContentPane().repaint();
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	private class RightAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			// 
		}
	}
	private class LeftAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			//
		}
	}
	private class LeftReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			//
		}
	}
	private class RightReleaseAction extends AbstractAction {
		public void actionPerformed(ActionEvent e) {
			//
		}
	}


	
	public static void main(String[] args) {
		new TetrisRunner();
	}
}
