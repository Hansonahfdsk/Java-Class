package JavaClass;

import java.util.Scanner;

public class ScannersConditions {
	
	
	public void digitsNum() {
		int num = 0;
		Scanner digInput = new Scanner(System.in);
		int a = digInput.nextInt();
		int b = digInput.nextInt();
		int c = digInput.nextInt();
		int d = digInput.nextInt();
		num += d * 1000;
		num += c * 100;
		num += b * 10;
		num += a;
		System.out.println(num);
	}
	
	public void strNum() {
		Scanner userInput = new Scanner(System.in);
		String c = userInput.nextLine();
		int a = userInput.nextInt();
		int b = userInput.nextInt();
		if (c.equals("+")) {
			System.out.println(a + b);
		}
		else if (c.equals("-")) {
			System.out.println(a - b);
		}
		else if (c.equals("*")) {
			System.out.println(a * b);
		}
		else if (c.equals("/")) {
			System.out.println(a / b);
		}
		else if (c.equals("%")) {
			System.out.println(a % b);
		}
		else {
			System.out.println(c + (char)a + (char)b);
		}
	}


	
	public static void main(String args[]) {
		
		ScannersConditions tester = new ScannersConditions();
//
//		tester.digitsNum();
//		tester.strNum();
	}

}
