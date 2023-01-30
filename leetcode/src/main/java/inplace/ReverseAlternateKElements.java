package inplace;

/**
 * Given the head of a LinkedList and a number ‘k’, reverse every alternating ‘k’ sized sub-list starting from the head.
 * <p>
 * If, in the end, you are left with a sub-list with less than ‘k’ elements, reverse it too.
 */
class ReverseAlternateKElements {

    public static ListNode reverse(ListNode head, int k) {

        ListNode prev = null;
        ListNode start = head;

        int groupNo = 1;
        int i = 0;
        ListNode curr = head;
        while (curr != null) {

            ListNode next = curr.next;
            boolean isGroupCompleted = (i + 1) % k == 0 || next == null;
            if (isGroupCompleted && groupNo % 2 != 0) {
                ListNode newHead = reverse(start, next);
                if (prev == null) head = newHead;
                else prev.next = newHead;
                prev = start;
                start = next;
                prev.next = start;
                groupNo += 1;
            }
            else if (isGroupCompleted) {
                prev = curr;
                start = next;
                groupNo += 1;
            }

            i += 1;
            curr = next;
        }

        return head;
    }

    private static ListNode reverse(ListNode head, ListNode end) {
        ListNode prev = null;
        ListNode curr = head;
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

        ListNode result = ReverseAlternateKElements.reverse(head, 2);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}