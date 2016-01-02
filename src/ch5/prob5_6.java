package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 */
public class prob5_6 {
    public static void main(String[] args) {
        int num = 0xa5a5;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(exchangeBits(num)));
    }

    public static int exchangeBits(int num) {
        int oddMask = 0x55555555;
        int evenMask = 0xaaaaaaaa;

        return ((num & oddMask) << 1) | ((num & evenMask) >> 1);
    }
}
