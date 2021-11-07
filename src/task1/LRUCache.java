package task1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity);
        this.capacity = capacity;
    }

    public void set(K key, V value) {
        super.put(key, value);
    }

    public V find(K key) {
        return super.get(key);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return (this.size() > this.capacity);
    }

    public static void main(String[] args) {
        LRUCache<Integer,Integer> cache = new LRUCache<>(5);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.set(5,5);
        cache.set(6,6);
        cache.set(7,7);
        System.out.println(cache.find(2));
        System.out.println(cache.find(3));
    }
}
