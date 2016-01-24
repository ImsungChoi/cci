package ch17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by imsungchoi on 2016. 1. 25..
 */
public class prob17_14 {
    public static HashMap<String, String> memo = new HashMap<>();
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("looked");
        dict.add("just");
        dict.add("like");
        dict.add("her");
        dict.add("brother");

        String s = "jesslookedjustliketimherbrotherhajusther";
        System.out.println(getWords(dict, s));
    }

    public static String getWords(Set<String> dict, String s) {
        if(dict.contains(s)) {
            return s;
        }

        if(memo.containsKey(s)) {
            return memo.get(s);
        }

        int min = s.length();
        String ret = s.toUpperCase();
        for(int i = 1; i <= s.length(); i++) {
            String p = s.substring(0, i);
            if(dict.contains(p)) {
                p += " " + getWords(dict, s.substring(i));
            } else {
                p = p.toUpperCase();
                p += " " + getWords(dict, s.substring(i));
            }
            int num = getUpperCaseNum(p);
            if (num < min) {
                min = num;
                ret = p;
            }
        }
        memo.put(s, ret);
        return ret;
    }

    public static int getUpperCaseNum(String s) {
        int ret = 0;
        for(int i = 0; i < s.length(); i++) {
            String temp = s.substring(i, i+1);
            if(temp.equals(temp.toUpperCase())) {
                ret++;
            }
        }
        return ret;
    }
}
