package ch17;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_6 {
    public static void main(String[] args) {
        int[] a = {12, 2, 4, 7, 10, 3, 7, 12, 6, 7, 16, 18, 19};
        getUnsortedRange(a);
        getUnsortedRangeBetter(a);
    }

    // O(n)
    public static void getUnsortedRangeBetter(int[] a) {
        int left = getLeftIndex(a);

        if(left == -1) {
            return;
        }

        int right = getRightIndex(a);
        int[] m = getMinAndMax(a, left, right);
        left = expandToLeft(a, left, m[0]);
        right = expandToRight(a, right, m[1]);
        System.out.println(left + " " + right);
    }

    public static int expandToLeft(int[] a, int n, int min) {
        int ret = n;
        for(int i = n-1; i >= 0; i--) {
            if(a[i] > min) {
                ret = i;
            }
        }
        return ret;
    }

    public static int expandToRight(int[] a, int m, int max) {
        int ret = m;
        for(int i = m+1; i < a.length; i++) {
            if(a[i] < max) {
                ret = i;
            }
        }
        return ret;
    }

    public static int[] getMinAndMax(int[] a, int start, int end) {
        int[] m = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for(int i = start-1; i <= end+1; i++) {
            if(a[i] < m[0]) {
                m[0] = a[i];
            }
            if(a[i] > m[1]) {
                m[1] = a[i];
            }
        }
        return m;
    }

    public static int getRightIndex(int[] a) {
        for(int i = a.length-1; i > 0; i--) {
            if(a[i] < a[i-1]) {
                return i-1;
            }
        }
        return -1;
    }

    public static int getLeftIndex(int[] a) {
        for(int i = 1; i < a.length; i++) {
            if(a[i-1] > a[i]) {
                return i;
            }
        }
        return -1;
    }

    // O(n2)
    public static void getUnsortedRange(int[] a) {
        int n = -1;
        int m = -1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < a.length; i++) {
            if(n == -1 && check(a, i)) {
                n = i;
            }

            if(n != -1 && a[i] >= max && !check(a, i)) {
                m = i-1;
                break;
            }

            max = Math.max(max, a[i]);
        }

        if(n != -1 && m == -1) {
            m = a.length - 1;
        }

        System.out.println(n + " " + m);
    }

    public static boolean check(int[] a, int index) {
        for(int i = index+1; i < a.length; i++) {
            if(a[index] > a[i]) {
                return true;
            }
        }

        return false;
    }
}
