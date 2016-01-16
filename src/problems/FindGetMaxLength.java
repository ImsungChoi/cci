package problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 17..
 */
public class FindGetMaxLength {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("ABCW");
        list.add("BAZ");
        list.add("FOO");
        list.add("BAR");
        list.add("XTFN");
        list.add("ABCDEF");

        System.out.println(getMaxLengthOfTwoString(list));
    }

    public static int getMaxLengthOfTwoString(List<String> strings) {
        int max = 0;
        for(int i = 0; i < strings.size(); i++) {
            for(int j = i; j < strings.size(); j++) {
                String s1 = strings.get(i);
                String s2 = strings.get(j);

                if(!hasCommonChar(s1, s2)) {
                    int length = s1.length() * s2.length();
                    if(max < length) {
                        max = length;
                    }
                }
            }
        }
        return max;
    }

    public static boolean hasCommonChar(String s1, String s2) {
        for(int i = 0; i < s1.length(); i++) {
            String s = s1.substring(i, i+1);
            if(s2.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
