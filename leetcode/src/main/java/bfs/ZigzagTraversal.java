package bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent its zigzag level order traversal.
 * You should populate the values of all nodes of the first level from left to right,
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 */
class ZigzagTraversal {
    public static List<List<Integer>> traverse(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        int level = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<Integer> levelValues = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                if (level % 2 == 0) levelValues.add(0, node.val);
                else levelValues.add(node.val);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);

            }
            level += 1;
            result.add(levelValues);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        root.right.left.left = new Node(20);
        root.right.left.right = new Node(17);
        List<List<Integer>> result = ZigzagTraversal.traverse(root);
        System.out.println("Zigzag traversal: " + result);
    }
}
