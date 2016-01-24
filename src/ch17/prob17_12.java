package ch17;

import java.util.HashMap;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 24..
 */
public class prob17_12 {
    public static void main(String[] args) {
        int[] a = {3, 4, 6, 3, 5, 8, 3, 9, 1};
        findPair(a, 8);
    }

    public static void findPair(int[] a, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++) {
            if(!map.containsKey(target - a[i])) {
                map.put(target - a[i], 1);
            }

            if(map.containsKey(a[i])) {
                if(map.get(a[i]) == 1 && map.get(target-a[i]) ==1) {
                    System.out.println(a[i] + " " + (target - a[i]));
                    map.put(a[i], 2);
                }
            }
        }
    }

}
