package leetcode.pathsumtwo;

import java.util.*;

public class PathSumTwo {

    public static void main(String[] args) {

    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        PathInfo rootPathInfo = new PathInfo();
        rootPathInfo.treeNode = root;
        rootPathInfo.sumOfPath = root.val;
        rootPathInfo.path.add(root.val);

        Queue<PathInfo> queue = new LinkedList<>();
        queue.add(rootPathInfo);

        while (!queue.isEmpty()) {
            PathInfo parentPathInfo = queue.poll();
            TreeNode parentTreeNode = parentPathInfo.treeNode;

            if(parentTreeNode.left == null && parentTreeNode.right == null &&
                    parentPathInfo.sumOfPath == targetSum) {
                result.add(new ArrayList<>(parentPathInfo.path));
            }

            if(parentTreeNode.left != null) {
                PathInfo leftPathInfo = new PathInfo();
                leftPathInfo.treeNode = parentTreeNode.left;
                leftPathInfo.sumOfPath = parentPathInfo.sumOfPath + parentTreeNode.left.val;
                leftPathInfo.path = new ArrayList<>(parentPathInfo.path);
                leftPathInfo.path.add(parentTreeNode.left.val);

                queue.add(leftPathInfo);
            }

            if(parentTreeNode.right != null) {
                PathInfo rightPathInfo = new PathInfo();
                rightPathInfo.treeNode = parentTreeNode.right;
                rightPathInfo.sumOfPath = parentPathInfo.sumOfPath + parentTreeNode.right.val;
                rightPathInfo.path = new ArrayList<>(parentPathInfo.path);
                rightPathInfo.path.add(parentTreeNode.right.val);

                queue.add(rightPathInfo);
            }

        }

        return result;
    }

    public static class PathInfo {
        int sumOfPath;
        List<Integer> path = new ArrayList<>();
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
