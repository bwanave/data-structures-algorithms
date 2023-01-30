package dfs;

class MaximumPathSum {

    public static int findMaximumPathSum(TreeNode root) {

        return dfs(root)[1];
    }

    private static int[] dfs(TreeNode root) {

        if (root == null) return new int[]{0, Integer.MIN_VALUE};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int leftPathSum = Math.max(left[0], 0);
        int rightPathSum = Math.max(right[0], 0);

        int pathSum = root.val + Math.max(leftPathSum, rightPathSum);

        int sum = leftPathSum + root.val + rightPathSum;
        int maxSum = Math.max(sum, Math.max(left[1], right[1]));

        return new int[]{pathSum, maxSum};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    }
}
