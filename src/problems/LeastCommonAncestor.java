package problems;

/**
 * Created by imsungchoi on 2016. 1. 30..
 */
public class LeastCommonAncestor {
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

        System.out.println(getLeastAncestor(n1, 3, 5).val);
    }

    public static TreeNode getLeastAncestor(TreeNode root, int val1, int val2) {
        if(!contain(root, val1, val2)) {
            return null;
        }
        return find(root, val1, val2);
    }

    public static TreeNode find(TreeNode n, int val1, int val2) {
        if(n == null) {
            return null;
        }

        if(n.val == val1 || n.val == val2) {
            return n;
        }

        TreeNode left = find(n.left, val1, val2);
        TreeNode right = find(n.right, val1, val2);

        if(left != null && right != null) {
            return n;
        }
        return (left != null)? left : right;
    }

    public static boolean contain(TreeNode n, int val1, int val2) {
        if(traversal(n, val1) && traversal(n, val2)) {
            return true;
        }
        return false;
    }

    public static boolean traversal(TreeNode n, int val) {
        if(n.left != null) {
            if(traversal(n.left, val)) {
                return true;
            }
        }

        if(n.val == val) {
            return true;
        }

        if(n.right != null) {
            if(traversal(n.right, val)) {
                return true;
            }
        }
        return false;
    }
}
