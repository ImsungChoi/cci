package ch18;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1002427 on 2016. 1. 25..
 */
public class prob18_2 {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            for(int c : getRandomDeck2()) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public static int[] getRandomDeck2() {
        int[] deck = new int[52];
        for(int i = 0; i < 52; i++) {
            deck[i] = i;
        }

        for(int i = 52; i > 0; i--) {
            int picked = (int) (i * rand());
            swap(deck, picked, i-1);
        }

        return deck;
    }

    public static void swap(int[] deck, int a, int b) {
        int temp = deck[a];
        deck[a] = deck[b];
        deck[b] = temp;
    }

    public static List<Integer> getRandomDeck(){
        List<Integer> deck = new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 52; i++) {
            deck.add(i);
        }

        for(int i = 52; i > 0; i--) {
            Integer card = deck.get((int) (i * rand()));
            deck.remove(card);
            ret.add(card);
        }
        return ret;
    }

    public static double rand() {
        return Math.random();
    }
}
