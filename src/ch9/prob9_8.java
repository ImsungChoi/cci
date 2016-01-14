package ch9;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_8 {
    static int[][] memo = new int[4][10001];
    static int[] money = {25, 10, 5, 1};
    public static void main(String[] args) {
        for(int i = 0; i < 4; i++) {
            for (int j = 0; j < 10001; j++) {
                memo[i][j] = 0;
            }
        }
        System.out.println(calc(10000, 0));
    }

    public static int calc(int n, int level) {
        if(n < 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        if(level == 3) {
            return 1;
        }

        if(memo[level][n] != 0) {
            return memo[level][n];
        }

        int ret = 0;
        for (int i = 0; i <= (n / money[level]); i++) {
            ret += calc(n - i * money[level], level + 1);
        }
        memo[level][n] = ret;
        return ret;
    }
}
