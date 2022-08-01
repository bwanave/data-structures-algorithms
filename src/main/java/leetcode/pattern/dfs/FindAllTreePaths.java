package leetcode.pattern.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a number ‘S’, find all
 * paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
 */
class FindAllTreePaths {
    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();

        return findPaths(root, sum, new ArrayList<>(), allPaths);
    }

    public static List<List<Integer>> findPaths(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allPaths) {

        if (root == null) return allPaths;

        currentPath.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == root.val) allPaths.add(new ArrayList<>(currentPath));
        }
        else {
            findPaths(root.left, sum - root.val, currentPath, allPaths);
            findPaths(root.right, sum - root.val, currentPath, allPaths);
        }

        currentPath.remove(currentPath.size() - 1);
        return allPaths;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
