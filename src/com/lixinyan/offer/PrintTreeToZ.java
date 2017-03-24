package com.lixinyan.offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Administrator on 2017/3/16.
 *
 */
public class PrintTreeToZ {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        ArrayList<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(pRoot);
        boolean leftToRight = true;

        while (queue.size() != 1) {
            TreeNode node = queue.pop();
            if (node == null) {
                Iterator<TreeNode> iterator = null;
                if (leftToRight) {
                    iterator = queue.iterator();
                } else {
                    iterator = queue.descendingIterator();
                }

                leftToRight = !leftToRight;

                while (iterator.hasNext()) {
                    TreeNode node1 = iterator.next();
                    list.add(node1.val);
                }

                result.add(list);
                list.clear();
                queue.add(null);//添加层分隔符
                continue;//一定要continue
            }

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return result;
    }
}
