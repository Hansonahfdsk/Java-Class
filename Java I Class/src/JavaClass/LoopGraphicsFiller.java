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

public class LoopGraphicsFiller extends JPanel {
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 590;
	
	public void ncircles(int n, Graphics g) {
		int x = 0, y = 0, diam = 5;
		g.setColor(Color.black);
		for (int i = 0; i < n; i++) {
			g.fillOval(x, y, diam, diam);
			x += 5;
			y += 5;
		}
	}
	public void sbs(Graphics g) {
		int x = 0, y = HEIGHT / 2, diam = 5;
		g.setColor(Color.black);
		for (int i = 0; i < 10; i++) {
			g.fillOval(x, y, diam, diam);
			x += 5;
			if (diam <= 50) {
				diam += 5;
			}
			else {
				diam -= 5;
			}
		}
	}
	public void tenbyten(Graphics g) {
		int x = 0, y = 0, diam = 5;
		g.setColor(Color.black);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				g.fillOval(x, y, diam, diam);
				x += 5;
			}
			y += HEIGHT / 10;
		}
	}
	public void checker(Graphics g) {
		int x = 0, y = 0, len = WIDTH / 10;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				g.fillRect(x, y, len, len);
				x += WIDTH / 10;
			}
			y += WIDTH / 10;
		}
	}
	public void tricirsqu(Graphics g) {
		int x = 0, y = 0, len = 5, shape = 1;
		for (int i = 0; i < 5; i++) {
			if (shape == 1) {
				g.fillTriangle(x, y, len);
				shape = 2;
			}
			if (shape == 2) {
				g.fillOval(x, y, len, len);
				shape = 3;
			}
			if (shape = 3) {
				g.fillRect(x, y, len, len);
				shape = 1;
			}
		}
	}
	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		ncircles(5);
		sbs();
		tenbyten();
		checker();
		tricirsqu();
		
		
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new GraphicsLoops();
	}
 
	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}