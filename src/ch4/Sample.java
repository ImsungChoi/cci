package ch4;

/**
 * Created by 1002427 on 2016. 1. 7..
 */
public class Sample {
    public static void main(String[] args) {
        int[] ints = new int[10];

        for(int i = 0; i < 10; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        TreeNode.inOrderTraversalIterative(root);
    }
}
