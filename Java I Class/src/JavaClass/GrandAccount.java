package JavaClass;

public class GrandAccount extends BankAccount {
	public int count = 1;
	public GrandAccount(String name, int money) {
		super(name, money);
	}
	public void withdraw(int n) {
		if (count <= 3) {
			super.setMoney(super.getMoney() - n);
			n++;
		}
	}
	public void nextMonth() {
		if (count == 0) {
			super.setMoney(super.getMoney() * 2);
		}
		count = 0;
	}
	public static void main(String args[]) {
		
	}
}
