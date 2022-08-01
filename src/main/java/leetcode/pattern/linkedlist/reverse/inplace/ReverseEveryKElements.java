package leetcode.pattern.linkedlist.reverse.inplace;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
class ReverseEveryKElements {

    public static ListNode reverse(ListNode head, int k) {

        if (k == 1) return head;

        ListNode prev = null;
        ListNode start = head;

        int i = 1;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            if (i % k == 0 || next == null) {
                ListNode newHead = reverse(start, next);
                if (prev == null) head = newHead;
                else prev.next = newHead;
                prev = start;
                start = next;
            }
            curr = next;
            i += 1;
        }

        return head;
    }

    private static ListNode reverse(ListNode head, ListNode end) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = ReverseEveryKElements.reverse(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}