package ch18;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 25..
 */
public class prob18_7 {

    static String max = "";
    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        str.add("cat");
        str.add("banana");
        str.add("dog");
        str.add("nana");
        str.add("walk");
        str.add("walker");
        str.add("dogwalker");
        int maxSize = Integer.MIN_VALUE;
        for(String s : str) {
            if(s.length() > maxSize) {
                maxSize = s.length();
            }
        }
        //make(str, maxSize, 0, "");
        System.out.println(longestWord(str));
    }

    public static String longestWord(List<String> str) {
        HashMap<String, Boolean> map = new HashMap<>();
        for (String s : str) {
            map.put(s, true);
        }
        Collections.sort(str, (s1, s2) -> (s1.length() > s2.length())? -1 : 1);
        for (String s : str) {
            if (canBuild(s, true, map)) {
                return s;
            }
        }
        return "";
    }

    public static boolean canBuild(String str, boolean is, HashMap<String, Boolean> map) {
        if(map.containsKey(str) && !is) {
            return map.get(str);
        }

        for(int i = 1; i < str.length(); i++) {
            String left = str.substring(0, i);
            String right = str.substring(i);
            if(map.containsKey(left) && map.get(left) == true && canBuild(right, false, map)) {
                return true;
            }
        }
        map.put(str, false);
        return false;
    }

    public static void make(List<String> str, int maxSize, int numOfWords, String s) {
        if(s.length() > maxSize) {
            return;
        }

        if(str.contains(s)){
            if(numOfWords > 1) {
                if(s.length() > max.length()) {
                    max = s;
                }
            }
        }

        for(int i = 0; i < str.size(); i++) {
            make(str, maxSize, numOfWords+1, s + str.get(i));
        }
    }
}
