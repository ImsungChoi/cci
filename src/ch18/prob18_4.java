package ch18;

/**
 * Created by 1002427 on 2016. 1. 25..
 */
public class prob18_4 {
    public static void main(String[] args) {
        System.out.println(getNumberOfTwo(22));
    }

    public static int getNumberOfTwo(int n) {
        int ret = 0;

        for(int i = 2; i <= n; i++) {
            ret += getTwo(i);
        }
        return ret;
    }

    public static int getTwo(int n) {
        int ret = 0;

        while(n > 0) {
            if (n % 10 == 2) {
                ret++;
            }
            n /= 10;
        }
        return ret;
    }
}
