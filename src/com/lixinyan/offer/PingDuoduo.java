package com.lixinyan.offer;

import java.util.Scanner;

/**
 * Created by Administrator on 2017/3/19.
 *
 */
public class PingDuoduo {
    static class Node {
        Node next;
        int val;

        Node(int v) {
            val = v;
        }
    }

    //从中间断开链表比较，复杂度O(N)
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String initString = in.nextLine();
        String[] strings = initString.split(",");
        Node pHead = new Node(Integer.parseInt(strings[0]));
        pHead.next = null;
        Node node = pHead;
        for (int i = 1; i < strings.length; i++) {
            node.next = new Node(Integer.parseInt((strings[i])));
            node = node.next;
            node.next = null;
        }

        if (isCHList(pHead)) {
            System.out.print(1);
        } else System.out.print(0);
    }

    public static Node reverseList(Node head) { //翻转链表
        Node reverseHead = null;
        Node node = head;
        Node prev = null;

        while (node != null) {
            Node next = node.next;

            if (next == null) {
                reverseHead = node;
            }

            node.next = prev;
            prev = node;
            node = next;
        }

        return reverseHead;
    }

    static boolean isCHList(Node head) { //中间断开链表，比较，复杂度O(N)
        int length = 0;
        Node pNode = head;
        while (pNode != null) {
            length++;
            pNode = pNode.next;
        }

        pNode = head;
        if (length == 1) {
            return true;
        }

        int mid = length >> 1;

        for (int i = 0; i < mid; i++) {
            pNode = pNode.next;
        }

        if (length % 2 == 1) {
            pNode = pNode.next;
        }

        Node pOther = reverseList(pNode);

        pNode = head;

        while (pOther != null && pNode != null) {
            if (pOther.val != pNode.val) {
                return false;
            }

            pNode = pNode.next;
            pOther = pOther.next;
        }

        return  true;
    }
}
