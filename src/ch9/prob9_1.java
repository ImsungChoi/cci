package ch9;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_1 {
    static int[] memo = new int[100];

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            memo[i] = 0;
        }

        System.out.println(calcWay(99));
    }

    public static int calcWay(int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if(memo[n] != 0) {
            return memo[n];
        }

        memo[n] = calcWay(n-1) + calcWay(n-2) + calcWay(n-3);
        return memo[n];
    }
}
