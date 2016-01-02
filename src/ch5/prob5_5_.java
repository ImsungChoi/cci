package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 */
public class prob5_5_ {
    public static void main(String[] args) {
        int n = 29;
        int m = 15;

        System.out.println(Integer.toBinaryString(n));
        System.out.println(Integer.toBinaryString(m));
        System.out.println(numOfDifferentBit(n, m));
    }

    public static int numOfDifferentBit(int n, int m) {
        int numOfDifferentBit = 0;

        for(int c = n ^ m; c != 0; c = c & (c - 1)) {
            numOfDifferentBit++;
        }

        return numOfDifferentBit;
    }
}
