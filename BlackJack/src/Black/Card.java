package Black;


public class Card {
	
	private Pattern pattern;
	private String  denomination;
	private int point;
	
	Card(Pattern pattern, int index) {
		this.pattern = pattern;
		this.denomination = getDenomination(index);
		this.point = getPoint(index);
	}
	
	private int getPoint(int index) {
		switch (index) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return index;
			
		case 11:
		case 12:
		case 13:
			return 10;
			
		default:
			return 0;			
		}
	}
	
	private String getDenomination(int index) {
		switch (index) {
		case 1:
			return  "A";
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return "" + index;
			
		case 11:
			return "J";
		case 12:
			return "Q";
		case 13:
			return "K";
			
		default:
			return "ERROR: wrong denomination is Card";			
		}		
	}
	
	@Override
	public String toString() {
		return "Card [pattern=" + pattern + ", denomination=" + denomination + ", point=" + point + "]";
	}
	
	public int getPoint() {
		return this.point;
	}	
}
	
enum Pattern {
	DIAMOND, CLUB, HEART, SPADE;
}

