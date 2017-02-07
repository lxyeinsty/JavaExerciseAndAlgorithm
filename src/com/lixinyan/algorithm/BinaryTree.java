package com.lixinyan.algorithm;

/**
 * Created by administrator on 2016/4/20.
 * Contact: 2673907910@qq.com
 */
public class BinaryTree {
    private TreeNode root = null;

    private BinaryTree() {
        root = new TreeNode(1, "rootNodeA");
    }


    public void createBinTree(TreeNode root) {
        TreeNode newNodeB = new TreeNode(2, "B");
        TreeNode newNodeC = new TreeNode(3, "C");
        TreeNode newNodeD = new TreeNode(4, "D");
        TreeNode newNodeE = new TreeNode(5, "E");
        TreeNode newNodeF = new TreeNode(6, "F");
        root.leftChild = newNodeB;
        root.rightChild = newNodeC;
        root.leftChild.leftChild = newNodeD;
        root.leftChild.rightChild = newNodeE;
        root.rightChild.rightChild = newNodeF;
    }


    public boolean isEmpty() {
        return root == null;
    }

    public int height() {
        return height(root);
    }


    public int size() {
        return size(root);
    }

    //返回高度
    private int height(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            int i = height(subTree.leftChild);
            int j = height(subTree.rightChild);

            return (i < j) ? (j + 1) : (i + 1);
        }

    }

    //返回节点数
    private int size(TreeNode subTree) {
        if (subTree == null) {
            return 0;
        } else {
            return 1 + size(subTree.leftChild) + size(subTree.rightChild);
        }
    }


    //返回双亲节点
    public TreeNode parent(TreeNode element) {
        return (root == null || root == element) ? null : parent(root, element);
    }


    private TreeNode parent(TreeNode subTree, TreeNode element) {
        if (subTree == null) {
            return null;
        }

        if (subTree.leftChild == element || subTree.rightChild == element) {
            return subTree;
        }

        TreeNode p;

        if ((p = parent(subTree.leftChild, element)) != null) {
            return p;
        } else {
            return parent(subTree.rightChild, element);
        }
    }
}