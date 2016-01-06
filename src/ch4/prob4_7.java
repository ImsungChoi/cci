package ch4;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_7 {
    public static void main(String[] args) {
        int[] ints = new int[100];

        for(int i = 0; i < 100; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        TreeNode n1 = root.left;
        TreeNode n2 = root.left.left.left.left.right;

        System.out.println(getCommonAncestor(n1, n2).val);
    }

    public static TreeNode getCommonAncestor(TreeNode n1, TreeNode n2) {
        if(n1.parent == null || n2.parent == null) {
            return null;
        }

        if (contains(n1, n2)) {
            return n1.parent;
        }

        if (contains(n2, n1)) {
            return n2.parent;
        }

        TreeNode t1 = n1.parent;
        TreeNode t2 = n2.parent;

        while (t1 != null) {
            while (t2 != null) {
                if (t1 == t2) {
                    return t1;
                }
                t2 = t2.parent;
            }
            t1 = t1.parent;
            t2 = n2;
        }

        return null;
    }

    public static boolean contains(TreeNode n1, TreeNode n2) {
        TreeNode n = n1;
        if (n.left != null) {
            if (contains(n.left, n2)) {
                return true;
            }
        }

        if (n == n2) {
            return true;
        }

        if (n.right != null) {
            if (contains(n.right, n2)) {
                return true;
            }
        }

        return false;
    }
}
