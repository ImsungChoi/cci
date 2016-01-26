package ch18;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1002427 on 2016. 1. 25..
 */
public class prob18_5 {
    public static void main(String[] args) {
        String target = "abc dad aewq ad fadb dab dd adad dad ss da ss aa dfqw " +
                "ad dda dad d f bad aa ad afda aa dada dda dad ss aaaa d a ad qwe dafdaf dad da qf";
        String s1 = "dad";
        String s2 = "aa";

        System.out.println(getMinDistance(target, s1, s2));
    }

    public static boolean contain(char[] target, int start, char[] c) {
        if(target.length < start + c.length){
            return false;
        }

        if(start != 0 && target[start-1] != ' ') {
            return false;
        }

        if(start+c.length != target.length && target[start + c.length] != ' ') {
            return false;
        }

        int index = 0;
        for(int i = start; i < start + c.length; i++) {
            if(target[i] != c[index]) {
                return false;
            }
            index++;
        }

        return true;
    }

    public static int getMinDistance(String target, String s1, String s2) {
        char[] c = target.toCharArray();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        List<Integer> t1 = new ArrayList<>();
        List<Integer> t2 = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < c.length; i++) {
            if(contain(c, i, c1)) {
                t1.add(i + c1.length - 1);
                if(!t2.isEmpty()) {
                    int d = i - t2.get(t2.size() - 1) - 1;
                    min = Math.min(d, min);
                }
            }

            if(contain(c, i, c2)) {
                t2.add(i + c2.length - 1);
                if(!t1.isEmpty()) {
                    int d = i - t1.get(t1.size() - 1) - 1;
                    min = Math.min(d, min);
                }
            }
        }
        return min;
    }
}
