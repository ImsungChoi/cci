package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_1 {
    public static void main(String[] args) {
        int[] v = {6, 2};

        System.out.println(v[0] + " " + v[1]);
        swap2(v);
        System.out.println(v[0] + " " + v[1]);

    }

    public static void swap(int[] v) {
        v[0] = v[0] - v[1];
        v[1] = v[1] + v[0];
        v[0] = v[1] - v[0];
    }

    public static void swap2(int[] v) {
        v[0] = v[0] ^ v[1];
        v[1] = v[0] ^ v[1];
        v[0] = v[0] ^ v[1];
    }
}
