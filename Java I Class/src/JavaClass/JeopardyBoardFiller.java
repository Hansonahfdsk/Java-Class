package JavaClass;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JeopardyBoardFiller {
	
	private int gridWidth = 800, gridHeight = 600, textHeight = 50; //Variables to create window
	
	private final int NUMQUESTIONS = 5, NUMCATEGORIES = 6; //Variables for the number of columns and rows
	
	private int score = 0; //Variable for score
		
	private int colorx = -1, colory = -1; //Variable for setting the color of the rectangle that gets print at (colorx, colory)
	
	public void draw(Graphics g) {
		int rectWidth = gridWidth / NUMCATEGORIES, rectHeight = gridHeight / NUMQUESTIONS; //Variables for the length and width of each rectangle just to make following lines shorter
		for (int i = 0; i < NUMCATEGORIES; i++) {
			for (int j = 0; j < NUMQUESTIONS; j++) { //Two nested loop to go through all the rectangles to be print
				int score = (j + 1) * 100; //Set the current block's score
				g.setColor(Color.CYAN); //Set the rectangle's color to be cyan
				if (colorx == i && colory == j) {
					g.setColor(Color.RED); //If this square is clicked, change the color to red
				}
				g.fillRect(i * rectWidth, j * rectHeight, rectWidth, rectHeight); //Fill in the rectangle
				g.setColor(Color.WHITE);
				g.drawRect(i * rectWidth, j * rectHeight, rectWidth, rectHeight); //Draw a box around the rectangle
				Font f = new Font("Arial", Font.BOLD, 14);
				g.setFont(f);
				g.drawString(" " + score, i * rectWidth + rectWidth / 3, j * rectHeight + rectHeight / 2); //Write the score

			}
		}
	}
	
	public void click(int mouseX, int mouseY) {
		int rectWidth = gridWidth / NUMCATEGORIES, rectHeight = gridHeight / NUMQUESTIONS;
		for (int i = 0; i < NUMCATEGORIES; i++) {
			for (int j = 0; j < NUMQUESTIONS; j++) {
				if (mouseX >= i * rectWidth && mouseX <= (i + 1) * rectWidth && mouseY >= j * rectHeight && mouseY <= (j + 1) * rectHeight) { //Check which rectangle the mouse clicked in
					score += (j + 1) * 100; //Add score if clicked
					colorx = i; //Change the x and y coordinates of the rectangle that need color change
					colory = j;
				}
			}
		}
	}
	
	
	// DO NOT TOUCH BELOW CODE //
	
	public JeopardyBoardFiller() {
		
		JFrame window = new JFrame();
		window.setTitle("Jeopardy!");
		window.setSize(gridWidth, gridHeight + textHeight);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		
		JTextArea scoreDisplay = new JTextArea();
		scoreDisplay.setEditable(false);
		scoreDisplay.setText("\t\tScore: 0");
		
		JPanel canvas = new JPanel() {
			public void paint(Graphics g) {
				gridWidth = window.getWidth();
				gridHeight = window.getHeight() - textHeight;
				draw(g);
			}
		};
		canvas.setPreferredSize(new Dimension(gridWidth, gridHeight));
		
		canvas.addMouseListener(new MouseListener() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				click(e.getX(), e.getY());
				scoreDisplay.setText("\t\tScore: " + score);
				window.getContentPane().repaint();
			}

			@Override
			public void mouseClicked(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
		
		container.add(canvas);
		container.add(scoreDisplay);
		window.add(container);
		window.setVisible(true);
	}
	
	public static void main(String[] args) {
		new JeopardyBoardFiller();
	}

}
