package ch18;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 28..
 */
public class prob18_10 {
    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        String s1 = "DAMP";
        String s2 = "LIKE";

        dict.add(s1);
        dict.add(s2);
        dict.add("DAXT");
        dict.add("DWQA");
        dict.add("LAMP");
        dict.add("LEMO");
        dict.add("DEAD");
        dict.add("LIMP");
        dict.add("LIME");
        Queue<String> ret = new LinkedList<>();
        List<Boolean> changed = new ArrayList<>();
        for(int i = 0; i < s1.length(); i++) {
            changed.add(false);
        }

        getTransformationMap(dict, s1, s2, ret, changed);
        for(String s : ret) {
            System.out.print(s + " ");
        }
    }

    public static boolean getTransformationMap(Set<String> dict, String s1, String s2, Queue<String> ret,
                                               List<Boolean> changed) {
        if(s1.length() != s2.length()) {
            return false;
        }

        if(!dict.contains(s1)) {
            return false;
        } else {
            ret.offer(s1);
            if(isAllTrue(changed)) {
                return true;
            }
        }

        for(int i = 0; i < s1.length(); i++) {
            if(changed.get(i)) {
                continue;
            }
            changed.set(i, true);
            String transformed = getTransformedString(s1, s2, i);
            if(getTransformationMap(dict, transformed, s2, ret, changed)) {
                return true;
            }
            changed.set(i, false);
        }
        ret.poll();
        return false;
    }

    public static String getTransformedString(String s1, String s2, int i) {
        return s1.substring(0, i) + s2.substring(i, i + 1) + s1.substring(i + 1, s1.length());
    }

    public static boolean isAllTrue(List<Boolean> changed) {
        for(boolean c : changed) {
            if(!c) {
                return false;
            }
        }
        return true;
    }
}
