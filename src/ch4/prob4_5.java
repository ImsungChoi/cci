package ch4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_5 {
    public static void main(String[] args) {
        int[] ints = new int[100];

        for(int i = 0; i < 100; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        System.out.println(isBinarySearchTree2(root, null, null));
    }

    public static boolean isBinarySearchTree2(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if (min != null && node.val < min || max != null && node.val > max) {
            return false;
        }

        if (isBinarySearchTree2(node.left, min, node.val) || isBinarySearchTree2(node.right, node.val, max)) {
            return false;
        }
        return true;
    }

    public static boolean isBinarySearchTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        getListWithInorderTraversal(list, root);
        return isSortedList(list);
    }

    public static List<TreeNode> getListWithInorderTraversal(List<TreeNode> list, TreeNode node) {
        if (node.left != null) {
            getListWithInorderTraversal(list, node.left);
        }
        list.add(node);
        if (node.right != null) {
            getListWithInorderTraversal(list, node.right);
        }
        return list;
    }

    public static boolean isSortedList(List<TreeNode> list) {
        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).val > list.get(i+1).val) {
                return false;
            }
        }
        return true;
    }
}
