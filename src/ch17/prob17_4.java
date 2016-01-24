package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_4 {
    public static void main(String[] args) {
        System.out.println(max(-56, -6));
    }

    public static int max(int a, int b) {
        int asign = flip((sign(a) ^ sign(b))) * sign(a-b) + (sign(a) ^ sign(b)) * sign(a);
        int bsign = flip((sign(a) ^ sign(b))) * sign(b-a) + (sign(a) ^ sign(b)) * sign(b);

        return asign * a + bsign * b;
    }

    public static int flip(int i) {
        return i^1;
    }

    public static int sign(int i) {
        return flip((i & (1 << 31)) >>> 31);
    }
}
