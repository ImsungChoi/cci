package ch4;

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
        if (t2 == null) {
            return true;
        }
        return getSubRootNode(t1, t2) ;
    }

    public static boolean getSubRootNode(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return isSame(t1, t2);
        }

        return getSubRootNode(t1.left, t2) || getSubRootNode(t1.right, t2);
    }

    public static boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return (t2 == null);
        }

        if (!isSame(t1.left, t2.left)) {
            return false;
        }

        if (t1.val != t2.val) {
            return false;
        }

        if (!isSame(t1.right, t2.right)) {
            return false;
        }

        return true;
    }
}
