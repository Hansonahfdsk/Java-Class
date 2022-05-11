package Tetris;

import java.awt.Graphics;
import java.awt.Image;

import Inheritance.Shape;

public class Piece {
	private int x;
	private int y;
	private String direct;
	private String shape;
	private Image img;
	private Shape[][][] pieces = new Shape[][][];
	
	public Piece(int x, int y, String direct, String shape) {
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.shape = shape;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public String getDirect() {
		return direct;
	}
	public String getShape() {
		return shape;
	}
	public boolean rotate() {
		
	}
	public void draw(Graphics g) {
		
	}
}
