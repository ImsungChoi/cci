package problems;

/**
 * Created by 1002427 on 2016-01-22.
 */
public class FindNValue {
    public static void main(String[] args) {
        int[] array = {1,1,3,3,4,4,5,5,6,6,6,6,6,6,6};
        System.out.println(findQuater(array));
    }

    public static int findHalf(int[] array) {
        return find(array, 0, array.length-1);
    }

    public static int findQuater(int[] array) {
        int median = (0 + array.length-1) / 2;
        int ret = find(array, 0, median);

        if(ret != -1) {
            return ret;
        }

        ret = find(array, (0+median)/2, (median+array.length-1)/2);
        if(ret != -1) {
            return ret;
        }

        ret = find(array, median, array.length-1);
        return ret;
    }

    public static int find(int[] array, int start, int end) {
        int median = (start + end) / 2;

        if(array[start] == array[median] || array[median] == array[end]) {
            return array[median];
        }
        int left = (start + median) / 2;
        int right = (median + end) / 2;

        if(array[left] == array[median] && array[median] == array[right]) {
            return array[median];
        }
        return -1;
    }

}