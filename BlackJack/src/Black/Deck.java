package Black;

import java.util.LinkedList;
import java.util.List;

public class Deck {
	private List<Card> cards;
	
	Deck() {
		this.cards = generateCards();
	}
	
	private List<Card> generateCards() {
		LinkedList<Card> cards = new LinkedList<>();
		
		for (Pattern p : Pattern.values()) {
			for (int i =1; i <=13; i++) {
				Card c = new Card(p,i);
				cards.add(c);
			}
		}
		return cards;		
	}
	
	public Card pick() {
		int randomIndex = (int)(Math.random() * cards.size());
		return cards.remove(randomIndex);
	}
}
