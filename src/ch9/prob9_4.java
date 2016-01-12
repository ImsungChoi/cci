package ch9;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_4 {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i < 10; i++) {
            set.add(i);
        }

        for(Set<Integer> s : getAllSubSet(set)) {
            System.out.println(s);
        }
    }

    public static Set<Set<Integer>> getAllSubSet(Set<Integer> set) {
        Set<Set<Integer>> ret = new HashSet<>();
        ret.add(new HashSet<>());

        for(Integer i : set) {
            getSubSet(ret, i);
        }
        return ret;
    }

    public static void getSubSet(Set<Set<Integer>> set, int i ){
        Set<Set<Integer>> ret = getCopyFrom(set);

        for(Set<Integer> s : ret) {
            s.add(i);
        }

        set.addAll(ret);
    }

    public static Set<Set<Integer>> getCopyFrom(Set<Set<Integer>> set) {
        Set<Set<Integer>> ret = new HashSet<>();
        for(Set<Integer> s : set) {
            Set<Integer> add = new HashSet<>();
            for(Integer integer : s) {
                add.add(integer);
            }
            ret.add(add);
        }
        return ret;
    }
}
