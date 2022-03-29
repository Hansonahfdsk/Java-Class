package JavaII;

import java.awt.Color;
import java.awt.Graphics;

public class Block{
	private int x;
	private int y;
	private Color color;
	private double speed;
	public Block(int x, int y, Color color, double speed) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.speed = speed;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, 10, 10);
	}
	public void move() {
		y += speed;
	}
	public int getY() {
		return y;
	}
}
