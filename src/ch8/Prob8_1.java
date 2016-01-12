package ch8;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 11..
 */
public class Prob8_1 {
    public static void main(String[] args) {
        System.out.println(Suit.Diamond.getValue());
        System.out.println(Suit.getSuitByValue(3));
    }
}

enum Suit {
    Club(0), Diamond(1), Heart(2), Spade(3);
    private int value;

    Suit(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitByValue(int value) {
        switch(value) {
            case 0:
                return Club;
            case 1:
                return Diamond;
            case 2:
                return Heart;
            case 3:
                return Spade;
            default:
                return null;
        }
    }
}

enum Number {
    Ace(1), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7),
    Eight(8), Nine(9), Ten(10), Jack(11), Queen(12), King(13);
    private int value;

    Number(int value) {
        this.value = value;
    }

    int getValue() {
        return value;
    }
}

abstract class Card {
    private boolean isAvailable = true;
    protected Number number;
    protected Suit suit;

    Card(Number number, Suit suit) {
        this.number = number;
        this.suit = suit;
    }

    abstract int getValue();

    Suit getSuit() {
        return suit;
    }

    boolean isAvailable() {
        return isAvailable;
    }

    void markUnavailable() {
        isAvailable = false;
    }

    void markAvailable() {
        isAvailable = true;
    }
}

abstract class Deck <T extends Card> {
    private List<T> cards;
    private int dealtCard = 0;
    private int index = 0;

    void setCards(List<T> cards) {
        cards.addAll(cards);
    }

    int getRemainedCard() {
        return cards.size() - dealtCard;
    }

    void initializeDeck() {
        cards.stream().forEach(card -> card.markAvailable());
    }

    void shuffle() {
        for (T card : cards) {
            if(Math.random() > 0.5) {
                cards.remove(card);
                cards.add(card);
            }
        }
    }

    T giveCard() {
        T card = cards.get(dealtCard);
        card.markUnavailable();
        dealtCard++;
        return card;
    }
}

abstract class CardUser <T extends Card> {
    List<T> cards = new ArrayList<>();

    int getScore() {
        int score = 0;
        for(T card : cards) {
            score += card.getValue();
        }
        return score;
    }

    void addCard(T card) {
        cards.add(card);
    }

    void returnCard() {
        cards.removeAll(cards);
    }
}

class BlackJackCard extends Card {
    BlackJackCard(Number number, Suit suit) {
        super(number, suit);
    }

    int getValue() {
        if(isFaceCard()) {
            return 10;
        } else {
            return number.getValue();
        }
    }

    boolean isAce() {
        return number == Number.Ace;
    }

    boolean isFaceCard() {
        return (number == Number.Jack) || (number == Number.Queen) || (number == Number.King);
    }
}

class BlackJackCardUser extends CardUser<BlackJackCard> {
    int score() {
        List<Integer> possible = getPossibleScores();
        int maxUnder = Integer.MIN_VALUE;
        int minOver = Integer.MAX_VALUE;
        for(Integer i : possible) {
            if (i < minOver && i > 21) {
                minOver = i;
            }
            if (i > maxUnder && i <= 21) {
                maxUnder = i;
            }
        }

        return (maxUnder == Integer.MIN_VALUE)? minOver : maxUnder;
    }

    List<Integer> getPossibleScores() {
        List<Integer> possible = new ArrayList<>();
        possible.add(0);
        for(BlackJackCard card : cards) {
            for (Integer i : possible) {
                possible.remove(i);
                possible.add(i + card.getValue());

                if(card.isAce()) {
                    possible.add(i + 11);
                }
            }
        }
        return possible;
    }

    boolean is21() {
        return score() == 21;
    }

    boolean isBlackJack() {
        return is21() && cards.size() == 2;
    }

    boolean isBust() {
        return score() > 21;
    }
}