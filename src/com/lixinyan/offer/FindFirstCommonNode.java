package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/3/24.
 *
 */
public class FindFirstCommonNode {
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        int count1 = 0;
        ListNode p1 = pHead1;
        while (p1 != null) {
            count1++;
            p1 = p1.next;
        }

        int count2 = 0;
        ListNode p2 = pHead2;
        while (p2 != null) {
            count2++;
            p2 = p2.next;
        }

        int flag  = count1 - count2;

        if (flag > 0) {
            for (int i = 0; i < flag; i++) {
                pHead1 = pHead1.next;
            }

            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

            return pHead1;
        } else {
            flag = count2 - count1;
            for (int i = 0; i < flag; i++) {
                pHead2 = pHead2.next;
            }

            while (pHead1 != pHead2) {
                pHead1 = pHead1.next;
                pHead2 = pHead2.next;
            }

            return pHead2;
        }
    }
}
