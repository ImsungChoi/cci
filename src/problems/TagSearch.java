package problems;

import java.util.*;

/**
 * Created by 1002427 on 2016. 1. 11..
 */
public class TagSearch {
    public static void main(String[] args) {
        HashMap<String, Set<String>> map = new HashMap<>();

        Set<String> google = new HashSet<>();
        google.add("안드로이드");
        google.add("검색");
        google.add("모바일");
        putTags(map, google, "구글");

        Set<String> apple = new HashSet<>();
        apple.add("iOS");
        apple.add("모바일");
        apple.add("맥북");
        putTags(map, apple, "애플");

        Set<String> input = new HashSet<>();
        input.add("iOS");
        input.add("모바일");
        System.out.println(getSearchResults(map, input));
        input.clear();
        input.add("모바일");
        System.out.println(getSearchResults(map,input));
    }

    public static void putTags(Map<String, Set<String>> map, Set<String> tags, String result) {
        if(tags.isEmpty() || result == null) {
            return;
        }

        for (String tag : tags) {
            if (!map.containsKey(tag)) {
                Set<String> set = new HashSet<>();
                set.add(result);
                map.put(tag, set);
            } else {
                if (!map.get(tag).contains(result)) {
                    map.get(tag).add(result);
                }
            }
        }
    }

    public static Set<String> getSearchResults(Map<String, Set<String>> map, Set<String> tags) {
        if (map.isEmpty()) {
            return null;
        }

        Set<String> ret = new HashSet<>();
        for(String tag : tags) {
            if(!map.containsKey(tag)) {
                return null;
            }
            intersectSet(ret, map.get(tag));
        }

        return ret;
    }

    public static void intersectSet(Set<String> target, Set<String> set) {
        if (target.isEmpty()) {
            target.addAll(set);
        }
        else {
            target.retainAll(set);
        }
    }
}
