package JavaII;

public class Josephus {

	public static int josephus(int n, int i) {
		if (n == 1) {
			return 1;
		}
		return (josephus(n - 1, i) + i - 1) % n + 1;
	}
	public static void main(String[] args) {
		System.out.println(josephus(5, 2));
	}
}
