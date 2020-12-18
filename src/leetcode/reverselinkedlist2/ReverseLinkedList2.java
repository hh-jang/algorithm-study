package leetcode.reverselinkedlist2;

import java.util.Arrays;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
//        ListNode listNode = buildListNodes(new int[]{1, 2, 3, 4, 5});
//        ListNode listNode1 = reverseBetween(listNode, 2, 4);

        ListNode listNode = buildListNodes(new int[]{1, 2,3 ,4, 5});
        ListNode listNode1 = reverseBetween(listNode, 4, 5);

        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n) return head;
        int idx;
        ListNode current;
        ListNode before = new ListNode();
        ListNode realHeadBefore = before;

        before.next = head;
        ListNode temp;

        for(idx = 0; idx < m - 1; idx++) {
            before = before.next;
        }
        current = before.next;

        for(; idx < n - 1; idx++) {
            temp = current.next;
            current.next = temp.next;
            temp.next = before.next;
            before.next = temp;
        }

        return realHeadBefore.next;
    }

    public static ListNode buildListNodes(int[] values) {
        ListNode head = new ListNode();
        ListNode idx = head;
        for(int value : values) {
            ListNode listNode = new ListNode(value);
            idx.next = listNode;
            idx = idx.next;
        }

        return head.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
