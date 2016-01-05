package ch4;

/**
<<<<<<< Updated upstream
 * Created by 1002427 on 2016. 1. 5..
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
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
}
