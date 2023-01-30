package inplace;

/**
 * Given the head of a LinkedList and two positions ‘p’ and ‘q’, reverse the LinkedList from position ‘p’ to ‘q’.
 */
class ReverseSubList {

    public static ListNode reverse(ListNode head, int p, int q) {

        ListNode prevNode = null;
        ListNode leftNode = null;
        ListNode rightNode = null;

        int i = 1;
        ListNode curr = head;
        while (i <= q) {

            if (i == p - 1) prevNode = curr;
            if (i == p) leftNode = curr;
            if (i == q) rightNode = curr;

            curr = curr.next;
            i += 1;
        }

        // Reverse
        ListNode prev = rightNode.next;
        curr = leftNode;
        ListNode end = rightNode.next;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (prevNode == null) return prev;

        prevNode.next = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = ReverseSubList.reverse(head, 2, 4);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}