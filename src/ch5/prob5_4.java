package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 *
 * (n & (n -1)) == 0 의 의미
 */
public class prob5_4 {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(8));
    }

    public static boolean isPowerOfTwo(int n) {
        return (n & (n - 1)) == 0;
    }
}
