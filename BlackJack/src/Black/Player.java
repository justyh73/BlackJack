package Black;

import java.util.LinkedList;
import java.util.List;

public class Player {
	enum Status {
		STAY, HIT
	}
	
	private List<Card> cards;
	private Status status;
	
	Player() {
		this.cards = new LinkedList<Card>();
		this.status = Status.HIT;
	}
	//** add method
	public List<Card>getCards()
	{
		return cards;
	}
	
	public void showCards()
	{
		for (Card c : cards) {
			System.out.println(c.toString());
		}
	}
	
	public void hit(Card c)
	{
		cards.add(c);
	}
	
	public void stay()
	{
		this.status = Status.STAY;
	}
	
	public boolean isStay()
	{
		if(this.status == Status.STAY)
			return true;
		else 
			return false;
	}
	
	
}
