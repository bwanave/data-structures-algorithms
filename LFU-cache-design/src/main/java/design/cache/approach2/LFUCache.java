package design.cache.approach2;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

class LFUCache {

    private final int capacity;
    private final Map<Integer, Node> cache; // [Key, Value]
    private final Map<Integer, LinkedHashSet<Node>> frequencyMap; // [Frequency, LinkedHashSet in LRU order (LRU Node to the end)]
    private int minFrequency = 0;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        frequencyMap = new HashMap<>();
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        incrementFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            incrementFrequency(node);
        }
        else {
            if (cache.size() == capacity) {
                Node removedNode = frequencyMap.get(minFrequency).iterator().next();
                frequencyMap.get(minFrequency).remove(removedNode);
                cache.remove(removedNode.key);
            }

            minFrequency = 1;
            Node node = new Node(key, value, 1);
            cache.put(key, node);
            frequencyMap.putIfAbsent(node.frequency, new LinkedHashSet<>());
            frequencyMap.get(node.frequency).add(node);
        }
    }

    private void incrementFrequency(Node node) {
        frequencyMap.get(node.frequency).remove(node);
        if (node.frequency == minFrequency && frequencyMap.get(node.frequency).isEmpty()) minFrequency++;
        node.frequency++;
        frequencyMap.putIfAbsent(node.frequency, new LinkedHashSet<>());
        frequencyMap.get(node.frequency).add(node);
    }
}