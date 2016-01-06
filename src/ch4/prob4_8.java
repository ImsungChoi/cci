package ch4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.jar.Pack200;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_8 {
    public static void main(String[] args) {
        int[] ints = new int[1000];

        for(int i = 0; i < 1000; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        TreeNode subRoot = root.left.right.left;
        System.out.println(isSubTree(root, subRoot));
    }

    public static boolean isSubTree(TreeNode t1, TreeNode t2) {
        TreeNode r1 = getSubRootNode(t1, t2);
        if(r1 == null) {
            return false;
        }

        return hasSameSubTree(r1, t2);
    }

    public static TreeNode getSubRootNode(TreeNode t1, TreeNode t2) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(t1);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == t2) {
                return node;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return null;
    }

    public static boolean hasSameSubTree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return (t2 == null);
        }

        if (!hasSameSubTree(t1.left, t2.left)) {
            return false;
        }

        if(t1 != t2) {
            return false;
        }

        if (!hasSameSubTree(t1.right, t2.right)) {
            return false;
        }

        return true;
    }
}
