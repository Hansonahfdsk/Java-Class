package JavaClass;

public class BankAccount {
	private String name;
	private int money;
	private double interest
	public class Account {
		private String name;
		private int money;
	}
	public BankAccount(String name, int money) {
		this.name = name;
		this.money = money;
	}
	public BankAccount(String name, double interest) {
		this.name = name;
		money = 0;
		this.interest = interest;
	}
	public void deposit(int n) {
		money += n;
	}
	public void withdraw(int n) {
		money -= n;
	}
	public void addInterest() {
		money += interest * money;
	}
	public String toString() {
		return "Money: " + money;
	}
}
