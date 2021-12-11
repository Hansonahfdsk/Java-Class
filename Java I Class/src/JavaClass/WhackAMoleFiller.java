package JavaClass;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
public class WhackAMoleFiller {
	// My extra feature is that some of the animals that pop out of the dirt are snakes
	// if the player clicks on them, they lose a point instead.

	// size of the display area
    private int windowWidth = 800, windowHeight = 600, textHeight = 35; 
    // image names
    private Image moleImg, bgImg, dirtImg, snakeImg;

    // constants for the number of moles, number of moles appearing at a time, and the 
    // time gap between new moles popping up (in milliseconds), the height and width of the moles and the dirt
    private final int NUMMOLES = 5, NUMAPPEARING = 2, TIMESTEP = 2000, MOLEHEIGHT = 100, MOLEWIDTH = 75, DIRTHEIGHT = 30, DIRTWIDTH = 100;
    
    //the locations of the moles
    private int[] x = new int[NUMMOLES], y = new int[NUMMOLES];
    // which moles are showing and also how long they've been on the screen
    private int[] showing = new int[NUMMOLES];
    // which "moles" are snakes instead
    private boolean[] snake = new boolean[NUMMOLES];
    // score variable
    private int score = 0;
    
    // some initial variable setup
    public void setup() {
    	
    	// loads your 3 images - all you need to do is match file names.
		moleImg = Toolkit.getDefaultToolkit().getImage("diglett.png");
		bgImg = Toolkit.getDefaultToolkit().getImage("background.png");
		dirtImg = Toolkit.getDefaultToolkit().getImage("dirt.png");
		snakeImg = Toolkit.getDefaultToolkit().getImage("snake.png");
		// your code here
		// set every mole to not show and everything to snakes
	    for (int i = 0; i < NUMMOLES; i++) {
	    	showing[i] = -1;
	    	snake[i] = true;
	    }
	    // randomize some of the snakes to moles
	    for (int i = 0; i < NUMMOLES; i++) {
	    	if (Math.random() * 10 >= 3) {
	    		snake[i] = false;
	    	}
	    }
	    // randomize the dirt locations and where the animals are going to come out
		for (int i = 0; i < NUMMOLES; i++) {
			int posx, posy;
			posx = (int)(Math.random() * (windowWidth - DIRTWIDTH));
			posy = (int)(windowHeight * 1 / 2 + Math.random() * (windowHeight * 1 / 2 - MOLEHEIGHT - DIRTHEIGHT));
			x[i] = posx;
			y[i] = posy;
		}
    }

    public void draw(Graphics g) {
    	
    	// draws the background image at 0,0 with a size that will cover 
    	// the entire display window
        g.drawImage(bgImg, 0, 0, windowWidth, windowHeight, null);
        // your code here
        // draw the moles/snakes
        for (int i = 0; i < NUMMOLES; i++) {
        	// identifies if an animal should pop up here
        	if (showing[i] >= 0) {
        		// identify if the animal is a mole or a snake and draw accodingly
        		if (snake[i]) {
        			g.drawImage(snakeImg, x[i], y[i], MOLEWIDTH, MOLEHEIGHT, null);
        		}
        		else {
        			g.drawImage(moleImg, x[i], y[i], MOLEWIDTH, MOLEHEIGHT, null);
        		}
        	}
        	// draws the dirt
        	g.drawImage(dirtImg, x[i] - 10, y[i] + 90, DIRTWIDTH, DIRTHEIGHT, null);
        }
    }


    // what you want to happen when the mouse is clicked
    public void click(int mouseX, int mouseY) {
    	// going through every x and y location in the x and y arrays
    	for (int i = 0; i < NUMMOLES; i++) {
    		// checks if the animal is out of the dirt
    		if (showing[i] >= 0) {
    			// checks collisions between the mouse and if it is on the animal
    			if (mouseX >= x[i] && mouseX <= x[i] + MOLEWIDTH && mouseY >= y[i] && mouseY <= y[i] + MOLEHEIGHT) {
    				// if the animal clicked is a snake minus points
    				if (snake[i]) {
    					score--;
    				}
    				// if animal is not a snake plus points
    				else {
        				score++;
    				}
    				// after the animal is clicked it goes back in the dirt
    				showing[i] = -1;
    			}
    		}
    	}
    }
    
    // what you want to happen when the time for the current round ends
    public void timeAdvance() {
    	for (int i = 0; i < NUMMOLES; i++) {
    		// randomizes which animals are showing
        	if (showing[i] == -1) {
        		if (Math.random() * 20 >= 10) {
        			showing[i] = 0;
        		}
        	}
        	// counts the time the animal has been above the dirt, if it exceeds a certain time, it disappears
        	else {
        		showing[i]++;
        		if (showing[i] >= 3) {
        			showing[i] = -1;
        		}
        	}
        }
    }
    
    // reset the game
    public void reset() {
    	// set every animal to not showing
	    for (int i = 0; i < NUMMOLES; i++) {
	    	showing[i] = -1;
	    }
	    // randomize the locations of the holes(dirt) and where the animals appear after reset
		for (int i = 0; i < NUMMOLES; i++) {
			int posx, posy;
			posx = (int)(Math.random() * (windowWidth - DIRTWIDTH));
			posy = (int)(windowHeight * 1 / 2 + Math.random() * (windowHeight * 1 / 2 - MOLEHEIGHT - DIRTHEIGHT));
			x[i] = posx;
			y[i] = posy;
		}
		// set the score back to 0
		score = 0;
    }


    // DO NOT TOUCH BELOW CODE //

    public WhackAMoleFiller() {
    	
    	setup();

        JFrame window = new JFrame();
        window.setTitle("Whack A Mole");
        window.setSize(windowWidth, windowHeight + textHeight);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JTextArea scoreDisplay = new JTextArea();
        scoreDisplay.setEditable(false);
        scoreDisplay.setText("\t\tScore: 0");
        
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				reset();
			}
        });
        
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
        topPanel.add(resetButton);
        scoreDisplay.setBackground(topPanel.getBackground());
        
        topPanel.add(scoreDisplay);

        

        JPanel canvas = new JPanel() {
            public void paint(Graphics g) {
                draw(g);
            }
        };
        canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));

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
        
        window.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent componentEvent) {
                windowWidth = window.getWidth();
                windowHeight = window.getHeight() - textHeight;
                topPanel.setPreferredSize(new Dimension(windowWidth, textHeight));
                canvas.setPreferredSize(new Dimension(windowWidth, windowHeight));
            }
        });

        container.add(topPanel);
        container.add(canvas);
        window.add(container);
        window.setVisible(true);
        canvas.revalidate();
        window.getContentPane().repaint();
        
        new Timer(TIMESTEP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            	timeAdvance();
            	window.getContentPane().repaint();
            }
        }).start();
    }
    

    public static void main(String[] args) {
        new WhackAMoleFiller();
    }

}