package ch18;

/**
 * Created by imsungchoi on 2016. 1. 25..
 */
public class prob18_1 {
    public static void main(String[] args) {
        System.out.println(add(1, -99));
    }

    public static int plus(int a, int b) {
        int ret = 0;
        int ut = 0;
        for(int i = 0; i < 32; i++) {
            int at = (a >>> i) & 1;
            int bt = (b >>> i) & 1;
            int v = (at|bt|ut)==0 ? 0 : at ^ bt ^ ut;
            ut = (at & bt) | (bt & ut) | (at & ut);
            ret |= (v << i);
        }
        return ret;
    }

    public static int add(int a, int b) {
        if(b == 0) {
            return a;
        }

        int sum = a ^ b;
        int carry = (a & b) << 1;
        return add(sum, carry);
    }
}
