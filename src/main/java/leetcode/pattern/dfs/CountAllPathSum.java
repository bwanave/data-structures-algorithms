package leetcode.pattern.dfs;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of
 * all the node values of each path equals ‘S’. Please note that the paths can start or end at
 * any node but all paths must follow direction from parent to child (top to bottom).
 */
class CountAllPathSum {
    public static int countPaths(TreeNode root, int S) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return countPaths(root, S, map, 0);
    }

    public static int countPaths(TreeNode root, int target, Map<Long, Integer> map, long prefixSum) {

        if (root == null) return 0;

        prefixSum += root.val;
        int pathCount = map.getOrDefault(prefixSum - target, 0);

        map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);

        pathCount += countPaths(root.left, target, map, prefixSum);
        pathCount += countPaths(root.right, target, map, prefixSum);

        map.put(prefixSum, map.get(prefixSum) - 1);

        return pathCount;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
    }
}
