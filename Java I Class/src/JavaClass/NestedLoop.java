package JavaClass;

public class NestedLoop {
//	constant
	public void AtoZ() {
		for (int i = 65; i <= 90; i++) {
			System.out.print((char)i);
		}
	}
// constant
	public void multi12() {
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 12; j++) {
				System.out.print(i * j + " ");
			}
			System.out.println();
		}
	}
// linear
	public void prime(int x) {
		for (int i = 2; i <= x; i++) {
			int n = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					n = 1;
					break;
				}
			}
			if (n == 0) {
				System.out.println(i);
			}
		}
	}
// linear
	public void xofstar(int n) {
		for (int i = 0; i <= n / 2 - 1; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(' ');
			}
			System.out.print('*');
			for (int j = n / 2 - 2 * i; j >= 0; j--) {
				System.out.print(' ');
			}
			System.out.print('*');
			System.out.println();
		}
	}
	public static void main(String[] args) {
		NestedLoop runner = new NestedLoop();
//		runner.AtoZ();
//		runner.multi12();
//		runner.prime(15);
		runner.xofstar(7);
	}
}
