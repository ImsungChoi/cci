package ch10;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_4 {
    public static void main(String[] args) {
        HashMap<String, Long> dict = new HashMap<>();
        String[] strings = {"a", "a", "b", "c", "d", "d", "a", "b", "d", "a", "x", "y", "z"};
        countingSort(dict, strings);
        for(String s : strings) {
            System.out.println(s);
        }
    }

    public static void countingSort(HashMap<String, Long> dict, String[] strings) {
        List<String> list = new ArrayList<>();
        for(String s : strings) {
            if(dict.containsKey(s)) {
                dict.put(s, dict.get(s)+1);
            } else {
                list.add(s);
                dict.put(s, 1L);
            }
        }
        int index = 0;
        for(String s : list) {
            for(int i = 0; i < dict.get(s); i++) {
                strings[index] = s;
                index++;
            }
        }
    }
}
