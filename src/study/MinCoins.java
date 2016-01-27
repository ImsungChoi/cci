package study;

/**
 * Created by imsungchoi on 2016. 1. 27..
 */
public class MinCoins {
    public static void main(String[] args) {
        int[] coins = {25, 10, 5, 1};
        int sum = 20340;
        int[][] memo = new int[coins.length][sum+1];
        for(int i = 0; i < coins.length; i++) {
            for(int j = 0; j < sum+1; j++) {
                memo[i][j] = -1;
            }
        }

        System.out.println(getMinCoins(memo, coins, sum, 0));
    }

    public static int getMinCoins(int[][] memo, int[] coins, int sum, int index) {
        if(sum < 0) {
            return -1;
        }

        if(sum == 0) {
            return 0;
        }

        if(index >= coins.length) {
            return -1;
        }

        if(memo[index][sum] != -1) {
            return memo[index][sum];
        }


        int min = Integer.MAX_VALUE;
        for(int i = sum / coins[index]; i >=0; i--) {
            int r = getMinCoins(memo, coins, sum - (i * coins[index]), index + 1);
            if(r >= 0) {
               min = Math.min(min, r + i);
            }
        }
        memo[index][sum] = min;
        return min;
    }
}
