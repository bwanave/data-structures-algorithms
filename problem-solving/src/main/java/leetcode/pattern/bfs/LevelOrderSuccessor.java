package leetcode.pattern.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right
 * after the given node in the level order traversal.
 */
class LevelOrderSuccessor {
    public static Node findSuccessor(Node root, int key) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

                if (node.val == key) return queue.isEmpty() ? null : queue.poll();
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Node result = LevelOrderSuccessor.findSuccessor(root, 3);
        if (result != null) System.out.println(result.val + " ");

        root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);

        result = LevelOrderSuccessor.findSuccessor(root, 9);
        if (result != null) System.out.println(result.val + " ");

        result = LevelOrderSuccessor.findSuccessor(root, 12);
        if (result != null) System.out.println(result.val + " ");
    }
}
