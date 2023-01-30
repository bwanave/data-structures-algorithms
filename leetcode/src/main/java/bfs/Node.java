package bfs;

/**
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to a null node.
 */
class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int x) {
        val = x;
        left = right = next = null;
    }

    // level order traversal using 'next' pointer
    void printLevelOrder() {
        Node nextLevelRoot = this;
        while (nextLevelRoot != null) {
            Node current = nextLevelRoot;
            nextLevelRoot = null;
            while (current != null) {
                System.out.print(current.val + " ");
                if (nextLevelRoot == null) {
                    if (current.left != null) nextLevelRoot = current.left;
                    else if (current.right != null) nextLevelRoot = current.right;
                }
                current = current.next;
            }
            System.out.println();
        }
    }
}
