package JavaClass;

import java.util.Arrays;

public class morewith2darrays {
	
	public void nbym(int n, int m) {
		int a[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a[i][j] = i * m + j + 1;
			}
		}
		for (int[] rows: a) {
			System.out.println(Arrays.toString(rows));
		}
	}
	public void maxofa(int[][] a) {
		int maximum = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				if(a[i][j] > maximum)
					maximum = a[i][j];
			}
		}
		System.out.println(maximum);
	}
	
	public void 
	
	public static void main(String[] args) {
		morewith2darrays tester = new morewith2darrays();
		tester.nbym(3, 4);
		tester.maxofa(new int[][] {{1, 2, 3}, {4, 5, 6}});
	}
}
