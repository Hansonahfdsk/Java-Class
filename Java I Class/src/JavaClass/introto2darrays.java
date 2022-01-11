package JavaClass;
import java.util.Arrays;
public class introto2darrays {
	// A. 6
	// B. 1
	// C. IndexOutOfBoundsException
	// D. 3
	// E. k
	// F. IndexOutOfBoundsException
	// G. 105
	// H. k
	// I. 7 6
	public void makearr(int n) {
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = i * n + j;
			}
		}
		for (int[] rows: arr) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void columns(String[][] s) {
		System.out.println(s[0].length + " " + s.length);
	}
	public void onetwothree(int n1, int n2, int n3, int n4, int n5, int n6) {
		int[][] arr = {{n1}, {n2, n3}, {n4, n5, n6}};
		for (int[] rows: arr) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public static void main(String[] args) {
		introto2darrays tester = new introto2darrays();
		tester.makearr(3);
		tester.columns(new String[][] {{"a", "b", "c"}, {"d", "e", "f"}});
		tester.onetwothree(1, 2, 3, 4, 5, 6);
	}
}
