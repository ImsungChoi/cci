package ch9;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Pack200;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_3 {

    public static void main(String[] args) {
        int[] array = new int[100];
        for(int i = 0; i < 100; i++) {
            array[i] = 33;
        }
        array[34] = 34;
        array[88] = 88;

        List<Integer> magic = new ArrayList<>();
        getMagicIndex(array, 0, magic);
        magic.stream().forEach(System.out::println);
    }

    public static void getMagicIndex(int[] array, int index, List<Integer> magic) {
        if (array.length <= index) {
            return;
        }

        if (array[index] == index) {
            magic.add(index);
            getMagicIndex(array, index + 1, magic);
        } else {
            if (magic.contains(array[index])) {
                getMagicIndex(array, index + 1, magic);
            } else {
                getMagicIndex(array, array[index], magic);
            }
        }
    }
}
