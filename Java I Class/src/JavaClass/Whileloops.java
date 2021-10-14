package JavaClass;

import java.util.Scanner;

public class Whileloops {
	public void twoInt (int a, int b) {
		int c = a;
		while (c <= b) {
			System.out.println(c);
			c++;
		}
	}
	
	public void twoDoub (double a, double b) {
		int expo = 0;
		while (expo <= 5) {
			System.out.println(b * Math.pow(a, expo));
			expo++;
		}
	}
	
	public void squareRt (int a) {
		int b = 0, c = 0;
		if (a > 0) {
			while (b <= a) {
				if (b * b == a) {
					System.out.println(b);
					c = 1;
					break;
				}
				b++;
			}
		}
		if (c == 0) {
			System.out.println("does not have a root");
		}
	}
	
	public void largest (int n) {
		int i = 1;
		Scanner numInput = new Scanner(System.in);
		int greatest = numInput.nextInt();
		while (i < n) {
			int a = numInput.nextInt();
			if (a > greatest) {
				greatest = a;
			}
			i++;
		}
		System.out.println(greatest);
	}
	
	public void taylorSeries () {
		Scanner numInput = new Scanner(System.in);
		int x = numInput.nextInt();
		double pom = 0, expo = 1, value = 0;
		for (int i = 0; i < 100; i++) {
			int fac = 1;
			for (int j = 1; j <= expo; j++) {
				fac *= j;
			}
			if (pom == 0) {
				value += Math.pow(x, expo) / fac;
				pom = 1;
			}
			else {
				value -= Math.pow(x, expo) / fac;
				pom = 0;
			}
		}
		System.out.println(value);
		System.out.println(Math.sin(x));
	}
	
	public static void main(String[] args) {
		Whileloops tester = new Whileloops();
//		tester.twoInt (3, 7);
//		tester.twoDoub(2, 3);
//		tester.squareRt(36);
//		tester.largest(5);
		tester.taylorSeries();
	}
}
