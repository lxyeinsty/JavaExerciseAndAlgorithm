package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/26.
 *
 */
public class EntryNodeOfLoop {
    public ListNode entryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null || pHead.next == null ) {
            return null;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || slow == null) return null;

        slow = pHead;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
