package SpaceInvadersPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

public class AtkBoost extends Rectangle{
	//need x, y, width, height for the boost powerup square
	public AtkBoost(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	//draw method, the boost square is blue
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
