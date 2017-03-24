package com.lixinyan.offer;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/17.
 *
 */
public class IterativeOrder {
    /** 访问节点 */
    public static void visit(TreeNode p) {
        System.out.print(p.val + " ");
    }

    public void iterativePreorder(TreeNode root) {  //前序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                visit(node);
                stack.push(node);
                node = node.left;
            }

            if (stack.size() > 0) {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    public void iterativeInorder(TreeNode root) {  //前序遍历
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;

        while (node != null || stack.size() > 0) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (stack.size() > 0) {
                node = stack.pop();
                visit(node);
                node = node.right;
            }
        }
    }
}
