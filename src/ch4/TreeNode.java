package ch4;

/**
<<<<<<< Updated upstream
 * Created by 1002427 on 2016. 1. 5..
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {

    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static void inOrderTraversal(TreeNode node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
        }

        System.out.println(node.val);

        if (node.right != null) {
            inOrderTraversal(node.right);
        }
=======
 * Created by imsungchoi on 2016. 1. 4..
 */
public class TreeNode {
    TreeNode left;
    TreeNode right;
    int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(TreeNode left, TreeNode right, int value){
        this.left = left;
        this.right = right;
        this.value = value;
>>>>>>> Stashed changes
    }
}
