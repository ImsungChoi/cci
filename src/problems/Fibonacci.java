package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1002427 on 2016. 1. 13..
 */
public class Fibonacci {
    static int num = 2;
    static List<Integer> memo = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(getFibonacciNumberThanLess(100));
    }

    public static int getFibonacciNumberThanLess(int n) {
        if (n < 0) {
            return 0;
        }

        if (n <= 2) {
            return n;
        }
        memo.add(0);
        memo.add(1);
        while(getNextFibonacciNumber(memo.size()) < n) {
        }

        return memo.size() - 1;
    }

    public static int getNextFibonacciNumber(int i) {
        memo.add(memo.get(memo.size() - 1) + memo.get(memo.size() - 2));
        return memo.get(memo.size() - 1);
    }

}
