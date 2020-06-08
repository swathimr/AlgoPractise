package OODesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// for both apparoach time O(1) and space O(capacity)
class LRUCacheImpl {

    class LRUCache extends LinkedHashMap<Integer,Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity,0.75f,true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }

    /**
     * More complicated approach
     * build your own doubly linkedlist and add it to map
     */
    class LRUCacheAppr2 {

        class DLinkedNode {
            int key;
            int value;
            DLinkedNode prev;
            DLinkedNode next;
        }

        private void addNode(DLinkedNode node) {
            node.prev = head;
            node.next = head.next;

            head.next.prev = node;
            head.next = node;
        }

        private void removeNode(DLinkedNode node) {
            DLinkedNode prev = node.prev;
            DLinkedNode next = node.next;

            prev.next = next;
            next.prev = prev;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addNode(node);
        }

        private DLinkedNode popTail() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private Map<Integer, DLinkedNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkedNode head,tail;

        public LRUCacheAppr2(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if(node == null)
                return -1;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if(node == null) {
                DLinkedNode newNode = new DLinkedNode();
                newNode.key = key;
                newNode.value = value;
                cache.put(key,newNode);
                addNode(newNode);
                size++;

                if(size > capacity) {
                    DLinkedNode tail = popTail();
                    cache.remove(tail.key);
                    size--;
                }

            } else {
                node.value = value;
                moveToHead(node);
            }
        }
    }

}
