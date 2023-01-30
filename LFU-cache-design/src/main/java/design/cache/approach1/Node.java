package design.cache.approach1;

class Node {
    public int key;
    public int value;
    public int frequency;
    public Node next;
    public Node prev;

    public Node(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}