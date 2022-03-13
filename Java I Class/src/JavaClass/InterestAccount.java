package JavaClass;

public class InterestAccount extends BankAccount{
	public double interest;
	public InterestAccount(String name, int money) {
		super(name, money);
	}
	public void addInterest() {
		super.setMoney(super.getMoney() + interest * super.getMoney());
	}
	public static void main(String args[]) {
	}
}
