package helloalgo.hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * 链式地址实现 HashMap
 */
public class HashMapChaining {

    // 数组大小
    private int size;

    // 容量
    private int capacity;

    // 出发扩容的负载因子阈值
    private double loadThres;

    // 扩容倍数
    private int extendRatio;

    // hash表
    private List<List<Pair>> buckets;

    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 2.0 / 3.0;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private int hashFun(int key) {
        return key % capacity;
    }

    private double loadFactor() {
        return (double) size / capacity;
    }

    public void put(int key, String value) {
        // 超出容量需要扩容
        if (loadFactor() >= loadThres) {
            extend();
        }

        List<Pair> pairs = buckets.get(hashFun(key));
        pairs.add(new Pair(key, value));
        size++;
    }

    public String get(int key) {
        int hashKey = hashFun(key);
        List<Pair> pairs = buckets.get(hashKey);
        for (Pair pair : pairs) {
            if (pair.key == key) {
                return pair.value;
            }
        }
        return null;
    }

    public void remove(int key) {
        int hashKey = hashFun(key);
        List<Pair> pairs = buckets.get(hashKey);
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).key == key) {
                pairs.remove(i);
                size--;
                return;
            }
        }
    }

    public void extend() {
        List<List<Pair>> backBuckets = buckets;
        // 新的容量
        capacity *= extendRatio;

        // 重新初始化map
        buckets = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }

        // 将值重新返回扩容后的桶中
        size = 0;
        for (List<Pair> backBucket : backBuckets) {
            for (Pair pair : backBucket) {
                put(pair.key, pair.value);
            }
        }

    }


}
