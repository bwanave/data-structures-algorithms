package leetcode.pattern.dfs;

/**
 * Given a binary tree, find the length of its diameter.
 * The diameter of a tree is the number of nodes on the longest
 * path between any two leaf nodes. The diameter of a tree may or may not pass through the root.
 * <p>
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 */
class TreeDiameter {
    public static int findDiameter(TreeNode root) {
        return dfs(root)[1];
    }

    public static int[] dfs(TreeNode root) {

        if (root == null) return new int[]{0, 0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int height = 1 + Math.max(left[0], right[0]);
        int diameter = Math.max(1 + left[0] + right[0], Math.max(left[1], right[1]));
        return new int[]{height, diameter};
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}