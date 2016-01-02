package ch5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 2..
 *
 * 0 ~ N 까지의 정수 중에서 빠진 하나의 정수를 찾는 솔루션
 */
public class prob5_7_ {
    public static void main(String[] args) {
        int N = 30;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 30; i++) {
            list.add(i);
        }

        System.out.println(findMissingValue(list, 0));
    }

    public static int findMissingValue(List<Integer> list, int column) {
        if (column > 32) {
            return 0;
        }

        List<Integer> zeros = new ArrayList<>();
        List<Integer> ones = new ArrayList<>();
        int missing = 0;

        for (int i = 0; i < list.size(); i++) {
            if (getBit(list, i, column) == 0) {
                zeros.add(list.get(i));
            } else {
                ones.add(list.get(i));
            }
        }

        if (ones.size() >= zeros.size()) {
            int val = findMissingValue(zeros, column + 1);
            missing = (val << 1);
        } else {
            int val = findMissingValue(ones, column + 1);
            missing = (val << 1) + 1;
        }

        return missing;
    }

    public static int getBit(List<Integer> list, int index, int bit) {
        return (list.get(index) >> bit) & 1;
    }
}
