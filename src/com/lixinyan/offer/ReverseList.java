package com.lixinyan.offer;

import java.util.List;

/**
 * Created by Administrator on 2017/2/10.
 *
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode node = head;
        ListNode prev = null;

        while (node != null) {
            ListNode next = node.next;

            if (next == null) {
                reverseHead = node;
            }

            node.next = prev;
            prev = node;
            node = next;
        }

        return reverseHead;
    }
}
