package leetcode.pattern.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Find the minimum depth of a binary tree.
 * The minimum depth is the number of nodes
 * along the shortest path from the root node to the nearest leaf node.
 */
class MinimumBinaryTreeDepth {
    public static int findDepth(Node root) {

        int depth = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node.left == null && node.right == null) return depth;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            depth += 1;
        }
        return depth;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
        root.left.left = new Node(9);
        root.right.left.left = new Node(11);
        System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    }
}
