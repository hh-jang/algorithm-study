package leetcode.problem19;

import java.util.Arrays;
import java.util.Collections;

public class NthNodeFromEndOfList {

    public static void main(String[] args) {
        ListNode testCase = generateTestListNode(1,2, 3, 4, 5);
        int n = 5;

        ListNode listNode = removeNthFromEnd(testCase, n);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head;
        ListNode slowStarter = head;
        ListNode move;

        int idx = 0;

        while (pointer.next != null) {
            if(idx >= n) {
                slowStarter = slowStarter.next;
            }
            pointer = pointer.next;

            idx++;
        }

        // size가 1일 때에
        if (idx == 0) return null;
        // head의 값을 제거 시
        if (n - 1 == idx) return head.next;

        move = slowStarter.next.next;
        slowStarter.next = move;

        return head;
    }

    private static ListNode generateTestListNode(int... inputs) {
        ListNode head = new ListNode();
        ListNode pointer = head;
        for(int input : inputs) {
            pointer.next = new ListNode(input);
            pointer = pointer.next;
        }

        return head.next;
    }

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
