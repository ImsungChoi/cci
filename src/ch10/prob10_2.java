package ch10;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 18..
 */
public class prob10_2 {
    public static void main(String[] args) {
        String[] strings = {"abcd", "dbca", "aaaa", "dddb", "abcc", "cadb", "abca"};
        sortStrings(strings);

        for(String s : strings) {
            System.out.println(s);
        }
        System.out.println("===============");
        HashMap<String, List<String>> map = bucketSort(strings);
        for(String key : map.keySet()) {
            for(String str : map.get(key)) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    public static void sortStrings(String[] strings) {
        Arrays.sort(strings, new AnagramComaprator());
    }

    public static HashMap<String, List<String>> bucketSort(String[] strings) {
        HashMap<String, List<String>> bucket = new HashMap<>();
        for(String s : strings) {
            String key = sortChars(s);
            if(bucket.containsKey(key)) {
                bucket.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                bucket.put(key, list);
            }
        }
        return bucket;
    }

    public static String sortChars(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}

class AnagramComaprator implements Comparator<String> {
    public String sortChars(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(s);
    }

    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}
