package poker;

import java.util.Arrays;

public class PokerHandEvaluator {

	private static void insertionSort(Card[] cards) {
		for (int i = 1; i < cards.length; ++i) {
			Card key = cards[i];
			int j = i - 1;

			while (j >= 0 && cards[j].getValue() > key.getValue()) {
				cards[j + 1] = cards[j];
				j = j - 1;
			}
			cards[j + 1] = key;
		}
	}

	public static boolean hasPair(Card[] cards) {
		boolean pair = false;

		for (int i = 1; i < cards.length; i++) {
			if (cards[0].getValue() == cards[i].getValue()) {
				pair = true;
			}
		}

		for (int i = 2; i < cards.length; i++) {
			if (cards[1].getValue() == cards[i].getValue()) {
				pair = true;
			}
		}

		if (cards[2].getValue() == cards[3].getValue() || cards[2].getValue() == cards[4].getValue()) {
			pair = true;
		}

		if (cards[3].getValue() == cards[4].getValue()) {
			pair = true;
		}

		return pair;

	}

	public static boolean hasTwoPair(Card[] cards) {
		boolean twoPair = false;
		insertionSort(cards);

		if (cards[0].getValue() == cards[1].getValue()) {
			if (cards[2].getValue() == cards[3].getValue() && cards[0].getValue() != cards[2].getValue()) {
				twoPair = true;
			}
		}

		if (cards[0].getValue() == cards[1].getValue()) {
			if (cards[3].getValue() == cards[4].getValue() && cards[0].getValue() != cards[3].getValue()) {
				twoPair = true;
			}
		}

		if (cards[1].getValue() == cards[2].getValue()) {
			if (cards[3].getValue() == cards[4].getValue() && cards[1].getValue() != cards[3].getValue()) {
				twoPair = true;
			}
		}

		return twoPair;
	}

	public static boolean hasThreeOfAKind(Card[] cards) {
		int count = 0;

		for (int i = 1; i < 5; i++) {
			if (cards[0].getValue() == cards[i].getValue()) {
				count++;
			}
		}
		if (count != 2) {
			count = 0;
			for (int i = 2; i < 5; i++) {
				if (cards[1].getValue() == cards[i].getValue()) {
					count++;
				}
			}

			if (count != 2) {
				if (cards[2].getValue() == cards[3].getValue() && cards[2].getValue() == cards[4].getValue()) {
					count = 2;
				}
			}

		}
		if (count == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasStraight(Card[] cards) {
		insertionSort(cards);
		int straight = 0;

		for (int i = 1; i < 5; i++) {
			if (cards[i].getValue() == cards[0].getValue() + i) {
				straight++;
			}
		}
		if (straight == 4) {
			return true;
		} else if (cards[0].getValue() == 1 && cards[1].getValue() == 10 && cards[2].getValue() == 11
				&& cards[3].getValue() == 12 && cards[4].getValue() == 13) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean hasFlush(Card[] cards) {
		int flush = 0;

		for (int i = 1; i < 5; i++) {
			if (cards[0].getSuit() == cards[i].getSuit()) {
				flush++;
			}
		}
		if (flush == 4) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasFullHouse(Card[] cards) {
		insertionSort(cards);
		boolean house = false;

		if (cards[0].getValue() == cards[1].getValue() && cards[0].getValue() == cards[2].getValue()) {
			if (cards[3].getValue() == cards[4].getValue()) {
				house = true;
			}
		}

		if (cards[2].getValue() == cards[3].getValue() && cards[2].getValue() == cards[4].getValue()) {
			if (cards[0].getValue() == cards[1].getValue()) {
				house = true;
			}
		}
		return house;
	}

	public static boolean hasFourOfAKind(Card[] cards) {
		insertionSort(cards);
		int count = 0;

		for (int i = 1; i < 5; i++) {
			if (cards[0].getValue() == cards[i].getValue()) {
				count++;
			}
		}

		if (count != 3) {
			count = 0;
			for (int i = 2; i < 5; i++) {
				if (cards[1].getValue() == cards[i].getValue()) {
					count++;
				}
			}
		}

		if (count == 3) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean hasStraightFlush(Card[] cards) {
		if (hasStraight(cards) && hasFlush(cards)) {
			return true;
		} else {
			return false;
		}
	}
}
