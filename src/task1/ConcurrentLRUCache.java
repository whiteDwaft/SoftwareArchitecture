package task1;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class ConcurrentLRUCache<K,V> {
    private final Map<K,V> cache;
    private final int capacity;

    public ConcurrentLRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = Collections.synchronizedMap(
                new LinkedHashMap<K,V>(capacity){
                    @Override
                    protected boolean removeEldestEntry(Map.Entry<K,V> eldest){
                        return size() > capacity;
                    }
                });
    }

    public void set(K key, V value){
        cache.put(key, value);
    }
    public V find(K key){
        return cache.get(key);
    }

    public static void main(String[] args) {
        ConcurrentLRUCache<Integer,Integer> cache = new ConcurrentLRUCache<>(5);
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
