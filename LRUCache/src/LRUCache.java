/**
 * Created by wenhang on 2/12/14.
 * http://oj.leetcode.com/problems/lru-cache/
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 *
 * This solution provides O(1) time for get() and set() operations
 * The space complexity is O(n)
 */

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, cacheNode> map;
    private int capacity;
    private cacheNode head;
    private cacheNode tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<Integer, cacheNode>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            cacheNode node = map.get(key);
            addToHead(node);
            return node.getValue();
        }
        return -1;
    }

    public void set(int key, int value) {
        cacheNode node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.setValue(value);
            addToHead(node);
            return;
        }

        if (map.size() == capacity) {
            cacheNode t = removeFromTail();
            map.remove(t.getKey());
        }
        node = new cacheNode(key, value);
        map.put(key, node);
        addToHead(node);
    }

    private void addToHead(cacheNode node) {
        if (head == node || node == null) {
            return;
        }

        // Initialize
        if (head == null) {
            head = node;
            tail = node;
            return;
        }

        cacheNode nextTmp = node.getNext();
        cacheNode prevTmp = node.getPrev();

        // Standalone nodes
        if (nextTmp == null && prevTmp == null) {
            head.setPrev(node);
            node.setNext(head);
            head = node;
            return;
        }

        if (nextTmp != null && prevTmp == null) {
            return;
        }

        // Tail
        if (node == tail) {
            tail = tail.getPrev();
        }

        node.setNext(head);
        node.setPrev(null);

        head.setPrev(node);

        if (nextTmp != null) { nextTmp.setPrev(prevTmp); }
        if (prevTmp != null) { prevTmp.setNext(nextTmp); }

        head = node;
    }

    private cacheNode removeFromTail() {
        cacheNode t = tail;
        if (head == tail) {
            head = null;
            tail = null;
            return t;
        }
        tail = tail.getPrev();
        tail.setNext(null);
        return t;
    }
}

class cacheNode {
    private int key;
    private int value;
    private cacheNode next;
    private cacheNode prev;

    cacheNode(int k, int v) {
        this.key = k;
        this.value = v;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public cacheNode getNext() {
        return next;
    }

    public void setNext(cacheNode next) {
        this.next = next;
    }

    public cacheNode getPrev() {
        return prev;
    }

    public void setPrev(cacheNode prev) {
        this.prev = prev;
    }
}
