package com.lixinyan.algorithm;

/**
 * Created by Administrator on 2016/11/28.
 *
 */
public class ReverseList {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode reverseNode = null;
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next; //先保存下一个节点，防止链表断裂

            if (next == null) {
                reverseNode = node;
            }

            node.next = prev;

            prev = node;
            node = next;
        }

        return reverseNode;
    }
}
