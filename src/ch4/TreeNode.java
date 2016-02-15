package ch4;

/**
 * Created by 1002427 on 2016. 1. 5..
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    TreeNode parent;
    Color color;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
        this.color = Color.white;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.color = Color.white;
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
        }

        System.out.println(node.val);

        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }

    public static void inOrderTraversalIterative(TreeNode root) {
        TreeNode node = root;
        while (node != null) {
            if (node.left != null && node.left.color != Color.black) {
                node = node.left;
            } else if (node.color != Color.black) {
                System.out.println(node.val);
                node.color = Color.black;
            } else if (node.right != null && node.right.color != Color.black) {
                node = node.right;
            } else {
                node = node.parent;
            }
        }
    }
}
