package JavaClass;

public class Deck {
	private Card[] deck;
	public Deck() {
		for (int i = 0; i < 13; i++) {
			deck[i] = new Card("clubs", i);
			deck[i + 13] = new Card("hearts", i);
			deck[i + 26] = new Card("diamonds", i);
			deck[i + 39] = new Card("spades", i);
		}
	}
	public String toString() {
		String s = "";
		for (int i = 0; i < 52; i++) {
			s += deck[i].toString();
		}
		return s;
	}
	public Card getRandom() {
		return deck[(int)(Math.random()*52)];
	}
}
