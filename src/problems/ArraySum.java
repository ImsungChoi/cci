package problems;

/**
 * Created by 1002427 on 2016. 1. 29..
 */
public class ArraySum {
    public static void main(String[] args) {
        int[] a = {9, 9, 2};
        int[] b = {0, 1, 3};
        int[] c = sumTwoArray(a, b);
        print(a);
        print(b);
        print(c);

    }

    public static int[] sumTwoArray(int[] a, int[] b) {
        int len = Math.max(a.length, b.length);
        int[] c = new int[len];
        int carry = 0;

        for(int i = 0; i < len; i++) {
            int t1 = getBit(a, a.length - i - 1);
            int t2 = getBit(b, b.length - i - 1);
            int ret = t1 + t2 + carry;

            if(ret >= 10) {
                ret -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            c[len - i - 1] = ret;
        }

        if (carry == 1) {
            int[] ret = new int[len+1];
            ret[0] = 1;
            System.arraycopy(c, 0, ret, 1, len);
            return ret;
        }
        return c;
    }

    public static int getBit(int[] a, int index) {
        if(index < 0) {
            return  0;
        }

        return a[index];
    }

    public static void print(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
