package Black;

import java.util.List;

public class Rule {
	public static int getScore(List<Card> cards) {
		int score = 0;
		for (Card c : cards) {
			score += c.getPoint();
		}
		return score;
	}
	
	public static void judge(Player dealer, Player gamer) {
		int dealerScore = getScore(dealer.getCards());
		int gamerScore = getScore(gamer.getCards());
		
		if (dealerScore > 21) {
			if (gamerScore > 21)
				System.out.println("무승부!");
			else
				System.out.println("게이머 승!");
		} else {
			if (gamerScore > 21)
				System.out.println("딜러 승!");
			else if (gamerScore > dealerScore)
				System.out.println("게이머 승!");
			else if (gamerScore == dealerScore)
				System.out.println("무승부!");
			else
				System.out.println("딜러 승!");
		}
		System.out.printf("\t딜러(%d) : 게이머(%d)\n", dealerScore, gamerScore);
	}
}
