package study;

/**
 * Created by imsungchoi on 2016. 1. 27..
 */
public class MinCoins {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        int sum = 20340;
        int[] memo = new int[sum+1];
        for(int i = 0; i < sum+1; i++) {
            memo[i] = Integer.MAX_VALUE-1;
        }

        System.out.println(getMinCoins(memo, coins, sum));
    }

    public static int getMinCoins(int[] memo, int[] coins, int sum) {
        if(sum < 0) {
            return Integer.MAX_VALUE-1;
        }

        if(sum == 0) {
            return 0;
        }

        if(memo[sum] != Integer.MAX_VALUE-1) {
            return memo[sum];
        }


        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            min = Math.min(min, 1 + getMinCoins(memo, coins, sum-coins[i]));
        }
        memo[sum] = min;
        return min;
    }
}
