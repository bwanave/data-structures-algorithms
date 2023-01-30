package leetcode.pattern.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 */
class LevelAverage {
    public static List<Double> findLevelAverages(Node root) {
        List<Double> result = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {

            int size = queue.size();
            double sum = 0;

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            result.add(sum / size);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(7);
        root.right = new Node(1);
        root.left.left = new Node(9);
        root.left.right = new Node(2);
        root.right.left = new Node(10);
        root.right.right = new Node(5);
        List<Double> result = LevelAverage.findLevelAverages(root);
        System.out.print("Level averages are: " + result);
    }
}
