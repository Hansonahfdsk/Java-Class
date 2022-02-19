package Inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class Oval extends Shape{
	private int width = 20;
	private int height = 30;
	public Oval(int x, int y) {
		super(x, y);
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(super.getX(), super.getY(), width, height);
	}
}
