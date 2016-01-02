package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 */
public class BitOperation {
    public static void main(String[] args) {
        System.out.println(clearBitFromITo0(9, 2));
    }

    public static int getBit(int num, int i) {
        return num & (1 << i);
    }

    public static int setBit(int num, int i) {
        return num | (1 << i);
    }

    public static int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
    }

    public static int clearBitFromMSBToI(int num, int i) {
        int mask = (1 << i) - 1;
        return num & mask;
    }

    public static int clearBitFromITo0(int num, int i) {
        int mask = ~(-1 >>> (31 - i));
        return num & mask;
    }

    public static int updateBit(int num, int i, int v) {
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
    }
}
