package JavaClass;

public class Card {
	private String suit;
	private int num;
	public Card(String suit, int num) {
		this.suit = suit;
		this.num = num;
	}
	public String toString() {
		return num + "of" + suit;
	}
}
