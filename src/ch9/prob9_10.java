package ch9;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 12..
 */
public class prob9_10 {
    public static void main(String[] args) {
        List<Box> boxes = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            boxes.add(new Box(i, i, i));
        }
        System.out.println(getMaxHeight(boxes));
    }

    public static int getMaxHeight(List<Box> boxes) {
        boolean[] visited = new boolean[boxes.size()];
        for (boolean b : visited) {
            b = false;
        }

        return stackBox(boxes, visited, -1);
    }

    public static int stackBox(List<Box> boxes, boolean[] visited, int top) {
        if(allVisited(visited)) {
            return boxes.get(top).height;
        }

        int max = 0;

        for(int i = 0; i < visited.length; i++) {
            int height = (top == -1)? 0 : boxes.get(top).height;
            if(!visited[i]) {
                visited[i] = true;
                if (top == -1 || boxes.get(i).compareTo(boxes.get(top)) < 0) {
                    height += stackBox(boxes, visited, i);
                }
                visited[i] = false;
            }

            if (height > max) {
                max = height;
            }
        }

        return max;
    }

    public static boolean allVisited(boolean[] visited) {
        boolean ret = true;
        for(int i = 0; i < visited.length; i++) {
            ret &= visited[i];
        }
        return ret;
    }
}

class Box implements Comparable<Box> {
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

    public int compareTo(Box b) {
        if(this.depth > b.depth && this.height > b.height && this.width > b.width) {
            return 1;
        } else if (this.depth == b.depth && this.height == b.height && this.width == b.width) {
            return 0;
        }
        return -1;
    }
}
