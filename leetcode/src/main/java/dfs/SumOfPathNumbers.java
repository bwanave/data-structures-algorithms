package dfs;

/**
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 */
class SumOfPathNumbers {
    public static int findSumOfPathNumbers(TreeNode root) {

        return findSumOfPathNumbers(root, 0);
    }

    public static int findSumOfPathNumbers(TreeNode root, int currentSum) {

        if (root == null) return 0;

        currentSum = currentSum * 10 + root.val;
        if (root.left == null && root.right == null) return currentSum;

        return findSumOfPathNumbers(root.left, currentSum) + findSumOfPathNumbers(root.right, currentSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
    }
}
