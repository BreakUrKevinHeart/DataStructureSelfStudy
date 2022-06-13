package com.xn.structs.hash;

public class HashTable<K, V> {

    // 散列表（数组结构，每一个元素都是链表结构）
    private Node<K, V>[] table;

    private static class Node<K, V> {
        // hash函数计算的结果
        final int hash;

        final K key; // 键是不可变的

        V value;

        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public HashTable() {
        table = (Node<K, V>[]) new Node[5];
    }

    public void put(K key, V value) {
        // 1.计算哈希值
        int hash = hash(key);
        int i = (table.length - 1) & hash; // 得到数组里的索引值
        Node<K, V> node = new Node<>(hash, key, value, null); // 要插入的节点
        Node<K, V> kvNode = table[i];
        if (kvNode == null) {
            // 这个数组位置没有数据，是第一个
            table[i] = node;
            return;
        }
        // 数组位置有值
        if (kvNode.key.equals(key)) { // key已经存在
            kvNode.value = value;
        } else {
            kvNode.next = node;
        }
    }

    public V get(K key) {
        // 1.计算哈希值
        int hash = hash(key);
        int i = (table.length - 1) & hash; // 得到数组里的索引值
        Node<K, V> node = table[i];
        if (node == null){
            return null;
        }
        Node<K, V> newNode = node;
        // 循环，查找key是否匹配
        while (newNode.next != null){
            if (newNode.key.equals(key)){
                break;
            }
            newNode = newNode.next;
        }
        return newNode.value;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        HashTable<String, String> table = new HashTable<>();
        table.put("key1", "1");
        table.put("key2", "2");
        table.put("key3", "3");

        System.out.println(table.get("key1"));
        System.out.println(table.get("key2"));
        System.out.println(table.get("key3"));
    }
}
