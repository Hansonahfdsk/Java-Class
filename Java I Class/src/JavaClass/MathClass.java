package JavaClass;
public class MathClass {
	
	int Key;
	
	public void halve(int x) {
		System.out.println(x/2);
	}

	public void square(int x) {
		System.out.println(x * x);
	}
	
	public void averageFive(int a, int b, int c, int d, int e) {
		System.out.println((a + b + c + d + e) / 5);
	}
	
	public void raiseToTheFourth(int x) {
		System.out.println(Math.pow(x, 4));
	}
	
	public void setKey(int x) {
		Key = x;
	}
	
	public void multiplyByKey(int x) {
		System.out.println(x * Key);
	}
	
	public void keyCubed() {
		System.out.println(Math.pow(Key, 3));
	}
	
	public void makeInteger(double x) {
		System.out.println((int)x);
	}
	
	public void roundToNearestWhole(double x) {
		if (x % 1 >= 0.5) {
			System.out.println((int)x / 1 + 1);
		}
		else {
			System.out.println((int)x / 1);
		}
	}
	
	public static void main(String args[]) {
		
		MathClass tester = new MathClass();
		
		// example method
		// output: 4
		tester.halve(8);
		
		// output: 49
		tester.square(7);
		
		// output: 7
		tester.averageFive(7,10,5,7,6);
		
		// output: 81
		tester.raiseToTheFourth(3);
		
		// output: nothing, just save the number 4 as an instance variable
		tester.setKey(4);
		
		// output: 28
		tester.multiplyByKey(7);
		
		// output: 64
		tester.keyCubed();
		
		// output: 3
		tester.makeInteger(3.756);
		
		// output: 8
		tester.roundToNearestWhole(7.8);
	}

}
