package leetcode.sumroottoleafnumbers;

import java.util.*;

public class SumRootToLeafNumbers {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;

        int i = sumNumbers(node1);
        System.out.println(i);
    }

    public static int sumNumbers(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return 0;

        PathInfo rootPathInfo = new PathInfo();
        rootPathInfo.treeNode = root;
        rootPathInfo.sumOfPath = root.val;
        rootPathInfo.path.add(String.valueOf(root.val));

        Queue<PathInfo> queue = new LinkedList<>();
        queue.add(rootPathInfo);

        while (!queue.isEmpty()) {
            PathInfo parentPathInfo = queue.poll();
            TreeNode parentTreeNode = parentPathInfo.treeNode;

            if(parentTreeNode.left == null && parentTreeNode.right == null) {
                String appendValue = "";
                for(String value : parentPathInfo.path) {
                    appendValue += value;
                }
                result.add(Integer.parseInt(appendValue));
            }

            if(parentTreeNode.left != null) {
                PathInfo leftPathInfo = new PathInfo();
                leftPathInfo.treeNode = parentTreeNode.left;
                leftPathInfo.sumOfPath = parentPathInfo.sumOfPath + parentTreeNode.left.val;
                leftPathInfo.path = new ArrayList<>(parentPathInfo.path);
                leftPathInfo.path.add(String.valueOf(parentTreeNode.left.val));

                queue.add(leftPathInfo);
            }

            if(parentTreeNode.right != null) {
                PathInfo rightPathInfo = new PathInfo();
                rightPathInfo.treeNode = parentTreeNode.right;
                rightPathInfo.sumOfPath = parentPathInfo.sumOfPath + parentTreeNode.right.val;
                rightPathInfo.path = new ArrayList<>(parentPathInfo.path);
                rightPathInfo.path.add(String.valueOf(parentTreeNode.right.val));

                queue.add(rightPathInfo);
            }

        }

        return result.stream().mapToInt(value -> value).sum();
    }

    public static class PathInfo {
        int sumOfPath;
        List<String> path = new ArrayList<>();
        TreeNode treeNode;
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
