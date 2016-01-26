package ch18;

/**
 * Created by 1002427 on 2016. 1. 25..
 */
public class prob18_3 {
    public static void main(String[] args) {
        int[] a = {0,1,2,3,4,5,6,7,8,9};

        for(int x  = 0; x < 100; x++) {
            for (int i : getRandomMValues(a, 2)) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[] getRandomMValues(int[] a, int m) {
        if(a.length < m) {
            return null;
        }

        if(a.length == m) {
            return a;
        }

        int[] ret = new int[m];
        for(int i = a.length; i > (a.length - m); i--) {
            int index = (int) (i * rand());
            ret[a.length-i] = a[index];
            swap(a, index, i-1);
        }
        return ret;
    }

    public static void swap (int[] a, int x, int y) {
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static double rand() {
        return Math.random();
    }
}

