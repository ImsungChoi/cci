package ch4;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_9 {
    public static void main(String[] args) {

    }

    public static List<List<TreeNode>> getPathsFromRoot(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

        }
    }

    public static void getPathsFromNode(TreeNode node, int k) {

    }
}
