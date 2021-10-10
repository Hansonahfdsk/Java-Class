package JavaClass;
public class Bool3 {
	public void smallofThree(int a, int b, int c) {
		int smallest = a;
		if (b < smallest) {
			smallest = b;
		}
		if (c < smallest) {
			smallest = c;
		}
		System.out.println(smallest);
	}
	public void twoApart(char a, char b) {
		if (a >= 97) {
			a -= 32;
		}
		if (b >= 97) {
			b -= 32;
		}
		int c = a - 2;
		int d = 0;
		while (c < a + 2) {
			if ((char)c == b) {
				System.out.println(true);
				d = 1;
				break;
			}
			c++;
		}
		if (d == 0) {
			System.out.println(false);
		}
	}
	public static void main(String[] args) {
		Bool3 runner = new Bool3();
		runner.smallofThree(123, 123213, 321);
		runner.twoApart('d', 'G');
	}
}
