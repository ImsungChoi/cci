package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_9 {
    public static void main(String[] args) {
        int[] ints = new int[1000];

        for(int i = 0; i < 1000; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        List<List<TreeNode>> paths = getPathsFromRoot(root, 40);

        for (List<TreeNode> path : paths) {
            path.stream().forEach(t -> System.out.print(t.val + " "));
            System.out.println("");
        }
    }

    public static List<List<TreeNode>> getPathsFromRoot(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<List<TreeNode>> paths = new ArrayList<>();

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            getPathsFromNode(node, paths, new ArrayList<>(), k);
        }
        return paths;
    }

    public static void getPathsFromNode(TreeNode node, List<List<TreeNode>> paths, List<TreeNode> current, int k) {
        current.add(node);
        int check = compareValue(current, k);

        if (check == 0) {
            List<TreeNode> path = new ArrayList<>();
            current.stream().forEach(n -> path.add(n));
            paths.add(path);
            return;
        } else if (check == 1) {
            if (node.left != null) {
                getPathsFromNode(node.left, paths, current, k);
                current.remove(node.left);
            }
            if (node.right != null) {
                getPathsFromNode(node.right, paths, current, k);
                current.remove(node.right);
            }
        } else {
            return;
        }

    }

    public static int compareValue(List<TreeNode> list, int k) {
        int values = 0;
        for (TreeNode t : list) {
            values += t.val;
        }

        if (values < k) {
            return 1;
        } else if (values > k) {
            return -1;
        } else {
            return 0;
        }
    }
}
