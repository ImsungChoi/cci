package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by imsungchoi on 2016. 1. 25..
 */
public class GetWords {
    public static HashMap<String, String> memo = new HashMap<>();
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("abc");
        dict.add("ee");
        dict.add("bb");
        dict.add("aa");
        System.out.println(getWords(dict, "abceebbaa"));
    }

    public static String getWords(Set<String> dict, String input) {
        if(dict.contains(input)) {
            return input;
        }

        if(memo.containsKey(input)) {
            return memo.get(input);
        }

        String ret = null;
        for(int i = 1; i <= input.length(); i++) {
            String s = input.substring(0, i);
            if(dict.contains(s)) {
                String remain = getWords(dict, input.substring(i));
                if (remain != null) {
                    ret = s + " " + remain;
                }
            }
        }

        memo.put(input, ret);
        return ret;
    }
}
