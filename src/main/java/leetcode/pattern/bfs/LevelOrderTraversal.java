package leetcode.pattern.bfs;

import java.util.*;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal.
 * You should populate the values of all nodes of each level from left to right in separate sub-arrays.
 */
class LevelOrderTraversal {
    public static List<List<Integer>> traverse(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Queue<List<Node>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(root));
        while (!queue.isEmpty()) {

            List<Node> currentLevel = queue.poll();

            List<Integer> currentLevelValues = new ArrayList<>();
            List<Node> nextLevel = new ArrayList<>();

            for (Node node : currentLevel) {
                currentLevelValues.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            result.add(currentLevelValues);
            if (!nextLevel.isEmpty()) queue.add(nextLevel);
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
        List<List<Integer>> result = LevelOrderTraversal.traverse(root);
        System.out.println("Level order traversal: " + result);
    }
}
