package inplace;

/**
 * Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
 */
class RotateList {

    public static ListNode rotate(ListNode head, int k) {

        if (head == null || k <= 0)
            return head;

        int size = 1;
        ListNode tail = head;
        while (tail.next != null) {
            size += 1;
            tail = tail.next;
        }

        k = k % size;
        k = size - k; // kth node from tail

        int i = 1;
        ListNode kNode = head;
        while (i < k) {
            i += 1;
            kNode = kNode.next;
        }

        if (kNode.next != null) {
            ListNode newHead = kNode.next;
            kNode.next = null;
            tail.next = head;
            head = newHead;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode result = RotateList.rotate(head, 3);
        System.out.print("Nodes of the reversed LinkedList are: ");
        while (result != null) {
            System.out.print(result.value + " ");
            result = result.next;
        }
    }
}