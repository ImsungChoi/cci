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
        System.out.println(isBinarySearchTree(root));
    }

    public static boolean isBinarySearchTree(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        getListWithInorderTravesal(list, root);
        return isSortedList(list);
    }

    public static List<TreeNode> getListWithInorderTravesal(List<TreeNode> list, TreeNode node) {
        if (node.left != null) {
            getListWithInorderTravesal(list, node.left);
        }
        list.add(node);
        if (node.right != null) {
            getListWithInorderTravesal(list, node.right);
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
