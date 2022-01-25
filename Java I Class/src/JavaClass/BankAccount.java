package JavaClass;

public class BankAccount {
	private String name;
	private int money;
	private double interest;
	public class Account {
		private String name;
		private int money;
		private double interest;
	}
	public BankAccount(String name, int money, double interest) {
		this.name = name;
		this.money = money;
		this.interest = interest;
	}
	public BankAccount(String name, double interest) {
		this.name = name;
		this.interest = interest;
		money = 0;
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
