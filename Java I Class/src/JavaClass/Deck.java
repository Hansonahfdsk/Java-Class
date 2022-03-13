package JavaClass;

public class Deck {
	private Card[] deck;
	public Deck() {
		for (int i = 1; i <= 13; i++) {
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
	public Card[] getFirstN(int n) {
		Card[] c = new Card[n];
		for (int i = 0; i < n; i++) {
			c[i] = deck[i];
		}
		return c;
	}
	public void shuffle() {
		for (int i = 0; i < deck.length; i++) {
		    int j = (int)(Math.random() * 52);
		    Card temp = deck[i];
		    deck[i] = deck[j];
		    deck[j] = temp;
		}
	}
	public void sort() {
        for (int i = 0; i < deck.length; i++) {
            for (int j = i + 1; j < deck.length; j++) {
                if (i != j && deck[j].num < deck[i].num) {
                    Card temp = deck[j];
                    deck[j] = deck[i];
                    deck[i] = temp;
                }
            }
        }
	}
}
