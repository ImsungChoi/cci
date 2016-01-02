package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 */
public class prob5_1 {
    public static void main(String[] args) {
        int N = Integer.parseInt("10000000000", 2);
        int M = Integer.parseInt("10011", 2);
        int i = 2;
        int j = 6;

        int ret = insert(N, M, i, j);
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(M));
        System.out.println(Integer.toBinaryString(ret));
    }

    public static int insert(int N, int M, int i, int j) {
        int allOnes = ~0;

        int left = allOnes << (j+1);
        int right = (1 << i) - 1;
        int mask = left | right;

        return (N & mask) | M << i;
    }
}
