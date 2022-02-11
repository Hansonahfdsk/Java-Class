package JavaII;

import java.awt.Color;

public class SineBall extends BouncingBall {
	public SineBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		  super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move() {
		super.move();
		super.setY((int)(60*Math.sin(super.getX()/(3*Math.PI)) + 100));
	}
}
