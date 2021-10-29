package JavaClass;

import java.util.Scanner;

public class Morewithnestedloops {
	public void loopbox(int x) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < x; j++) {
				System.out.print((i + j) % x + 1);
			}
			System.out.println();
		}
	}
	public void xtri(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('X');
			}
			System.out.println();
		}
	}
	public void whatpow(int x, int y) {
		int count = 0, total = 1;
		while (total != y) {
			total *= x;
			count++;
		}
		System.out.println(count);
	}
	public void diamond(int x) {
		int space = x - 1;
		for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            space--;
            for (int j = 1; j <= 2 * j - 1; j++) {
                System.out.print("*");                
            }
            System.out.println();
        }
        space = 1;
        for (int i = 1; i <= x - 1; i++) {
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }
            space++;
            for (int j = 1; j <= 2 * (x - j) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
	}
	public static void main(String[] args) {
		Morewithnestedloops runner = new Morewithnestedloops();
//		runner.loopbox(5);
//		runner.xtri(5);
//		runner.whatpow(2, 32);
		runner.diamond(4);
	}
}
