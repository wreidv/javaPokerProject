package poker;

public class Deck {

	private Card[] cards;

	public Deck() {
		int count = 0;
		cards = new Card[52];
		
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j <= 13; j++) {
				cards[count] = new Card(j,i);
				count++;
			}
		}
	}

	public Deck(Deck other) {
		cards = new Card[other.getNumCards()];
		for(int i = 0; i < cards.length; i++) {
			cards[i] = other.getCardAt(i);
		}
	}

	public Card getCardAt(int position) {
		return cards[position];
	}

	public int getNumCards() {
		return cards.length;
	}

	public void shuffle() {
		Card[] top;
		Card[] bottom;
		int count, count2;
		
		if(cards.length%2==0) {
			top = new Card[cards.length/2];
			bottom = new Card[cards.length/2];
			count = 0;
			
			for(int i = 0; i < cards.length/2; i++) {
				top[i] = cards[i];
			}
			for(int i = cards.length/2; i < cards.length; i++) {
				bottom[count] = cards[i];
				count++;
			}
		}else {
			top = new Card[cards.length/2+1];
			bottom = new Card[cards.length/2];
			count = 0;
			
			for(int i = 0; i <= cards.length/2; i++) {
				top[i] = cards[i];
			}
			for(int i = cards.length/2+1; i < cards.length; i++) {
				bottom[count] = cards[i];
				count++;
			}
		}
		count = 0;
		count2 = 0;
		
		for(int i = 0; i < cards.length; i++) {
			if(i%2==0) {
				cards[i] = top[count];
				count++;
			}else {
				cards[i]= bottom[count2];
				count2++;
			}
		}
		
	}

	public void cut(int position) {
		Card[] top = new Card[position];
		Card[] bottom = new Card[cards.length-position];
		int count = 0;
		
		for(int i = 0; i < top.length; i++) {
			top[i] = cards[i];
		}
		for(int i = position; i < cards.length; i++) {
			bottom[count] = cards[i];
			count++;
		}
		count = 0;
		for(int i = 0; i < cards.length; i++) {
			if(i < bottom.length) {
				cards[i] = bottom[i];
			}else {
				cards[i] = top[count];
				count++;
			}
		}
	}

	public Card[] deal(int numCards) {
		Card[] dealt = new Card[numCards];
		Card[] smaller = new Card[cards.length-numCards];
		
		for(int i = 0; i < numCards; i++) {
			dealt[i] = cards[i];
		}
		for(int i = 0; i < smaller.length; i++) {
			smaller[i] = cards[numCards+i];
		}
		
		cards = smaller;
		return dealt;
	}
		
}
