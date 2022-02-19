package Inheritance;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class ShapeRunner {
	
	private Shape[] shapes;
	
	// this method should move all the shapes in the list
	public void moveShapes() {
		for (int i = 0; i <= 2; i++) {
			shapes[i].move(50, 50);
		}
		// your code here
	}
	
	// fill in your shape list here
	public void setup() {
		shapes[0] = new Rect(100, 200);
		shapes[1] = new Oval(300, 400);
		shapes[2] = new Line(500, 400);
		// your code here
	}
	
	// DON'T TOUCH BELOW CODE
	
	public void run() {
		while (true ) {
			moveShapes();
			frame.repaint();
			try {
				Thread.sleep(75);
			} catch (Exception ex) {}
		}
	}
	
	public static void main(String[] args) {
		new ShapeRunner(); 
	}
	private JFrame frame;
	public ShapeRunner() {
		setup();
		frame = new JFrame() {
			public void paint(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, 600, 600);
				
				for (Shape s: shapes)
					s.draw(g);
			}
		};
		frame.setSize(600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		run();
	}
}