package ch4;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_3 {
    public static void main(String[] args) {
        int[] ints = new int[10];

        for(int i = 0; i < 10; i++) {
            ints[i] = i;
        }

        TreeNode root = generateBinarySearchTree(ints);
        TreeNode.inOrderTraversal(root);
    }

    public static TreeNode generateBinarySearchTree(int[] sortedList) {
        return generateSubTree(null, sortedList, 0, sortedList.length - 1, 0);
    }

    public static TreeNode generateSubTree(TreeNode root, int[] sortedList, int start, int end, int direction) {
        if (start > end) {
            return null;
        }

        int median = (start + end) / 2;
        if (direction == 0) {
            root = new TreeNode(sortedList[median]);
        } else {
            root = addNode(root, sortedList[median], direction);
        }

        generateSubTree(root, sortedList, start, median - 1, -1);
        generateSubTree(root, sortedList, median + 1, end, 1);

        return root;
    }

    public static TreeNode addNode(TreeNode parent, int val, int direction) {
        TreeNode node = new TreeNode(val);
        node.parent = parent;

        if(direction == -1) {
            parent.left = node;
        } else if (direction == 1) {
            parent.right = node;
        }

        return node;
    }
}
