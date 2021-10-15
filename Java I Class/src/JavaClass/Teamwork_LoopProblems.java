package JavaClass;

import java.util.Scanner;

public class Teamwork_LoopProblems {
	
	public void xton(double x, int n) {
		for (int i = 1; i <= n; i++) {
			System.out.println(Math.pow(x, i));
		}
	}
	public void onetoN(int n) {
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			sum += i;
		}
		System.out.println(sum);
	}
	public void avgNum() {
		int sum = 0, a = 0, c = 0;
		while (a != -1) {
			sum += a;
			Scanner numInput = new Scanner(System.in);
			a = numInput.nextInt();
			c++;
		}
		System.out.println((double)sum/(c - 1));
	}
	public void reverseNum(int n) {
		int flip = 0;
		while (n != 0) {
			int r = n % 10;  
			flip = flip * 10 + r;
			n /= 10;  
		}
		System.out.println(flip);
	}
	
	public void numtolet(int a) {
		int x = a, dig = 0;
		while (x != 0) {
			x /= 10;
			dig++;
		}
		for (int i = dig - 2; i > 0; i -= 2) {
			System.out.println((char)(a % Math.pow(10, i)));
		}
	}
	
	public static void main(String[] args) {
		Teamwork_LoopProblems runner = new Teamwork_LoopProblems();
//		runner.xton(3, 3);
//		runner.onetoN(0);
//		runner.avgNum();
//		runner.reverseNum(12345);
		runner.numtolet(656770);
	}
}
