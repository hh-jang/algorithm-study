package leetcode.addtwonumbers;

public class AddTwoNumbers {
//    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//    Output: 7 -> 0 -> 8
//    Explanation: 342 + 465 = 807.
    public static void main(String[] args) {
//        int[] array1 = {9};
//        int[] array2 = {1,9,9,9,9,9,9,9,9,9};
//
//        ListNode head = new ListNode();
//        for(int i = 0; i < array1.length; i++) {
//            int value = array1[i];
//            ListNode newNode = new ListNode(value);
//            head.next = newNode;
//            head = newNode;
//        }

        ListNode firstLinkedList1 = makeLinkedList(new int[]{9});
        ListNode secondLinkedList1 = makeLinkedList(new int[]{1,9,9,9,9,9,9,9,9,9});

        ListNode head = addTwoNumbers(firstLinkedList1, secondLinkedList1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode makeLinkedList(int[] array) {
        ListNode head = new ListNode();
        ListNode cursor = head;
        for(int value : array) {
            ListNode newNode = new ListNode(value);
            cursor.next = newNode;
            cursor = newNode;
        }

        return head.next;
    }

    public static String getReversedAddedTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder sb = new StringBuilder();
        ListNode l1Cursor = l1;
        ListNode l2Cursor = l2;
        boolean isCeil = false;
        boolean l1IsTail = false;
        boolean l2IsTail = false;
        int currentVal = 0;

        while (!(l1IsTail && l2IsTail)) {
            int l1CurrentVal = l1IsTail ? 0 : l1Cursor.val;
            int l2CurrentVal = l2IsTail ? 0 : l2Cursor.val;

            currentVal = l1CurrentVal + l2CurrentVal + (isCeil ? 1 : 0);

            isCeil = currentVal > 9;

            sb.append(currentVal % 10);

            if(l1Cursor.next != null) l1Cursor = l1Cursor.next;
            else l1IsTail = true;
            if(l2Cursor.next != null) l2Cursor = l2Cursor.next;
            else l2IsTail = true;
        }

        return isCeil ? sb.append(1).toString() : sb.toString();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultNode = new ListNode();
        ListNode head = resultNode;

        String result = getReversedAddedTwoNumbers(l1, l2);

        resultNode.val = (int) result.charAt(0) - 48;

        for(int i = 1; i < result.length(); i++) {
            int value = result.charAt(i) - 48;
            ListNode currentNode = new ListNode(value);
            head.next = currentNode;
            head = currentNode;
        }

        return resultNode;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
