package com.lixinyan.algorithm;

/**
 * Created by administrator on 2016/4/20.
 *
 */
public class TreeNode {
    int value;
    String messsage;
    TreeNode leftChild;
    TreeNode rightChild;
    boolean isVisted = false;

    public TreeNode(int value, String message) {
        this.value = value;
        this.messsage = message;
        this.leftChild = null;
        this.rightChild = null;
    }
}
