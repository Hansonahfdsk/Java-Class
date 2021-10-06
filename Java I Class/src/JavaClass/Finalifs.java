package JavaClass;

public class Finalifs {
	
	
	public void baseTwoTen (int a, int b, int c, int d, int e) {
		System.out.println(a * 16 + b * 8 + c * 4 + d * 2 + e * 1);
	}
	
	public void swapStrings (String str1, String str2) {
		String str3;
		str3 = str1;
		str1 = str2;
		str2 = str3;
	}
	
	public void stringNums (int c) {
		int a = c / 1000;
		System.out.println(a % (c % 10) + ", " + a % (c % 100) + ", " + a % (c % 1000));
	}
	
	public static void main(String[] args) {
		Finalifs tester = new Finalifs();
		tester.baseTwoTen(1, 0, 1, 1, 1);
		tester.swapStrings("abc", "cba");
		tester.stringNums(34924);
	}
}