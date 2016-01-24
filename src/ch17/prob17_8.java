package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_8 {
    public static void main(String[] args) {
        int[] a = {2, -8, 3, -2, 4, -10};
        System.out.println(getMaxSequence(a));
    }

    public static int getMaxSequence(int[] a) {
        int max = Integer.MIN_VALUE;
        int value = 0;
        for(int i = 0; i < a.length; i++) {
            if(value + a[i] > 0) {
                value += a[i];
            } else {
                value = 0;
            }
            max = Math.max(value, max);
        }
        return max;
    }
}
