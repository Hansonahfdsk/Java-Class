package JavaClass;

public class BankAccount {
	private String name;
	private int money;
	public BankAccount(String name, int money) {
		this.name = name;
		this.money = money;
	}
	public BankAccount(String name) {
		this.name = name;
		money = 0;
	}
	public void deposit(int n) {
		money += n;
	}
	public void withdraw(int n) {
		money -= n;
	}
	public String toString() {
		return "Money: " + money;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int n) {
		money = n;
	}
	public static void main(String args[]) {
		BankAccount a = new BankAccount("a", 100);
	}
}
