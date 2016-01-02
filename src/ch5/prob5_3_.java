package ch5;

/**
 * Created by imsungchoi on 2016. 1. 2..
 *
 * 정수 n이 주어졌을 때 같은 수의 비트를 가지는 수 중에서 n의 좌우 경계값
 */
public class prob5_3_ {
    public static void main(String[] args) {
        int num = 343;
        System.out.println(Integer.toBinaryString(num));
        System.out.println(Integer.toBinaryString(getPrev(num)));
        System.out.println(getPrev(num));
        System.out.println(Integer.toBinaryString(getNext(num)));
        System.out.println(getNext(num));
    }

    public static int getPrev(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;

        while((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        while((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        int p = c0 + c1;
        if (p == 0 || p == 31) {
            return 0;
        }

        //bit manipulation
        num &= ((~0) << (p + 1));
        num |= ((1 << (c1 + 1)) - 1) << (c0 - 1);

        return num;
    }

    public static int getNext(int num) {
        int c = num;
        int c0 = 0;
        int c1 = 0;

        while((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        while((c & 1) == 1) {
            c1++;
            c >>= 1;
        }
        int p = c0 + c1;
        if(p == 0 || p == 31) {
            return 0;
        }

        //bit manipulation
        num |= (1 << p);
        num &= ~((1 << p) - 1);
        num |= (1 << (c1 - 1)) - 1;

        return num;
    }
}
