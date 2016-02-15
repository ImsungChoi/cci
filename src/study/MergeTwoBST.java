package study;

import ch4.TreeNode;

import java.util.Stack;

/**
 * Created by 1002427 on 2016. 2. 15..
 */
public class MergeTwoBST {
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode();
        n1.val = 3;
        TreeNode n2 = new TreeNode();
        n2.val = 1;
        TreeNode n3 = new TreeNode();
        n3.val = 7;
        TreeNode n4 = new TreeNode();
        n4.val = 5;
        TreeNode n5 = new TreeNode();
        n5.val = 9;

        n3.left = n4;
        n3.right = n5;
        n1.left = n2;
        n1.right = n3;

        TreeNode a1 = new TreeNode();
        a1.val = 4;
        TreeNode a2 = new TreeNode();
        a2.val = 2;
        TreeNode a3 = new TreeNode();
        a3.val = 8;
        TreeNode a4 = new TreeNode();
        a4.val = 6;
        TreeNode a5 = new TreeNode();
        a5.val = 10;

        a3.left = a4;
        a3.right = a5;
        a1.left = a2;
        a1.right = a3;

        //inorder(n1);
        mergeSubTree(n1, a1);
    }

    public static void mergeSubTree(TreeNode n1, TreeNode n2) {
        TreeNode c1 = n1;
        TreeNode c2 = n2;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        while(c1 != null || !s1.isEmpty() || c2 != null || !s2.isEmpty()) {
            if (c1 != null || c2 != null) {
                if(c1 != null) {
                    s1.push(c1);
                    c1 = c1.left;
                }

                if(c2 != null) {
                    s2.push(c2);
                    c2 = c2.left;
                }
            } else {
                if(s1.isEmpty()) {
                    c2 = s2.pop();
                    System.out.println(c2.val);
                    c2 = c2.right;
                } else if(s2.isEmpty()) {
                    c1 = s1.pop();
                    System.out.println(c1.val);
                    c1 = c1.right;
                } else {
                    c1 = s1.pop();
                    c2 = s2.pop();

                    if(c1.val < c2.val) {
                        System.out.println(c1.val);
                        c1 = c1.right;
                        s2.push(c2);
                        c2 = null;
                    } else {
                        System.out.println(c2.val);
                        c2 = c2.right;
                        s1.push(c1);
                        c1 = null;
                    }
                }
            }
        }
    }

    public static void inorder(TreeNode n) {
        TreeNode c = n;
        Stack<TreeNode> s = new Stack<>();

        while(c != null || !s.isEmpty()) {
            if(c != null) {
                s.push(c);
                c = c.left;
            } else {
                c = s.pop();
                System.out.println(c.val);
                c = c.right;
            }
        }
    }
}
