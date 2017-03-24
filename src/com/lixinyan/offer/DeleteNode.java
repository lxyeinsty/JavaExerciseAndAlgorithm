package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/3/17.
 *
 */
public class DeleteNode {

    public void deleteNode(ListNode head, ListNode pToDeleted) {
        if (head == null || pToDeleted == null) {
            return;
        }

        if (pToDeleted.next != null) {
            ListNode next = pToDeleted.next;
            pToDeleted.val = next.val;
            pToDeleted.next = next.next;

            next = null;
        } else if (pToDeleted == head) {
            pToDeleted = null;
            head = null;
        } else {
            ListNode pNode = head;
            while (pNode.next != pToDeleted) {
                pNode = pNode.next;
            }

            pNode.next = null;
            pToDeleted = null;
        }
    }

}


