package ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by imsungchoi on 2016. 1. 1..
 */
public class prob4_4 {
    public static void main(String[] args) {
        int[] ints = new int[100];

        for(int i = 0; i < 100; i++) {
            ints[i] = i;
        }

        TreeNode root = prob4_3.generateBinarySearchTree(ints);
        List<List<TreeNode>> lists = new ArrayList<>();
        getListsFromTree(lists, root, 0);
        for (List<TreeNode> list : lists) {
            for (TreeNode node : list) {
                System.out.print(node.val + " ");
            }
            System.out.println("");
        }
    }

    public static void getListsFromTree(List<List<TreeNode>> lists, TreeNode node, int level) {
        if (node == null) {
            return;
        }
        List<TreeNode> list;
        if (lists.size() == level) {
            list = new ArrayList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(node);

        getListsFromTree(lists, node.left, level + 1);
        getListsFromTree(lists, node.right, level + 1);
    }
}
