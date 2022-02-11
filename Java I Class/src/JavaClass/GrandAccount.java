package JavaClass;

public class GrandAccount extends BankAccount {
	public int count = 0;
	public GrandAccount(String name, int money) {
		super(name, money);
	}
	public void withdraw(int n) {
		if (count < 3) {
			money -= n;
			n++;
		}
	}
	public void nextMonth() {
		count = 0;
	}
	public static void main(String args[]) {
	}
}
