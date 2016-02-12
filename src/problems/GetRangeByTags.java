package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//        for(Tag t :getTags(map, tags)) {
//            System.out.println("[" + t.start + ", " + t.end + "]");
//        }

        List<Interval> intervals = new ArrayList<>();
        Interval i1 = new Interval();
        i1.start = 23;
        i1.end = 72;
        i1.tag = "0";
        Interval i2 = new Interval();
        i2.start = 100;
        i2.end = 128;
        i2.tag = "0";
        Interval i3 = new Interval();
        i3.start = 34;
        i3.end = 53;
        i3.tag = "1";
        Interval i4 = new Interval();
        i4.start = 114;
        i4.end = 145;
        i4.tag = "1";
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        IntervalTree tree = new IntervalTree();
        tree.insertIntervalNode(intervals);
        Map<String, Boolean> b = new HashMap<>();
        b.put("0", false);
        b.put("1", false);
        List<Interval> ret = new ArrayList<>();
        tree.searchByTag(tree.root, b, ret);

        for(Interval i : ret) {
            System.out.println("[" + i.start + ", " + i.end + ", " + i.tag + "]");
        }

        //tree.traversal(tree.root);
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

class IntervalTree {
    IntervalNode root;

    public IntervalTree() {

    }

    public void insertIntervalNode(List<Interval> intervals) {
        for(Interval interval : intervals) {
            IntervalNode leftNode = new IntervalNode(interval.start);
            IntervalNode rightNode = new IntervalNode(interval.end);
            insertNode(root, leftNode);
            insertNode(root, rightNode);
        }

        for(Interval interval : intervals) {
            insertInterval(root, interval.start, interval.end, Integer.MIN_VALUE, Integer.MAX_VALUE, interval.tag);
        }
    }

    public void insertNode(IntervalNode target, IntervalNode n) {
        if(root == null) {
            root = n;
        } else {
            if (target.val > n.val) {
                if (target.left == null) {
                    target.left = n;
                } else {
                    insertNode(target.left, n);
                }
            } else {
                if (target.right == null) {
                    target.right = n;
                } else {
                    insertNode(target.right, n);
                }
            }
        }
    }

    public void searchByTag(IntervalNode n, Map<String, Boolean> map, List<Interval> ret) {
        if(n == null) {
            return;
        }

        List<String> tags = new ArrayList<>();

        for(Interval interval : n.intervals) {
            if(map.containsKey(interval.tag)) {
                map.put(interval.tag, true);
                tags.add(interval.tag);
            }

            if(allTrue(map)) {
                ret.add(interval);
            }
        }

        searchByTag(n.left, map, ret);
        searchByTag(n.right, map, ret);

        for(String tag : tags) {
            map.put(tag, false);
        }
    }

    public void search(IntervalNode n, int k, List<Interval> ret) {
        while(n != null) {
            ret.addAll(n.intervals);
            if(k < n.val) {
                n = n.left;
            } else {
                n = n.right;
            }
        }
    }

    public void insertInterval(IntervalNode target, int start, int end, int min, int max, String tag) {
        if (start <= min && max <= end) {
            Interval i = new Interval();
            i.start = min;
            i.end = max;
            i.tag = tag;
            target.intervals.add(i);
        } else {
            if (start < target.val) {
                if(target.left == null && target.val != 0) {
                    IntervalNode n = new IntervalNode(0);
                    target.left = n;
                    insertInterval(target.left, start, end, min, target.val, tag);
                } else {
                    insertInterval(target.left, start, end, min, target.val, tag);
                }
            }

            if (end > target.val) {
                if(target.right == null && target.val != 0) {
                    IntervalNode n = new IntervalNode(0);
                    target.right = n;
                    insertInterval(target.right, start, end, target.val, max, tag);
                } else {
                    insertInterval(target.right, start, end, target.val, max, tag);
                }
            }
        }
    }

    public boolean allTrue(Map<String, Boolean> map) {
        boolean ret = true;
        for(String s : map.keySet()) {
            if(!map.get(s)) {
                ret = false;
            }
        }
        return ret;
    }

    public void traversal(IntervalNode n) {
        if(n.left != null) {
            traversal(n.left);
        }

        for(Interval i : n.intervals) {
            System.out.println("[" + i.start + ", " + i.end + ", " + i.tag + "]");
        }

        if(n.right != null) {
            traversal(n.right);
        }
    }
}

class IntervalNode {
    int val;
    IntervalNode left;
    IntervalNode right;
    List<Interval> intervals;

    public IntervalNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.intervals = new ArrayList<>();
    }
}

class Interval {
    int start;
    int end;
    String tag;
}