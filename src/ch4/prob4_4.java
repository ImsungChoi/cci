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
        List<List<TreeNode>> lists = getListsFromTree(root);
        for (List<TreeNode> list : lists) {
            for (TreeNode node : list) {
                System.out.print(node.val + " ");
            }
            System.out.println("");
        }
    }

    public static List<List<TreeNode>> getListsFromTree(TreeNode root) {
        List<List<TreeNode>> lists = new ArrayList<>();
        List<TreeNode> list = null;
        Queue<TreeNode> queue = new LinkedList<>();
        root.color = Color.black;
        queue.offer(root);
        Color check = Color.gray;

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            //System.out.println(node.color);
            //System.out.println(check);

            if (node.color != check) {
                list = new ArrayList<>();
                lists.add(list);
                check = node.color;
            }

            list.add(node);
            setChildrenNodeColor(node, check);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return lists;
    }

    public static void setChildrenNodeColor(TreeNode node, Color check) {
        Color set = null;
        if (check == Color.black) {
            set = Color.gray;
        } else {
            set = Color.black;
        }

        if (node.left != null) {
            node.left.color = set;
        }

        if (node.right != null) {
            node.right.color = set;
        }
    }
}
