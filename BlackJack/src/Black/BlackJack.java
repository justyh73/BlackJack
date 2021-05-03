/*
 * 
 블랙잭 규칙
참가자는 딜러와 게이머 2명으로 제한
카드는 각 무늬(다이아, 클로버, 하트, 스페이스) 별로 13장(A, 2~10, J,Q,K)씩 총 52장
숫자 카드는 그대로 점수에 사용
문자 카드 점수는 아래와 같이 적용
A: 1점
J,Q,K: 10점
게임 시작시, 참가자는 2장을 받고 시작
게이머는 언제든지 카드를 뽑을 수 있음
딜러의 점수가
16점 이하인 경우 반드시 1장을 뽑고
17점 이상인 경우 더이상 카드를 뽑지 않는다
참가자 모두 추가 뽑기 없는경우 카드를 오픈하며, 오픈시 총점이 21점에 가까운 측이 승리
단, 21점을 초과한 사람은 패배
*/

/*
핵심 객체
카드 뭉치
52개의 서로 다른 카드를 갖음
카드를 1장을 뽑아준다
카드
다이아, 클로버, 하트, 스페이드 중 하나의 무늬를 갖음
A, 2~10, J, Q, K 중 하나를 갖음
규칙
점수를 측정한다
승패를 판단한다
딜러
게임 시작시 2장의 카드를 받음
추가로 카드를 받음(16점 이하인경우)
뽑은 카드를 갖음
카드를 오픈
게이머
게임 시작시 2장의 카드를 받음
추가로 카드를 받음
뽑은 카드를 갖음
카드를 오픈
 */

package Black;
import java.util.Scanner;


public class BlackJack {
	public static void main(String[] args) {
		System.out.println("== 블랙잭 ==");
		Scanner input = new Scanner(System.in);
		
		Player dealer = new Player();
		Player gamer  = new Player();
		Deck deck = new Deck();
		
		init(deck, dealer, gamer);
		
		while(!(dealer.isStay() && gamer.isStay())) {
			playing(input, deck, dealer, gamer);
		}
		Rule.judge(dealer, gamer);
		
	}
	
	public static void init(Deck deck, Player dealer, Player gamer) {
		System.out.println("게이머가 2장의 카드를 받습니다.");
		gamer.hit(deck.pick());
		gamer.hit(deck.pick());
		
		System.out.println("딜러가 2장의 카드를 받습니다.");
		dealer.hit(deck.pick());
		dealer.hit(deck.pick());
		
		System.out.println("게이머의 카드는 다음과 같습니다.");
		gamer.showCards();
		
		System.out.println("딜러의 카드는 다음과 같습니다.");
		dealer.showCards();		
	}
	
	public static void playing(Scanner input, Deck deck, Player dealer, Player gamer) {
		System.out.print("카드를 더 받으려면 1 아니면 0을 입력:");
		int choice = input.nextInt();
		
		if (choice == 1)
			gamer.hit(deck.pick());
		else
			gamer.stay();
		
		if (Rule.getScore(dealer.getCards())<17)
			dealer.hit(deck.pick());
		else 
			dealer.stay();
		
		System.out.println("게이머의 카드는 다음과 같습니다.");
		gamer.showCards();
		
		System.out.println("딜러의 카드는 다음과 같습니다.");
		dealer.showCards();
	}
	

}
