package JavaII;

import java.awt.Color;

public class BouncingBall extends Ball {
	public BouncingBall(int startx, int starty, int startrad, int startxspeed, int startyspeed, Color startcolor) {
		  super(startx, starty, startrad, startxspeed, startyspeed, startcolor);
	}
	public void move() {
		super.move();
		if (super.getX() > WIDTH - super.getRad() || super.getX() < 0) {
			super.setXSpeed(-1 * super.getXSpeed());
		}
		if (super.getY() > HEIGHT - super.getRad() || super.getY() < 0) {
			super.setYSpeed(-1 * super.getYSpeed());
		}
	}
}
