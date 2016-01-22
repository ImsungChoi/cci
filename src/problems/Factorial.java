package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1002427 on 2016-01-19.
 */
public class Factorial {
    public static void main(String[] args) {
        int outBound = 0;
        int[] memo = getFactorial();

        for(int i : memo) {
            outBound += i;
        }

        int n = 10;
        int ret = 0;
        while (n < memo[9] * 15) {
            if(n == calc(memo, n)) {
                ret += n;
            }
            n++;
        }

        System.out.println(ret);
    }

    public static int calc(int[] memo, int n) {
        int ret = 0;
        while (n > 0) {
            ret += memo[n % 10];
            n /= 10;
        }
        return ret;
    }

    public static int[] getFactorial() {
        int[] memo = new int[10];
        for(int i = 0; i < 10; i++) {
            memo[i] = factorial(i);
        }
        return memo;
    }

    public static int factorial(int n) {
        int ret = 1;
        for(int i = 1; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }
}
