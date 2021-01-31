package leetcode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeTraversal {

    public static void main(String[] args) {
        TreeNode testRootNode = generateTestTree();

        List<Integer> result = inorderTraversal(testRootNode);
        result.forEach(System.out::println);
    }

    private static TreeNode generateTestTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        root.right = node1;
        node1.left = node2;

        return root;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        resultList = traversal(root, resultList);

        return resultList;
    }

    public static List<Integer> traversal(TreeNode root, List<Integer> resultList) {
        if(root == null) return resultList;
        if(root.left != null) traversal(root.left, resultList);
        resultList.add(root.val);
        if(root.right != null) traversal(root.right, resultList);

        return resultList;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
