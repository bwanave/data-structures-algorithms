class Queue<T> {

    private int front;
    private int rear;
    private int size;
    private final Object[] arr;

    public Queue(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.arr = new Object[capacity];
    }

    public void offer(int value) {
        if (isFull()) throw new QueueOverflowException("Queue is full");

        rear++;
        rear = rear % arr.length;
        arr[rear] = value;
        size++;
    }

    public T poll() {
        if (isEmpty()) throw new QueueEmptyException("Queue is empty");

        T element = (T) arr[front++];
        front = front % arr.length;
        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == arr.length;
    }
}
