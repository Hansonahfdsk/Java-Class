package JavaClass;

public class InterestAccount extends BankAccount{
	public double interest;
	public InterestAccount(String name, int money) {
		super(name, money);
	}
	public void addInterest() {
		money += interest * money;
	}
	public static void main(String args[]) {
	}
}
