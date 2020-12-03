package leetcode.swapnodesinpairs;

public class SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//
//        ListNode tempHead = listNode1;
//        while (true) {
//            System.out.println(tempHead.val);
//            if(tempHead.next == null) break;
//            tempHead = tempHead.next;
//        }

        ListNode listNode = swapPairs(listNode1);
        ListNode head = listNode;

        while (true) {
            System.out.println(head.val);
            if(head.next == null) break;
            head = head.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode masterHead = head.next;
        ListNode currentNode = head;
        ListNode beforeNode = null;
        ListNode nextNode;

        while (currentNode != null && currentNode.next != null) {
            nextNode = currentNode.next;
            if(beforeNode != null) {
                beforeNode.next = currentNode.next;
            }
            currentNode.next = nextNode.next;
            nextNode.next = currentNode;

            beforeNode = currentNode;
            currentNode = currentNode.next;
        }

        return masterHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
