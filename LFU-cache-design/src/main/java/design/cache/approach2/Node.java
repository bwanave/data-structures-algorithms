package design.cache.approach2;

class Node {
    public int key;
    public int value;
    public int frequency;

    public Node(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }
}