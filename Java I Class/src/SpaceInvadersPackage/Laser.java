package SpaceInvadersPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

public class Laser extends Rectangle{
	//need x, y, width and height of the laser
	public Laser(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	//move laser in x direction
	public void moveX(int move) {
		x += move;
	}
	//move laser in y direction
	public void moveY(int move) {
		y += move;
	}
	//draw method, the laser is yellow
	public void draw(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
	}
}
