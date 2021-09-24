package JavaClass;
public class SimpleIf {
	public void posneg (int x) {
		if (x > 0) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
	}
	public void oddeven (int y) {
		if (y % 2 == 1) {
			System.out.println("Odd");
		}
		else {
			System.out.println("Even");
		}
	}
	public void uplower (char c) {
		if (c >= 65 && c <= 90) {
			System.out.println("Uppercase");
		}
		else if (c >= 97 && c <= 122){
			System.out.println("Lowercase");
		}
		else {
			System.out.println("Neither");
		}
	}
	public void multiten (int z) {
		if (z % 10 == 0) {
			System.out.println("Multiple of 10");
		}
		else {
			System.out.println("Not multiple of 10");
		}
	}
	public void greatest (int n, int m, int l) {
		int greatest = n;
		if (m > greatest) {
			greatest = m;
		}
		if (l > greatest) {
			greatest = l;
		}
		System.out.println(greatest);
	}
	public void challenge (double a) {
		if (a % 1 > 0) {
			System.out.println("Not whole number");
		}
		else {
			System.out.println("Whole number");
		}
	}
	public static void main(String[] args) {
		SimpleIf tester = new SimpleIf();
		tester.posneg(-1);
		tester.oddeven(2);
		tester.uplower('A');
		tester.multiten(10);
		tester.greatest(1, 2, 3);
		tester.challenge(2.0);
	}
}