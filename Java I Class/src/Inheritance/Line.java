package Inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{
	private int x2 = 50;
	private int y2 = 70;
	public Line(int x, int y) {
		super(x, y);
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(super.getX(), super.getY(), x2, y2);
	}
}
