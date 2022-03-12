package ChessLevel1;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class Knight extends Piece{
	
	// represents a king.
	
	public Knight(int turn, Image img) {
		super(turn,img);
	}
	

	@Override
	public ArrayList<int[]> getMoves(Board board, int r, int c) {
		ArrayList<int[]> moves = new ArrayList<int[]>();
		int[][] knightMoves = {{r + 1, c + 2},{r - 1, c + 2}, {r + 1, c - 2}, {r - 1, c - 2}, {r + 2, c + 1}, {r + 2, c - 1}, {r - 2, c - 1}, {r - 2, c + 1}};
		for (int[] mv: knightMoves) {
			if (mv[0] >= 0 && mv[0] < 8 && mv[1] >= 0 && mv[1] < 8 && board.getBoard()[mv[0]][mv[1]].getTeam() != board.getBoard()[r][c].getTeam()) {
				moves.add(mv);
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
