package JavaClass;
public class Human {
	
	int age;
	char gender;
	
	public void setAge (int a) {
		age = a;
	}
	public void setGender (char b) {
		gender = b;
	}
	public void canVote () {
		if (age >= 18) {
			System.out.println("This person can vote.");
		}
		else {
			System.out.println("This person cannot vote.");
		}
	}
	public void tetanusShot () {
		if (age % 4 == 0) {
			System.out.println("This person needs a tetanus shot.");
		}
		else {
			System.out.println("This person doesn't need a tetanus shot.");
		}
	}
	public void toddler () {
		if (age < 4 && gender == 'b') {
			System.out.println("Toddler boy.");
		}
		else if (age < 4 && gender == 'g') {
			System.out.println("Toddler girl.");
		}
		else {
			System.out.println("Not a toddler.");
		}
	}
	public void movieDiscounts () {
		if (age < 12 || age > 65) {
			System.out.println("Movie discount.");
		}
		else {
			System.out.println("No movie discount.");
		}
	}
	public void teenager () {
		if (age >= 12 && age <= 18) {
			System.out.println("Teenager.");
		}
		else {
			System.out.println("Not a teenager.");
		}
	}
	public static void main(String[] args) {
		
		Human tester = new Human();
		tester.setAge(12);
		tester.setGender('g');
		tester.canVote();
		tester.tetanusShot();
		tester.toddler();
		tester.movieDiscounts();
		tester.teenager();
	}
}