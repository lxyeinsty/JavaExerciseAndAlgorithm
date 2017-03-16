package com.lixinyan.offer;

/**
 * Created by Administrator on 2017/2/17.
 */
public class MergeList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode mergedList = null;

        if (list1.val < list2.val) {
            mergedList = list1;
            mergedList.next = Merge(list1.next, list2);
        }  else {
            mergedList = list2;
            mergedList.next = Merge(list1, list2.next);
        }

        return mergedList;
    }
}
