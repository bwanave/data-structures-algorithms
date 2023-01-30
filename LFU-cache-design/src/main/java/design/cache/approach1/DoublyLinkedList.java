package design.cache.approach1;

class DoublyLinkedList {
    private final Node head;
    private final Node tail;
    private int size;

    public DoublyLinkedList() {
        // Dummy nodes for easy handling
        head = new Node(0, 0, 0);
        tail = new Node(0, 0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }

    public Node removeLast() {
        if (size > 0) {
            Node removed = tail.prev;
            remove(removed);
            return removed;
        }
        return null;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}