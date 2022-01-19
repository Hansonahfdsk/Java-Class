package JavaClass;
import java.util.Arrays;
public class evenmorewith2darrays {
	public void arrtostr(char[][] a) {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				s += a[i][j];
			}
		}
		System.out.println(s);
	}
	public void diagonal(int n) {
		int[][] a = new int[n][n];
		for (int i = 0; i < n; i++) {
			a[i][i] = n;
		}
		for (int[] rows: a) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void triangle(int n) {
		int count = 1;
		int[][] a = new int[n][];
		for (int i = 0; i < n; i++) {
			a[i] = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				a[i][j] = count;
				count++;
			}
		}
		for (int[] rows: a) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void zeros(int[][] a) {
		int[][] b = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; i += 2) {
				b[i][j] = a[i][j];
				b[i][j + 1] = 0;
			}
		}
		for (int[] rows: b) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void reverse(int[][] a) {
		int[][] b = new int[a.length][];
		for (int i = 0; i < a.length; i++) {
			b[i] = new int[a[i].length];
			for (int j = 0; j < a[i].length; j++) {
				b[i][j] = a[i][a[i].length - j - 1];
			}
		}
		for (int[] rows: b) {
			System.out.println(Arrays.toString(rows));
		}
	}
}
