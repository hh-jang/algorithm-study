package leetcode.addtwonumbers;

import java.util.Arrays;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] array1 = {9};
        int[] array2 = {1,9,9,9,9,9,9,9,9,9};

        ListNode head = new ListNode();
        for(int i = 0; i < array1.length; i++) {
            int value = array1[i];
            ListNode newNode = new ListNode(value);
            head.next = newNode;
            head = newNode;
        }

        ListNode firstLinkedList3 = new ListNode(3);
        ListNode firstLinkedList2 = new ListNode(4, firstLinkedList3);
        ListNode firstLinkedList1 = new ListNode(2, firstLinkedList2);

        ListNode secondLinkedList3 = new ListNode(4);
        ListNode secondLinkedList2 = new ListNode(6, secondLinkedList3);
        ListNode secondLinkedList1 = new ListNode(5, secondLinkedList2);

        ListNode result = addTwoNumbers(firstLinkedList1, secondLinkedList1);
        ListNode head = result;
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode head = resultNode;

        int firstNumber = getReverseNumbers(l1);
        int secondNumber = getReverseNumbers(l2);

        int result = firstNumber + secondNumber;

        StringBuilder sb = new StringBuilder();
        String resultStr = sb.append(String.valueOf(result)).reverse().toString();
        resultNode.val = (int) resultStr.charAt(0) - 48;

        for(int i = 1; i < resultStr.length(); i++) {
            int value = resultStr.charAt(i) - 48;
            ListNode currentNode = new ListNode(value);
            head.next = currentNode;
            head = currentNode;
        }

        return resultNode;
    }

    public static int getReverseNumbers(ListNode node) {
        StringBuilder sb = new StringBuilder();
        ListNode head = node;

        do {
            sb.append(head.val);
            head = head.next;
        } while (head != null);

        return Integer.parseInt(sb.reverse().toString());
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
