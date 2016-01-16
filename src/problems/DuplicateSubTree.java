package problems;

/**
 * Created by imsungchoi on 2016. 1. 17..
 */
public class DuplicateSubTree {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        TreeNode n2 = new TreeNode();
        TreeNode n3 = new TreeNode();
        TreeNode n4 = new TreeNode();
        TreeNode n5 = new TreeNode();
        TreeNode n6 = new TreeNode();
        TreeNode n7 = new TreeNode();
        TreeNode n8 = new TreeNode();
        TreeNode n9 = new TreeNode();
        n1.val = 1;
        n2.val = 2;
        n3.val = 3;
        n4.val = 4;
        n5.val = 5;
        n6.val = 6;
        n7.val = 1;
        n8.val = 2;
        n9.val = 3;

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n6.left = n7;
        n7.left = n8;
        n7.right = n9;

        System.out.println(hasDuplicateSubTree(n1));
    }

    public static boolean hasDuplicateSubTree(TreeNode root) {
        if(!check(root)) {
            return false;
        }

        boolean ret = false;
        ret |= traversal(root, root.left);
        ret |= traversal(root, root.right);
        if (ret == true) {
            return true;
        } else {
            ret |= hasDuplicateSubTree(root.left);
            ret |= hasDuplicateSubTree(root.right);
        }
        return ret;
    }

    public static boolean traversal(TreeNode target, TreeNode move) {
        if (move == null) {
            return false;
        }
        boolean ret = false;
        if(move.left != null) {
            ret |= traversal(target, move.left);
        }

        ret |= isDuplicate(target, move);

        if(move.right != null) {
            ret |= isDuplicate(target, move);
        }

        return ret;
    }

    public static boolean isDuplicate(TreeNode n1, TreeNode n2) {
        if (!check(n1) || !check(n2)) {
            return false;
        }

        if (n1.val != n2.val) {
            return false;
        }

        if (n1.left.val != n2.left.val) {
            return false;
        }

        if (n1.right.val != n2.right.val) {
            return false;
        }

        return true;
    }

    public static boolean check(TreeNode n) {
        if (n == null || n.left == null || n.right == null) {
            return false;
        } else {
            return true;
        }
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
