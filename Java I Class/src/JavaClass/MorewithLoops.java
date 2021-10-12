package JavaClass;

import java.util.Scanner;

public class MorewithLoops {
	public void inputUntil(int a) {
		Scanner numInput = new Scanner(System.in);
		int b = numInput.nextInt();
		while (b != a) {
			b = numInput.nextInt();
		}
	}
	public void fact() {
		Scanner numInput = new Scanner(System.in);
		int a = numInput.nextInt();
		int factorial = 1;
		for (int i = a; i > 0; i--) {
			factorial *= i;
		}
		System.out.println(factorial);
	}
	public void prime() {
		Scanner numInput = new Scanner(System.in);
		int a = numInput.nextInt();
		int x = 0;
		if (a <= 1) {
			x = 1;
		}
		for (int i = 2; i < a; i++) {
			if (a % i == 0) {
				x = 1;
				break;
			}
		}
		if (x == 0) {
			System.out.println("Prime");
		}
		else {
			System.out.println("Not prime");
		}
	}
	public void greatestCommon() {
		Scanner numInput = new Scanner(System.in);
		int a = numInput.nextInt();
		int b = numInput.nextInt();
		int greatest = 1;
		for (int i = 1; i <= a; i++) {
			if (b % i == 0 && a % i == 0) {
				greatest = i;
			}
		}
		System.out.println(greatest);
	}
	public void leastCommon() {
		Scanner numInput = new Scanner(System.in);
		int a = numInput.nextInt();
		int b = numInput.nextInt();
		int least = 1;
		for (int i = a * b; i >= a; i--) {
			if (i % b == 0 && i % a == 0) {
				least = i;
			}
		}
		System.out.println(least);
	}
	public void magicSquare() {
		Scanner numInput = new Scanner(System.in);
		int x = numInput.nextInt();
		int a = 1;
		while (x != 0) {
			int square = 0, sum = 0, s = 0;
			for (int i = 1; i < a; i++) {
				if (i * i == a) {
					square = 1;
					break;
				}
			}
			for (int i = 1; i < a; i++) {
				s += i;
				if (s == a) {
					sum = 1;
					break;
				}
			}
			if (square == 1 && sum == 1) {
				System.out.println(a);
				x--;
			}
			a++;
		}
	}
	public static void main(String[] args) {
		MorewithLoops runner = new MorewithLoops();
//		runner.inputUntil(3);
//		runner.fact();
//		runner.prime();
//		runner.greatestCommon();
//		runner.leastCommon();
		runner.magicSquare();
	}
}
