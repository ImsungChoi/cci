package ch9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_5 {
    public static void main(String[] args) {
        getAllPermutationSet("abc").stream().forEach(System.out::println);
    }

    public static List<String> getAllPermutationSet(String str) {
        List<String> ret = new ArrayList<>();
        ret.add(str.substring(0, 1));

        for(int i = 1; i < str.length(); i++) {
            ret = getStringSets(ret, str.substring(i, i + 1));
        }

        return ret;
    }

    public static List<String> getStringSets(List<String> list, String s) {
        List<String> ret = new ArrayList<>();

        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            for(int j = 0; j <= str.length(); j++) {
                ret.add(getAddCharToString(str, s, j));
            }
        }

        return ret;
    }

    public static String getAddCharToString(String target, String s, int insertPosition) {
        String ret = "";

        int index = 0;
        for(int i = 0; i <= target.length(); i++) {
            if (i == insertPosition) {
                ret += s;
            } else {
                ret += target.substring(index, index + 1);
                index++;
            }
        }
        return ret;
    }
}
