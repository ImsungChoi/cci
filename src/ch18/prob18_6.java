package ch18;

/**
 * Created by imsungchoi on 2016. 1. 25..
 */
public class prob18_6 {
    public static void main(String[] args) {
        int[] a = {3, 3, 43 ,22, 45, 56, 76, 4, 5, 6, 75, 48, 65, 76, 32, 77};
        sort(a, 0, a.length-1, 6);
        for(int i : a) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] a, int start, int end, int m) {
        if(start >= end) {
            return;
        }

        int i = partition(a, start, end);
        if (i == m) {
            return;
        }

        if(i > m) {
            sort(a, start, i-1, m);
        } else {
            sort(a, i+1, end, m);
        }
    }

    public static int partition(int[] a, int start, int end) {
        int pivot = a[end];

        int d = start-1;
        for(int i = start; i < end; i++) {
            if(a[i] <= pivot) {
                d++;
                swap(a, i, d);
            }
        }
        d++;
        swap(a, end, d);
        return d;
    }

    public static void swap(int[] a, int i , int d) {
        int temp = a[i];
        a[i] = a[d];
        a[d] = temp;
    }
}
