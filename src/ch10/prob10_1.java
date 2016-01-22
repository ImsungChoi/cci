package ch10;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_1 {
    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = new int[5];
        for(int i = 0; i < 5; i++) {
            a[i] = i;
        }

        for(int i = 0; i < 10; i += 2) {
            b[i/2] = i;
        }
        mergeTwoSoredArray(a, 5, b, 5);
        for(int i : a) {
            System.out.println(i);
        }
    }

    public static void mergeTwoSoredArray(int[] a, int aLen, int[] b, int bLen) {
        int mergedIndex = aLen + bLen - 1;
        aLen--;
        bLen--;

        while(mergedIndex >= 0) {
            if ((aLen >= 0 && bLen < 0) || (a[aLen] > b[bLen])) {
                a[mergedIndex] = a[aLen];
                aLen--;
            } else if ((aLen < 0 && bLen >= 0) || (a[aLen] <= b[bLen])) {
                a[mergedIndex] = b[bLen];
                bLen--;
            }
            mergedIndex--;
        }
    }
}
