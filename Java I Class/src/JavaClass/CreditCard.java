package JavaClass;

public class CreditCard extends InterestAccount{
	public CreditCard(String name, int money, double interest) {
		super(name, money);
		this.interest = interest;
	}
	public void addInterest() {
		money += interest * money - 10;
	}
	public void withdraw(int n) {
		if (money - n >= 100) {
			money -= n;
		}
	}
	public static void main(String args[]) {
	}
}
