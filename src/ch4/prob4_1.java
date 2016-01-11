package ch4;

/**
 * Created by imsungchoi on 2016. 1. 1..
 *
 * Balanced Tree 인지 확인
 */
public class prob4_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left1 = new TreeNode(1);
        TreeNode left2 = new TreeNode(2);
        TreeNode left3 = new TreeNode(3);
        TreeNode left4 = new TreeNode(4);
        TreeNode right1 = new TreeNode(5);
        left2.left = left4;
        left1.left = left2;
        left1.right = left3;
        root.left = left1;
        root.right = right1;

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode node) {
        return (checkBalanced(node) > 0)? true : false;
    }

    public static int checkBalanced(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = checkBalanced(node.left);
        if (left < 0) {
            return -1;
        }
        int right = checkBalanced(node.right);
        if (right < 0) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}


