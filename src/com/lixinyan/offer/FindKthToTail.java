package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/11.
 *
 */
public class FindKthToTail {
    public ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }

        ListNode aHead = head;
        ListNode behind = null;

        for (int i = 0; i < k - 1; i++) {
            if (aHead.next != null) {
                aHead = aHead.next;
            } else {
                return null;
            }
        }

        behind = head;

        while (aHead.next != null) {
            aHead = aHead.next;
            behind = behind.next;
        }

        return behind;
    }
}
