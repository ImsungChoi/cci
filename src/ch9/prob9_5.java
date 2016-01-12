package ch9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_5 {
    public static void main(String[] args) {
        for(String str : getAllPermutationSet("abcd")){
            System.out.println(str);
        }
    }

    public static List<String> getAllPermutationSet(String str) {
        List<String> ret = new ArrayList<>();

        ret.add(str.substring(0, 1));
        for(int i = 1; i < str.length(); i++) {
            ret = getAddString(ret, str.charAt(i));
        }

        return ret;
    }

    public static List<String> getAddString(List<String> list, char c) {
        List<String> ret = new ArrayList<>();
        for(String s : list) {
            for (int i = 0; i < s.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(getSubString(s, i));
                sb.append(c);
                sb.append(s.substring(i));
                ret.add(sb.toString());
            }
        }
        return ret;
    }

    public static String getSubString(String str, int i) {
        if (i == 0) {
            return "";
        }

        return str.substring(i-1, i);
    }
}
