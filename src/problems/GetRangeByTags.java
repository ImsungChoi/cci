package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 17..
 */
public class GetRangeByTags {
    public static void main(String[] args) {
        HashMap<Integer, List<Tag>> map = new HashMap<>();
        Tag t1 = new Tag();
        Tag t2 = new Tag();
        Tag t3 = new Tag();
        t1.start = 23;
        t1.end = 72;
        t2.start = 100;
        t2.end = 128;
        t3.start = 34;
        t3.end = 53;
        List<Tag> zero = new ArrayList<>();
        zero.add(t1);
        zero.add(t2);
        List<Tag> one = new ArrayList<>();
        one.add(t3);
        map.put(0, zero);
        map.put(1, one);

        List<Integer> tags = new ArrayList<>();
        tags.add(0);
        tags.add(1);

        for(Tag t :getTags(map, tags)) {
            System.out.println("[" + t.start + ", " + t.end + "]");
        }
    }

    public static List<Tag> getTags(HashMap<Integer, List<Tag>> map, List<Integer> tags) {
        if (tags.size() == 0) {
            return null;
        }

        if (tags.size() == 1) {
            return map.get(tags.get(0));
        }

        List<Tag> ret = new ArrayList<>();
        for(Integer tag : tags) {
            if(map.get(tag) == null) {
                return null;
            }

            if (ret.isEmpty()) {
                for(Tag t : map.get(0)) {
                    Tag n = new Tag();
                    n.start = t.start;
                    n.end = t.end;
                    ret.add(n);
                }
            } else {
                ret = getIntersectTags(ret, map.get(tag));
            }
        }
        return ret;
    }

    public static List<Tag> getIntersectTags(List<Tag> tags1, List<Tag> tags2) {
        List<Tag> ret = new ArrayList<>();

        for(Tag t1 : tags1) {
            for(Tag t2 : tags2) {
                Tag intersect = intersect(t1, t2);
                if(intersect != null) {
                    ret.add(intersect);
                }
            }
        }
        return ret;
    }

    public static Tag intersect(Tag t1, Tag t2) {
        if (t1 == null || t2 == null) {
            return null;
        }

        if (t1.end <= t2.start || t2.end <= t1.start) {
            return null;
        }

        Tag intersect = new Tag();
        if (t1.start <= t2.start && t1.end >= t2.start && t1.end <= t2.end) {
            intersect.start = t2.start;
            intersect.end = t1.end;
            return intersect;
        }

        if (t2.start <= t1.start && t2.end >= t1.start && t2.end <= t1.end) {
            intersect.start = t1.start;
            intersect.end = t2.end;
            return intersect;
        }

        if (t1.start <= t2.start && t1.end >= t2.end) {
            intersect.start = t2.start;
            intersect.end = t2.end;
            return intersect;
        }

        if (t2.start <= t1.start && t2.end >= t1.end) {
            intersect.start = t1.start;
            intersect.end = t2.end;
            return intersect;
        }
        return null;
    }
}

class Tag {
    int start;
    int end;
}
