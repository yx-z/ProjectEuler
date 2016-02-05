package Problem054;

import java.io.*;

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
    private static final int ROUNDS = 1000;

    public static void main(String[] args) throws IOException {
        int count = 0;
        Round[] input = readFile("src/Problem054/poker.txt");
        for (Round r : input) count += r.winner1();
        System.out.println(count);
    }

    //read 1000 rounds from .txt
    private static Round[] readFile(String fileName) throws IOException {
        Round[] input = new Round[ROUNDS];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        String line;
        int lineNum = 0;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineArr = line.split(" ");
            Card[] player1 = new Card[5];
            Card[] player2 = new Card[5];
            for (int i = 0; i < 5; i++) {
                player1[i] = new Card(lineArr[i]);
                player2[i] = new Card(lineArr[i + 5]);
            }
            input[lineNum] = new Round(new Hand(player1), new Hand(player2));
            lineNum++;
        }
        return input;
    }
}

//assume all inputs are legal as the problem stated
class Card {
    int val;
    char suit;

    //constructor: Val-Suit, ex. "8C", "TD"
    Card(String s) {
        char val = s.charAt(0);
        if (val == 'T') this.val = 10;
        else if (val == 'J') this.val = 11;
        else if (val == 'Q') this.val = 12;
        else if (val == 'K') this.val = 13;
        else if (val == 'A') this.val = 14;
        else this.val = val - '0';

        this.suit = s.charAt(1);
    }
}

//an array(presumably of size 5) of cards
class Hand {
    Card[] hand;

    Hand(Card[] c) {
        this.hand = c;
        sortCardByNum();
    }

    //implementd by insertion sort for convenience, from small val to big ones
    void sortCardByNum() {
        for (int i = 1; i < hand.length; i++) {
            Card key = hand[i];
            int j;
            for (j = i - 1; j >= 0 && key.val < hand[j].val; j--)
                hand[j + 1] = hand[j];
            hand[j + 1] = key;
        }
    }

    //hevy lifting here...
    int getScore() {
        //score with 6 digits in HEX(so as to contain more combinations):
        //Bit 5 to Bit 1: each digit represents the next index for comparing
        int score = convertDigitsToScore();
        //Most Significant Bit for Level of the card, i.e. straight, full house etc., from 9(high) to 0(low)
        if (royalFlush()) score += 0x900000;
        else if (straightFlush()) score += 0x800000;
        else if (fourOfAKind() != 0) score = 0x700000 + fourOfAKind();
        else if (fullHouse() != 0) score = 0x600000 + fullHouse();
        else if (flush()) score += 0x500000;
        else if (straight()) score += 0x400000;
        else if (threeOfAKind() != 0) score = 0x300000 + threeOfAKind();
        else if (twoPairs() != null) score = 0x200000 + twoPairs()[0] * 256 + twoPairs()[1] * 16 + twoPairs()[2];
        else if (onePair() != null) score = 0x100000 + onePair()[0] * 16 * 256 + onePair()[1] * 256 + onePair()[2] * 16 + onePair()[3];

        return score;
    }

    //get value
    int convertDigitsToScore() {
        int sum = 0;
        for (int i = hand.length - 1; i >= 0; i--)
            sum += hand[i].val * Math.pow(16, i);
        return sum;
    }

    boolean royalFlush() {
        if (!flush()) return false;
        int sum = 0;
        for (Card c : hand) sum += c.val;
        //since values of royal flush card set are always the biggest
        return sum == 10 + 11 + 12 + 13 + 14;
    }

    boolean flush() {
        char baseSuit = hand[0].suit;
        for (int i = 1; i < hand.length; i++)
            if (hand[i].suit != baseSuit) return false;
        return true;
    }

    boolean straightFlush() {
        return flush() && straight();
    }

    int fourOfAKind() {
        for (int i = 0; i < 2; i++)
            if (hand[i].val == hand[i + 1].val && hand[i + 1].val == hand[i + 2].val && hand[i + 2].val == hand[i + 3].val)
                return hand[i].val;
        return 0;
    }

    int fullHouse() {
        if (hand[0].val == hand[1].val && hand[1].val == hand[2].val && hand[3].val == hand[4].val)
            return hand[0].val;
        if (hand[0].val == hand[1].val && hand[2].val == hand[3].val && hand[3].val == hand[4].val)
            return hand[2].val;
        return 0;
    }

    boolean straight() {
        for (int i = 0; i < hand.length - 1; i++)
            if (hand[i + 1].val - hand[i].val != 1) return false;
        return true;
    }

    int threeOfAKind() {
        for (int i = 0; i < 3; i++)
            if (hand[i].val == hand[i + 1].val && hand[i + 1].val == hand[i + 2].val) return hand[i].val;
        return 0;
    }

    int[] twoPairs() {
        if (hand[0].val == hand[1].val) {
            if (hand[2].val == hand[3].val) {
                return new int[]{Math.max(hand[0].val, hand[2].val), Math.min(hand[0].val, hand[2].val), hand[4].val};
            }
            if (hand[3].val == hand[4].val) {
                return new int[]{Math.max(hand[0].val, hand[3].val), Math.min(hand[0].val, hand[3].val), hand[2].val};
            }
        }
        if (hand[1].val == hand[2].val && hand[3].val == hand[4].val) {
            return new int[]{Math.min(hand[1].val, hand[3].val), Math.min(hand[1].val, hand[3].val), hand[0].val};
        }
        return null;
    }

    int[] onePair() {
        int i;
        boolean found = false;
        for (i = 0; i < 4; i++) {
            if (hand[i].val == hand[i + 1].val) {
                found= true;
                break;
            }
        }
        if (found) {
            int[] ans = new int[4];
            ans[0] = hand[i].val;
            if (i == 0) {
                ans[1] = hand[2].val;
                ans[2] = hand[3].val;
                ans[3] = hand[4].val;
                return ans;
            }
            if (i == 1) {
                ans[1] = hand[0].val;
                ans[2] = hand[3].val;
                ans[3] = hand[4].val;
                return ans;
            }
            if (i == 2) {
                ans[1] = hand[0].val;
                ans[2] = hand[1].val;
                ans[3] = hand[4].val;
                return ans;
            }
            if (i == 3) {
                ans[1] = hand[0].val;
                ans[2] = hand[1].val;
                ans[3] = hand[2].val;
                return ans;
            }
        }
        return null;
    }
}

//two hands from two players
class Round {
    Hand player1;
    Hand player2;

    Round(Hand p1, Hand p2) {
        player1 = p1;
        player2 = p2;
    }

    //get winner
    int winner1() {
        return player1.getScore() > player2.getScore() ? 1 : 0;
    }
}