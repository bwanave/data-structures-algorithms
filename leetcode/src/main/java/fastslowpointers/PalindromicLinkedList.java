package fastslowpointers;

/**
 * Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
 * <p>
 * Your algorithm should use constant space and the input LinkedList should be in the original form once the algorithm is finished. The algorithm should have
 * O
 * (
 * N
 * )
 * O(N)
 * time complexity where ‘N’ is the number of nodes in the LinkedList.
 * <p>
 * Example 1:
 * <p>
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> null
 * Output: true
 * Example 2:
 * <p>
 * Input: 2 -> 4 -> 6 -> 4 -> 2 -> 2 -> null
 * Output: false
 */
class PalindromicLinkedList {

    public static boolean isPalindrome(ListNode head) {

        ListNode mid = findMid(head);
        ListNode newHead = reverse(mid);

        ListNode curr1 = head;
        ListNode curr2 = newHead;
        while (curr1 != null && curr2 != null) {
            if (curr1.value != curr2.value) return false;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        reverse(newHead);

        return true;
    }

    private static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
    }
}