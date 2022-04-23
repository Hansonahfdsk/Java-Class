package SpaceInvadersPackage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;

public class Shield extends Rectangle{
	//need x, y, width, height for the shield powerup square
	public Shield(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	//draw method, the shield square is green
	public void draw(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
	}
}
