package ch4;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_6 {
    public static void main(String[] args) {
        int[] ints = new int[100];

        for(int i = 0; i < 100; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        TreeNode node = root;
        while(node != null) {
            System.out.println(node.val);
            node = getNextNode(node);
        }
    }

    public static TreeNode getNextNode(TreeNode n) {
        TreeNode node = n;

        if (node.right != null) {
            node = node.right;

            while(node.left != null) {
                node = node.left;
            }

            return node;
        } else {
            while(node.parent != null && node.parent.right == node) {
                node = node.parent;
            }

            return node.parent;
        }
    }
}