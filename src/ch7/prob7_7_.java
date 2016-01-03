package ch7;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by imsungchoi on 2016. 1. 3..
 */
public class prob7_7_ {
    public static void main(String[] args) {
        System.out.println(getKthValue(5));
    }

    public static int getKthValue(int k) {
        Queue<Integer> threes = new LinkedList<>();
        Queue<Integer> fives = new LinkedList<>();
        Queue<Integer> sevens = new LinkedList<>();

        threes.add(3);
        fives.add(5);
        sevens.add(7);
        int min = 1;

        for (int i = 2; i <= k; i++) {
            int v3 = threes.peek();
            int v5 = fives.peek();
            int v7 = sevens.peek();

            min = Math.min(v3, Math.min(v5, v7));
            if(min == v3) {
                threes.remove();
                threes.add(min * 3);
                fives.add(min * 5);
            } else if (min == v5) {
                fives.remove();
                fives.add(min * 5);
            } else {
                sevens.remove();
            }
            sevens.add(min * 7);
        }

        return min;
    }
}
