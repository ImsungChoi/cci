package ch9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_5 {
    public static void main(String[] args) {
        getPermutation("abc").stream().forEach(System.out::println);
    }

    public static List<String> getPermutation(String str) {
        List<String> ret = new ArrayList<>();

        if(str.length() == 1) {
            ret.add(str);
            return ret;
        }

        String s = str.substring(0, 1);
        String remainder = str.substring(1);
        List<String> list = getPermutation(remainder);
        for(String target : list) {
            for(int i = 0; i <= target.length(); i++) {
                ret.add(getInsertStr(target, s, i));
            }
        }
        return ret;
    }

    public static String getInsertStr(String target, String s, int insertPosition) {
        return target.substring(0, insertPosition) + s + target.substring(insertPosition);
    }
}
