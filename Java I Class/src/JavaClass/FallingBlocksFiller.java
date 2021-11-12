package JavaClass;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FallingBlocksFiller extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50, BLOCKSIZE = 10;
	
	int[] blockX = new int[NUMBLOCKS];
	int[] blockY = new int[NUMBLOCKS];
	int[] blockSpeed = new int[NUMBLOCKS];
	int[] red = new int[NUMBLOCKS];
	int[] green = new int[NUMBLOCKS];
	int[] blue = new int[NUMBLOCKS];

	public void initializeArrays() {
		for (int i = 0; i < NUMBLOCKS; i++) {
			blockX[i] = (int)(Math.random() * WIDTH - 10);
			blockY[i] = -BLOCKSIZE;
			blockSpeed[i] = (int)(Math.random() * 8 + 1);
			red[i] = (int)(Math.random() * 255);
			green[i] = (int)(Math.random() * 255);
			blue[i] = (int)(Math.random() * 255);
		}
	}

	public void moveblocks() {
		for (int i = 0; i < NUMBLOCKS; i++) {
			blockY[i] += blockSpeed[i];
			if (blockY[i] >= HEIGHT) {
				blockY[i] = -BLOCKSIZE;
				blockX[i] = (int)(Math.random() * WIDTH - 10);
			}
		}
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);

		for (int i = 0; i < NUMBLOCKS; i++) {
			g.setColor(new Color(red[i], green[i], blue[i]));
			g.fillRect(blockX[i], blockY[i], BLOCKSIZE, BLOCKSIZE);
		}
		
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public FallingBlocksFiller() {
		initializeArrays();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new FallingBlocksFiller();
	}

}