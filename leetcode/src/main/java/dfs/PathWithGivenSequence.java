package dfs;

/**
 * Given a binary tree and a number sequence,
 * find if the sequence is present as a root-to-leaf path in the given tree.
 */
class PathWithGivenSequence {
    public static boolean findPath(TreeNode root, int[] sequence) {

        return findPath(root, sequence, 0);
    }

    public static boolean findPath(TreeNode root, int[] sequence, int idx) {

        if (root == null || idx == sequence.length) return false;

        if (root.val != sequence[idx]) return false;

        if (root.left == null && root.right == null && idx == sequence.length - 1) return true;

        return findPath(root.left, sequence, idx + 1) || findPath(root.right, sequence, idx + 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 0, 7}));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[]{1, 1, 6}));
    }
}
