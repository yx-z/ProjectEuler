package Problem054;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to highest, in the following way:
 * <p>
 * High Card: Highest value card.
 * One Pair: Two cards of the same value.
 * Two Pairs: Two different pairs.
 * Three of a Kind: Three cards of the same value.
 * Straight: All cards are consecutive values.
 * Flush: All cards of the same suit.
 * Full House: Three of a kind and a pair.
 * Four of a Kind: Four cards of the same value.
 * Straight Flush: All cards are consecutive values of same suit.
 * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 * <p>
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 * <p>
 * If two players have the same ranked hands then the rank made up of the highest value wins;
 * for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie, for example,
 * both players have a pair of queens, then highest cards in each hand are compared (see example 4 below);
 * if the highest cards tie then the next highest cards are compared, and so on.
 * <p></p>
 * The file, poker.txt, contains one-thousand random hands dealt to two players.
 * Each line of the file contains ten cards (separated by a single space):
 * the first five are Player 1's cards and the last five are Player 2's cards.
 * You can assume that all hands are valid (no invalid characters or repeated cards),
 * each player's hand is in no specific order, and in each hand there is a clear winner.
 * <p>
 * How many hands does Player 1 win?
 */

public class PokerHands {
	public static void main(String[] args) throws IOException {
		int count = 0;
		ArrayList<Round> input = readFile("src/Problem054/poker.txt");
		int round = 0;
		for (Round r : input) {
			round++;
			System.out.println("Round " + round + ":\n" + r + "\n");
			if (r.getWinner() == 1) count++;
		}
		System.out.println("Count: " + count);
	}

	//read rounds from .txt
	private static ArrayList<Round> readFile(String fileName) throws IOException {
		ArrayList<Round> input = new ArrayList<>();
		FileInputStream fileInputStream = new FileInputStream(fileName);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			String[] lineArr = line.split(" ");
			Card[] player1 = new Card[5];
			Card[] player2 = new Card[5];
			for (int i = 0; i < 5; i++) {
				player1[i] = new Card(lineArr[i]);
				player2[i] = new Card(lineArr[i + 5]);
			}
			input.add(new Round(new Hand(player1), new Hand(player2)));
		}
		return input;
	}


}

//assume all inputs are legal as the problem stated
class Card implements Comparable<Card> {
	private int val;
	private char suit;

	//constructor: ValSuit, ex. "8C", "TD", etc.
	public Card(String s) {
		//try to accept most cases
		s = s.toUpperCase().replaceAll(" ", "");
		if (s.length() != 2) return;
		char val = s.charAt(0);
		switch (val) {
			case 'T':
				this.val = 0xA;
				break;
			case 'J':
				this.val = 0xB;
				break;
			case 'Q':
				this.val = 0xC;
				break;
			case 'K':
				this.val = 0xD;
				break;
			case 'A':
				this.val = 0xE;
				break;
			default:
				if (val >= '2' && val <= '9') this.val = val - '0';
				break;
		}

		char suit = s.charAt(1);
		if (suit == 'D' || suit == 'S' || suit == 'C' || suit == 'H') this.suit = s.charAt(1);
	}

	@Override
	public int compareTo(Card c) {
		return this.getVal() - c.getVal();
	}

	@Override
	public String toString() {
		String str;
		switch (this.getSuit()) {
			case 'S':
				str = "♠";
				break;
			case 'D':
				str = "♦";
				break;
			case 'H':
				str = "♥";
				break;
			case 'C':
				str = "♣";
				break;
			default:
				str = "";
				break;
		}
		switch (val) {
			case 0xA:
				str += "T";
				break;
			case 0xB:
				str += "J";
				break;
			case 0xC:
				str += "Q";
				break;
			case 0xD:
				str += "K";
				break;
			case 0xE:
				str += "A";
				break;
			default:
				str += "" + val;
				break;
		}
		return str;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Card)) return false;

		Card card = (Card) o;

		return getVal() == card.getVal() && getSuit() == card.getSuit();
	}

	@Override
	public int hashCode() {
		int result = getVal();
		result = 31 * result + (int) getSuit();
		return result;
	}

	public int getVal() {
		return val;
	}

	public char getSuit() {
		return suit;
	}
}

//an array (presumably of size 5) of cards
class Hand implements Comparable<Hand> {
	private Card[] hand;
	private int score;

	public Hand(Card[] c) throws NullPointerException {
		if (c.length != 5) return;
		this.hand = c;
		Arrays.sort(c);
		//check exception for duplicated cards
		for (int i = 0; i < c.length - 1; i++)
			if (c[i].equals(c[i + 1])) return;

	    /* init. score */
		//score with 6 digits in HEX(so as to contain more combinations):
		//Bit 5 to Bit 1: each digit represents the next index for comparing
		//get base score only by value (withou combination)
		score = convertDigitsToScore();
		//Most Significant Bit for Level of the combination of cards, i.e. straight, full house etc., from 8(high) to 0(low, default)
		if (isStraightFlush()) score = score | 0x800000; //this includes royal straight flush
		else if (isFourOfAKind()) score = 0x700000 | modifyScore(fourOfAKind());
		else if (isFullHouse()) score = 0x600000 | modifyScore(threeOfAKind());
		else if (isFlush()) score = score | 0x500000;
		else if (isStraight()) score = score | 0x400000;
		else if (isThreeOfAKind()) score = 0x300000 | modifyScore(threeOfAKind());
		else if (isTwoPairs()) score = 0x200000 | modifyScore(twoPairs());
		else if (isOnePair()) score = 0x100000 | modifyScore(onePair());
	}

	//if there are cards with the same value, their combination value more, i.e. "♦3 ♠3" values more than single "♠A"
	private static int modifyScore(int[] arr) {
		int modification = 0;
		for (int i = 0; i < arr.length; i++)
			modification |= arr[i] << ((4 - i) * 4);
		return modification;
	}

	public Card[] getHand() {
		return hand;
	}

	public int getScore() {
		return score;
	}

	//get base value
	private int convertDigitsToScore() {
		int sum = 0;
		for (int i = hand.length - 1; i >= 0; i--)
			sum = sum | (hand[i].getVal() << (4 * i));
		return sum;
	}

	public boolean isFlush() {
		char baseSuit = hand[0].getSuit();
		for (int i = 1; i < hand.length; i++)
			if (hand[i].getSuit() != baseSuit) return false;
		return true;
	}

	public boolean isStraightFlush() {
		return isFlush() && isStraight();
	}

	public boolean isFourOfAKind() {
		return this.fourOfAKind() != null;
	}

	private int[] fourOfAKind() {
		for (int i = 0; i < 2; i++)
			if (hand[i].getVal() == hand[i + 1].getVal() && hand[i + 1].getVal() == hand[i + 2].getVal() && hand[i + 2].getVal() == hand[i + 3].getVal())
				return new int[]{hand[i].getVal()};
		return null;
	}

	public boolean isFullHouse() {
		return this.fullHouse() != null;
	}

	private int[] fullHouse() {
		if (hand[0].getVal() == hand[1].getVal() && hand[1].getVal() == hand[2].getVal() && hand[3].getVal() == hand[4].getVal())
			return new int[]{hand[0].getVal()};
		if (hand[0].getVal() == hand[1].getVal() && hand[2].getVal() == hand[3].getVal() && hand[3].getVal() == hand[4].getVal())
			return new int[]{hand[2].getVal()};
		return null;
	}

	public boolean isStraight() {
		for (int i = 0; i < hand.length - 1; i++)
			if (hand[i + 1].getVal() - hand[i].getVal() != 1) return false;
		return true;
	}

	public boolean isThreeOfAKind() {
		return this.threeOfAKind() != null;
	}

	private int[] threeOfAKind() {
		for (int i = 0; i < 3; i++)
			if (hand[i].getVal() == hand[i + 1].getVal() && hand[i + 1].getVal() == hand[i + 2].getVal())
				return new int[]{hand[i].getVal()};
		return null;
	}

	public boolean isTwoPairs() {
		return this.twoPairs() != null;
	}

	private int[] twoPairs() {
		if (hand[0].getVal() == hand[1].getVal()) {
			if (hand[2].getVal() == hand[3].getVal())
				return new int[]{Math.max(hand[0].getVal(), hand[2].getVal()), Math.min(hand[0].getVal(), hand[2].getVal()), hand[4].getVal()};
			if (hand[3].getVal() == hand[4].getVal())
				return new int[]{Math.max(hand[0].getVal(), hand[3].getVal()), Math.min(hand[0].getVal(), hand[3].getVal()), hand[2].getVal()};
		}
		if (hand[1].getVal() == hand[2].getVal() && hand[3].getVal() == hand[4].getVal())
			return new int[]{Math.max(hand[1].getVal(), hand[3].getVal()), Math.min(hand[1].getVal(), hand[3].getVal()), hand[0].getVal()};
		return null;
	}

	public boolean isOnePair() {
		return this.onePair() != null;
	}

	private int[] onePair() {
		int i;
		boolean found = false;
		for (i = 0; i < 4; i++) {
			if (hand[i].getVal() == hand[i + 1].getVal()) {
				found = true;
				break;
			}
		}
		if (found) {
			int[] ans = new int[4];
			ans[0] = hand[i].getVal();
			int index = 4;
			for (int j = 1; j < 4; j++) {
				if (j == i) index -= 2;
				ans[j] = hand[index--].getVal();
			}
			return ans;
		}
		return null;
	}

	@Override
	public int compareTo(Hand h) {
		return this.getScore() - h.getScore();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Hand)) return false;

		Hand hand1 = (Hand) o;

		if (getScore() != hand1.getScore()) return false;
		return Arrays.equals(getHand(), hand1.getHand());
	}

	@Override
	public int hashCode() {
		int result = Arrays.hashCode(getHand());
		result = 31 * result + getScore();
		return result;
	}

	@Override
	public String toString() {
		String str = "";
		boolean omitSpace = true;
		for (Card c : hand) {
			if (omitSpace) omitSpace = false;
			else str += " ";

			str += c.toString();
		}
		return str;
	}
}

//two hands from two players
class Round {
	private Hand player1;
	private Hand player2;

	public Round(Hand p1, Hand p2) {
		//exception for duplicated cards
		for (int i = 0; i < p1.getHand().length; i++)
			for (int j = 0; j < p2.getHand().length; j++)
				if (p1.getHand()[i].equals(p2.getHand()[j])) return;
		player1 = p1;
		player2 = p2;
	}

	//get winner
	public int getWinner() {
		if (player1.compareTo(player2) > 0) return 1;
		else if (player1.compareTo(player2) == 0) return 0;
		return 2;
	}

	@Override
	public String toString() {
		return "Player1: " + player1.toString() + "\n" + "Player2: " + player2.toString() + "\n" + "Winner: " + getWinner();
	}
}