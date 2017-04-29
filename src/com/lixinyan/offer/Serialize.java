package com.lixinyan.offer;


/**
 * Created by asus on 2017/4/28.
 *
 */
public class Serialize {

    String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        serialize2(root, stringBuilder);
        return stringBuilder.toString();
    }

    void serialize2(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val);
        sb.append(",");
        serialize2(root.left, sb);
        serialize2(root.right, sb);
    }

    int index = -1;

    TreeNode deserialize(String string) {
        if (string.length() == 0) {
            return null;
        }

        String[] strings = string.split(",");

        return deserialize2(strings);
    }


    TreeNode deserialize2(String[] strs) {
        index++;
        if (!strs[index].equals("#")) {
            TreeNode root = new TreeNode(0);
            root.val = Integer.parseInt(strs[index]);
            root.left = deserialize2(strs);
            root.right = deserialize2(strs);
            return root;
        }

        return null;
    }


}
