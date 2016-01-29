package problems;

import java.util.Scanner;

/**
 * Created by 1002427 on 2016. 1. 29..
 */
public class Triangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int[][] t = parseInput(input);
        if(t == null) {
            System.out.println("Invalid");
        } else {
            int[][] memo = new int[t.length][t.length];
            for(int i = 0; i < t.length; i++) {
                for(int j = 0; j < t.length; j++) {
                    memo[i][j] = -1;
                }
            }

            maxSum(t, memo, 0);
            int max = 0;
            for(int i = 0; i < memo.length; i++) {
                max = Math.max(memo[memo.length-1][i], max);
            }
            System.out.println(max);
        }
    }

    public static int[][] parseInput(String input) {
        String[] list = input.split("#");
        int n = factorial(list.length);
        if(n == -1) {
            return null;
        }
        int[][] ret = new int[n][n];
        int index = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                ret[i][j] = Integer.parseInt(list[index]);
                index++;
            }
        }

        return ret;
    }

    public static int factorial(int n) {
        int sum = 0;
        int index = 0;
        while(sum < n) {
            index++;
            sum = sum + index;
        }

        if(sum != n) {
            return -1;
        }
        return index;
    }

    public static void maxSum(int[][] t, int[][] memo, int level) {
        if(level >= t.length) {
            return;
        }
        for(int i = 0; i <= level; i++) {
            memo[level][i] = t[level][i];
            int before = 0;
            if(isValid(i, level-1)) {
                before = Math.max(before, memo[level-1][i]);
            }
            if(isValid(i-1, level-1)) {
                before = Math.max(before, memo[level-1][i-1]);
            }
            memo[level][i] += before;
        }
        maxSum(t, memo, level+1);
    }

    public static boolean isValid(int x, int y) {
        if(x < 0 || y < 0 || x > y) {
            return false;
        }
        return true;
    }
}
