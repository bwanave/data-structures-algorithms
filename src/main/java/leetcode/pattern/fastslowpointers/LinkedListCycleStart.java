package leetcode.pattern.fastslowpointers;

class LinkedListCycleStart {
    public static ListNode findCycleStart(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);

        ListNode current1 = head;
        ListNode current2 = slow;
        while (current1 != current2) {
            current1 = current1.next;
            current2 = current2.next;
        }

        return current1;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);

        head.next.next.next.next.next.next = head;
        System.out.println("LinkedList cycle start: " + LinkedListCycleStart.findCycleStart(head).value);
    }
}