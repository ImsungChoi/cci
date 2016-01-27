package ch18;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by imsungchoi on 2016. 1. 28..
 */
public class prob18_9 {
    static Queue<Integer> maxQueue = new PriorityQueue<>();
    static Queue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> o1 > o2? -1 : 1);

    public static void main(String[] args) {
        for(int i = 1; i < 12; i++) {
            store(i);
        }

        //1,2,3,4,5, 6, 7,8,9,10,11
        System.out.println(getMedian());
        store(12);
        System.out.println(getMedian());
        store(13);
        System.out.println(getMedian());
    }

    public static void store(int val) {
        if(minQueue.isEmpty()) {
            minQueue.offer(val);
        }

        int median = getMedian();

        if(val <= median) {
            minQueue.offer(val);
        } else {
            maxQueue.offer(val);
        }

        balance();
    }

    public static void balance() {
        if(Math.abs(minQueue.size()-maxQueue.size()) > 1) {
            if (minQueue.size() > maxQueue.size()) {
                int temp = minQueue.poll();
                maxQueue.offer(temp);
            } else {
                int temp = maxQueue.poll();
                minQueue.offer(temp);
            }
        }
    }

    public static int getMedian() {
        if(minQueue.size() + maxQueue.size() % 2 == 0) {
            if(minQueue.size() == 0 && maxQueue.size() == 0) {
                return Integer.MIN_VALUE;
            }

            return (minQueue.peek() + maxQueue.peek()) / 2;
        } else {
            if(minQueue.size() > maxQueue.size()) {
                return minQueue.peek();
            } else {
                return maxQueue.peek();
            }
        }
    }
}
