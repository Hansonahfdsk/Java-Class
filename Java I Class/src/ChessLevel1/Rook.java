package ChessLevel1;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Rook extends Piece{
	
	// represents a king.
	
	public Rook(int turn, Image img) {
		super(turn,img);
	}
	

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();

		for (int j = 1; j < 8; j++) {
			if (r + j >= 0 && j + r < 8 && board.getBoard()[r + j][c].getTeam() != getTeam()) {
				int[] move = {r + j, c};
				moves.add(move);
			}
			else {
				break;
			}
		}
		for (int j = 1; j < 8; j++) {
			if (r - j >= 0 && r - j < 8 && board.getBoard()[r - j][c].getTeam() != getTeam()) {
				int[] move = {r - j, c};
				moves.add(move);
			}
			else {
				break;
			}
		}
		for (int j = 1; j < 8; j++) {
			if (j + c >= 0 && j + c < 8 && board.getBoard()[r][c + j].getTeam() != getTeam()) {
				int[] move = {r, c + j};
				moves.add(move);
			}
			else {
				break;
			}
		}
		for (int j = 1; j < 8; j++) {
			if (c - j >= 0 && c - j < 8 && board.getBoard()[r][c - j].getTeam() != getTeam()) {
				int[] move = {r, c - j};
				moves.add(move);
			}
			else {
				break;
			}
		}
		return moves;
	}



	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean check(int kingr, int kingc, int r, int c, Board board) {
		// TODO Auto-generated method stub
		ArrayList<int[]> moves = getMoves(board,r,c);
		for (int[] coords: moves) {
			if (coords[0] == kingr && coords[1] == kingc) {
				return true;
			}
		}
		return false;
	}
}
