package JavaClass;

public class CreditCard extends InterestAccount{
	public CreditCard(String name, int money, double interest) {
		super(name, money);
		this.interest = interest;
	}
}
