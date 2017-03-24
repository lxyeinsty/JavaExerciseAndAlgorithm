package com.lixinyan.offer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/22.
 *
 */
public class GetLowestRoot {

    //二叉搜索树
    public TreeNode getLowestCommonAncestor(TreeNode rootParent, TreeNode root,
                                            TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return null;
        }

        if ((root.val - node1.val) * (root.val - node2.val) < 0) {
            return root;
        } else if ((root.val - node1.val) * (root.val - node2.val) > 0) {
            TreeNode newNode = (root.val > node1.val) && (root.val > node2.val) ?
                    root.left : root.right;
            return getLowestCommonAncestor(root, newNode, node1, node2);
        } else {
            return rootParent;
        }
    }

    //普通二叉树
    public static TreeNode getLowestCommonAncestor2(TreeNode root, TreeNode node1, TreeNode node2) {
        if (root == null || node1 == null || node2 == null) {
            return  null;
        }

        Stack<TreeNode> path1 = new Stack<>();
        boolean flag1 = getThePathOfTheNode(root, node1, path1);
        if (!flag1) {
            return null;
        }

        Stack<TreeNode> path2 = new Stack<>();
        boolean flag2 = getThePathOfTheNode(root, node2, path2);
        if (!flag2) {
            return null;
        }

        if (path1.size() > path2.size()) {
            while (path1.size() != path2.size()) {
                path1.pop();
            }
        } else {
            while (path1.size() != path2.size()) {
                path2.pop();
            }
        }

        if (path1.equals(path2)) { //在一条路径上面
            path1.pop();
            return path1.pop();
        } else {
            TreeNode p = path1.pop();
            TreeNode q = path2.pop();

            while (p != q) {
                p = path1.pop();
                q = path2.pop();
            }

            return p;
        }
    }

    public static boolean getThePathOfTheNode(TreeNode root,
                                              TreeNode node, Stack<TreeNode> path) {
        path.push(node);
        if (root == node) {
            return true;
        }

        boolean found = false;
        if (root.left != null) {
            found = getThePathOfTheNode(root.left, node, path);
        }

        if (root.right != null) {
            found = getThePathOfTheNode(root.right, node, path);
        }

        if (!found) {
            path.pop();
        }

        return found;
    }

}
