package ch10;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_3 {
    public static void main(String[] args) {
        int[] rotated = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        System.out.println(binarySearchWithRotatedArray(rotated, 0, rotated.length-1, 5));
    }

    public static int binarySearchWithRotatedArray(int[] rotated, int start, int end, int target) {
        if(start > end) {
            return -1;
        }

        int median = (start + end) / 2;
        if(rotated[median] == target) {
            return median;
        }
        int ret = 0;

        if(rotated[start] < rotated[median]) {
            if(rotated[start] <= target && target < rotated[median]) {
                return binarySearchWithRotatedArray(rotated, start, median-1, target);
            } else {
                return binarySearchWithRotatedArray(rotated, median+1, end, target);
            }
        } else if(rotated[start] > rotated[median]) {
            if(rotated[median] < target && target < rotated[end]) {
                return binarySearchWithRotatedArray(rotated, median+1, end, target);
            } else {
                return binarySearchWithRotatedArray(rotated, start, median-1, target);
            }
        } else if(rotated[start] == rotated[median]) {
            if(rotated[median] != rotated[end]) {
                binarySearchWithRotatedArray(rotated, median+1, end, target);
            } else {
                ret = binarySearchWithRotatedArray(rotated, start, median-1, target);

                if(ret != -1) {
                    ret = binarySearchWithRotatedArray(rotated, median+1, end, target);
                }
                return ret;
            }
        }

        return -1;
    }
}
