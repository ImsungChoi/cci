package ch9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_10 {
    public static HashMap<String, Integer> memo = new HashMap<>();
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            boxes.add(new Box(i, i, i));
        }
        boxes.add(new Box(34, 3, 4));
        boxes.add(new Box(24, 33, 24));
        boxes.add(new Box(4, 13, 14));
        boxes.add(new Box(24, 43, 4));
        boxes.add(new Box(21, 13, 34));
        boxes.add(new Box(44, 73, 44));
        boxes.add(new Box(24, 13, 4));
        boxes.add(new Box(54, 93, 24));
        boxes.add(new Box(64, 43, 24));
        boxes.add(new Box(74, 83, 94));
        boxes.add(new Box(44, 81, 34));
        boxes.add(new Box(24, 81, 64));
        boxes.add(new Box(14, 52, 91));
        boxes.add(new Box(84, 93, 99));
        System.out.println(getMaxHeight(boxes));
    }

    public static int getMaxHeight(List<Box> boxes) {
        int[] visited = new int[boxes.size()];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = 0;
        }

        return stackBox(boxes, visited, -1);
    }

    public static int stackBox(List<Box> boxes, int[] visited, int top) {
        if(allVisited(visited)) {
            return boxes.get(top).height;
        }

        String key = getKey(visited, top);
        if(memo.containsKey(key)) {
            return memo.get(key);
        }

        int max = 0;

        for(int i = 0; i < visited.length; i++) {
            int height = (top == -1)? 0 : boxes.get(top).height;

            if(visited[i] == 0) {
                visited[i] = 1;
                if (top == -1 || isValid(boxes.get(i), boxes.get(top))) {
                    height += stackBox(boxes, visited, i);
                }
                visited[i] = 0;
            }

            if (height > max) {
                max = height;
            }
        }

        memo.put(key, max);
        return max;
    }

    public static String getKey(int[] visited, int top) {
        StringBuilder sb = new StringBuilder();
        for(int i : visited) {
            sb.append(i);
        }
        return sb.toString() + top;
    }

    public static boolean allVisited(int[] visited) {
        for(int i = 0; i < visited.length; i++) {
            if(visited[i] == 0) {
                return false;
            }
        }
        return true;
    }
    public static boolean isValid(Box a, Box b) {
        if(a.depth > b.depth && a.height > b.height && a.width > b.width) {
            return true;
        }
        return false;
    }
}

class Box {
    int depth;
    int height;
    int width;

    public Box() {

    }

    public Box(int depth, int height, int width) {
        this.depth = depth;
        this.height = height;
        this.width = width;
    }
}
