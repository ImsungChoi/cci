package ch9;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_8 {
    static int[] memo = new int[1000];
    static int[] money = {1, 5, 10, 25};
    public static void main(String[] args) {
        for(int i = 0; i < 1000; i++) {
            memo[i] = 0;
        }
        System.out.println(calc(7, 0));
    }

    public static int calc(int n, int level) {
        if (level == 4) {
            return 0;
        }

        if(n < 0) {
            return 0;
        }

        if(n == 0) {
            return 1;
        }

        int ret = 0;

        for(int i = 0; i < n / money[level]; i++) {
            ret += calc(n - i * money[level], level);
            ret += calc(n - i * money[level], level + 1);
        }

        return ret;
    }
}
