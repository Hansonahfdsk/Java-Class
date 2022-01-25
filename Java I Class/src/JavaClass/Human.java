package JavaClass;

public class Human {
	private int age, height;
	private String name;
	public Human(int a, int h, String n) {
		this.age = a;
		this.height = h;
		this.name = n;
	}
	public void getOlder() {
		age++;
	}
	public boolean canVote(int year) {
		if (age >= 18 && year % 4 == 0) {
			return true;
		}
		return false;
	}
	public void setName(String newName) {
		name = newName;
	}
	public String toString() {
		return "Name: " + name + ", Age: " + age + ", Vote: " + canVote(2020);
	}
	public static void main(String[] args) {
		Human Tony = new Human(18, 150, "Tony");
		System.out.println(Tony);
		
	}
}
