package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/2/12.
 *
 */
public class PrintFromTopToBottom {
    public ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            TreeNode treeNode = deque.pop();
            list.add(treeNode.val);
            if (treeNode.left != null) {
                deque.add(treeNode.left);
            }

            if (treeNode.right != null) {
                deque.add(treeNode.right);
            }
        }

        return list;
    }
}
