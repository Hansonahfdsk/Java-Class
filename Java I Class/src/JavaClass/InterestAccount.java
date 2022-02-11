package JavaClass;

public class InterestAccount extends BankAccount{
	private int interest;
	public InterestAccount(String name, int money, int interest) {
		super(name, money);
	}
	public void addInterest() {
		super.addInterest();
	}
}
