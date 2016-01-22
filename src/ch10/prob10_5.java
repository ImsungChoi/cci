package ch10;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_5 {
    public static void main(String[] args) {
        String[] strings = {"at", "", "", "", "ball", "", "", "car", "", "", "", "dad", ""};
        System.out.println(searchWordWithEmptyString(strings, 0, strings.length-1, "ball"));
    }

    public static int searchWordWithEmptyString(String[] strings, int start, int end, String target) {
        if(start > end) {
            return -1;
        }

        int median = (start+end) / 2;
        if (strings[median].equals(target)) {
            return median;
        } else {
            if(strings[median].equals("")) {
                int leftIndex = getLeftIndex(strings, median);
                int rightIndex = getRightIndex(strings, median);
                if (leftIndex != -1 && rightIndex != -1) {
                    if(strings[leftIndex].compareTo(target) >= 0) {
                        return searchWordWithEmptyString(strings, start, leftIndex, target);
                    } else if(strings[rightIndex].compareTo(target) <= 0) {
                        return searchWordWithEmptyString(strings, rightIndex, end, target);
                    }
                }

                if (leftIndex != -1) {
                    return searchWordWithEmptyString(strings, start, leftIndex, target);
                } else if (rightIndex != -1) {
                    return searchWordWithEmptyString(strings, rightIndex, end, target);
                }
            } else {
                if(strings[median].compareTo(target) > 0) {
                    return searchWordWithEmptyString(strings, start, getLeftIndex(strings, median -1), target);
                } else {
                    return searchWordWithEmptyString(strings, start, getRightIndex(strings, median+1), target);
                }
            }
        }

        return -1;
    }

    public static int getLeftIndex(String[] strings, int index) {
        while(strings[index].equals("")) {
            index--;
            if(index < 0) {
                return -1;
            }
        }
        return index;
    }

    public static int getRightIndex(String[] strings, int index) {
        while(strings[index].equals((""))) {
            index++;
            if(index >= strings.length) {
                return -1;
            }
        }
        return index;
    }
}
