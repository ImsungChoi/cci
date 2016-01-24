package problems;

import java.util.*;

/**
 * Created by imsungchoi on 2016. 1. 23..
 */
public class TreeTraversal {
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

        inorder(n1);
        System.out.println("======================");
        inorderIterative(n1);
    }

    public static void inorder(TreeNode root) {
        if(root.left != null) {
            inorder(root.left);
        }

        System.out.println(root.val);

        if(root.right != null) {
            inorder(root.right);
        }
    }

    public static void inorderIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode prev = null;
        while(!stack.isEmpty()) {
            TreeNode node = stack.peek();

            if(prev == null || node == prev.left || node == prev.right) {
                if(node.left != null) {
                    stack.push(node.left);
                }
            } else {
                node = stack.pop();
                System.out.println(node.val);

                if(node.right != null) {
                    stack.push(node.right);
                }
            }
            prev = node;
        }
    }
}
