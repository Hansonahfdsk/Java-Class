package JavaII;

import java.awt.Color;

public class CirclePathBall extends Ball {
	private int t = 0;
	public CirclePathBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		  super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move() {
		super.move();
		super.setX((int)(100 * Math.sin(t / 5.0 / Math.PI) + 150));
		super.setY((int)(100 * Math.cos(t / 5.0 / Math.PI) + 150));
		t++;
	}
}
