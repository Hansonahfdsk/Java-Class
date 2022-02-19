package Inheritance;

import java.awt.Color;
import java.awt.Graphics;

public class Rect extends Shape{
	private int width = 20;
	private int height = 30;
	public Rect(int x, int y) {
		super(x, y);
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(super.getX(), super.getY(), width, height);
	}
}
