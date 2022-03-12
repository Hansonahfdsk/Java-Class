package ChessLevel1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Board {
	
	// keeps track of the position of each king. First row is the position of the white king, 
	// second row is the black king.
	private int[][] kingPositions = new int[2][2];

	// represents the entire board - make sure to initialize!.
	private Piece[][] board = new Piece[8][8];
	
	public Board() {
		
		// loads the images into a map
		HashMap<String, Image> images = loadImages();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board[i][j] = new Empty();
			}
		}
		
		board[3][7] = new King(1, images.get("BlackKing"));
		board[3][0] = new King(0, images.get("WhiteKing"));
		kingPositions[0] = new int[]{3, 0};
		kingPositions[1] = new int[] {3, 7};
		
		// fill in the rest of the chess board here
		for (int i = 0; i < 8; i++) {
			board[i][1] = new Pawn(0, images.get("WhitePawn"));
			board[i][6] = new Pawn(1, images.get("BlackPawn"));
		}
		board[0][0] = new Rook(0, images.get("WhiteRook"));
		board[7][0] = new Rook(0, images.get("WhiteRook"));
		board[0][7] = new Rook(1, images.get("BlackRook"));
		board[7][7] = new Rook(1, images.get("BlackRook"));
		board[1][0] = new Knight(0, images.get("WhiteKnight"));
		board[6][0] = new Knight(0, images.get("WhiteKnight"));
		board[1][7] = new Knight(1, images.get("BlackKnight"));
		board[6][7] = new Knight(1, images.get("BlackKnight"));
		board[2][0] = new Bishop(0, images.get("WhiteBishop"));
		board[5][0] = new Bishop(0, images.get("WhiteBishop"));
		board[2][7] = new Bishop(1, images.get("BlackBishop"));
		board[5][7] = new Bishop(1, images.get("BlackBishop"));
		board[4][0] = new Queen(0, images.get("WhiteQueen"));
		board[4][7] = new Queen(1, images.get("BlackQueen"));
		
		
	}
	
	// draws the board. There should be a grid of 8x8 squares, and each piece in their location. 
	// the last clicked piece (curr) should be drawn on a yellow background.
	public void draw(Graphics g, Piece curr) {
		
		int sw = Chess.SQUARE_WIDTH;	// the width of each square on the board
		// your code here
		for (int i = 0; i < 8; i ++) {
			for (int j = 0; j < 8; j ++) {
				if (i % 2 + j % 2 == 1) {
					g.setColor(Color.GRAY);
				}
				else {
					g.setColor(Color.WHITE);
				}				
				if (board[i][j] == curr) {
					g.setColor(Color.YELLOW);
				}
				g.fillRect(j * sw, i * sw, sw, sw);
				board[i][j].draw(g, sw*j, sw*i);
			}
		}
		

	}
	
	
	/******** DON'T TOUCH THE BELOW CODE ****************/
	
	// loads all necessary images into a map. Key = piece name, value = corresponding image
	public HashMap<String, Image> loadImages() {
		String[] pieces = {"King", "Queen", "Rook", "Bishop", "Knight", "Pawn"};
		
		HashMap<String, Image> images = new HashMap<String, Image>();
		
		for (String p : pieces) {
			for (String color : new String[] {"Black", "White"}) {
				Image img = Toolkit.getDefaultToolkit().getImage("Images/" + color + p + ".png");	
				images.put(color + p, img.getScaledInstance(Chess.IMG_WIDTH, Chess.IMG_WIDTH, Image.SCALE_SMOOTH));
			}
		}
		return images;
	}
	
	public Piece[][] getBoard() {
		return board;
	}
	
	
	// moves the piece currently at (r, c) to (newR, newC)
	// returns 0 for a normal move, 1 for a check move, 2 for a checkmate move
	public int move(int r, int c, int newR, int newC) {
		
		if (board[r][c].isKing()) {
			int team = board[r][c].getTeam();
			kingPositions[team] = new int[] {newR, newC};
		}
		
		if (board[newR][newC].isKing()) {
			board[newR][newC] = board[r][c];
			board[r][c] = new Empty();
			return 2;
		}
		
		board[newR][newC] = board[r][c];
		board[r][c] = new Empty();
		
		
		if (check()) return 1;
		return 0;
		
	}
	
	// determines if the non-current team is in check. 
	public boolean check() {
		for (int i = 0; i < 8; i ++)
			for (int j = 0; j < 8; j++) {
				if (board[i][j].getTeam()!= -1) {
					int opp = (board[i][j].getTeam()+1)%2;
					if (board[i][j].check(kingPositions[opp][0], kingPositions[opp][1], i, j, this)) {
						System.out.println("Player " + opp + " is in check");
						return true;
					}
				}
					
			}
		return false;
	}
}
