package problems;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 17..
 */
public class FindNthSmallestNumber {
    public static void main(String[] args) {
        List<Integer> set = new ArrayList<Integer>();
        set.add(4);
        set.add(6);

        System.out.println(findNthSmallestNumber(set, 6));
    }

    public static int findNthSmallestNumber(List<Integer> set, int n) {
        List<Queue<Integer>> queues = new ArrayList<>();
        for (Integer i : set) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            queues.add(queue);
        }

        int current = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            current = Integer.MAX_VALUE;
            for (Queue<Integer> queue : queues) {
                current = Math.min(current, queue.peek());
            }

            for (int j = 0; j < queues.size(); j++) {
                if(current == queues.get(j).peek()) {
                    int temp = queues.get(j).poll();
                    queues.get(j).offer(temp + set.get(j));
                }
            }
        }
        return current;
    }
}
