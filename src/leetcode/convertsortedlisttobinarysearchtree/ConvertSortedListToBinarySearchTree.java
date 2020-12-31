package leetcode.convertsortedlisttobinarysearchtree;

public class ConvertSortedListToBinarySearchTree {

    public static void main(String[] args) {
        ListNode listNode = buildListNodes(new int[]{-10, -3, 0, 5, 9});
        TreeNode treeNode = sortedListToBST(listNode);
        print(treeNode, 1);
    }

    private static void print(TreeNode treeNode, int depth) {
        if(treeNode == null) return;
        System.out.println("depth : " + depth + " value : " + treeNode.val);
        print(treeNode.left, depth + 1);
        print(treeNode.right, depth + 1);
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);

        ListNode before = null;
        ListNode midNode = head;
        ListNode traverseNode = head;

        while (traverseNode != null && traverseNode.next != null) {
            traverseNode = traverseNode.next.next;
            before = midNode;
            midNode = midNode.next;
        }

        before.next = null;

        TreeNode midTreeNode = new TreeNode(midNode.val);
        midTreeNode.left = sortedListToBST(head);
        midTreeNode.right = sortedListToBST(midNode.next);

        return midTreeNode;
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

    public static class ListNode {
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

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
