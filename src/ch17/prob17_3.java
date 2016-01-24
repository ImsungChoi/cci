package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_3 {
    public static void main(String[] args) {
        System.out.println(factorial(15));
        System.out.println(countFactZeros(15));
    }

    public static long factorial(int n) {
        long ret = 1;
        for(int i = 2; i <= n; i++) {
            ret *= i;
        }
        return ret;
    }

    public static int countFactZeros(int n) {
        if(n < 0) {
            return 0;
        }
        int ret = 0;
        for(int i = 5; n/i > 0; i *= 5) {
            ret += n/i;
        }
        return ret;
    }
}
