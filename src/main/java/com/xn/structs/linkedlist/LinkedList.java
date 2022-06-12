package com.xn.structs.linkedlist;

import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {

    private int size;

    private Node<E> head; // 头节点

    private Node<E> last; // 尾节点


    private static class Node<E> {

        E item;
        Node<E> prev;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public boolean addLast(E element) {
        final Node<E> l = last; // 获取旧的尾节点
        Node<E> newNode = new Node<>(l, element, null); // 初始化将要添加的新节点
        last = newNode; // 新的尾节点
        if (l == null) { // 旧的尾节点为空，即原链表为空
            head = newNode;
        } else { // 旧的尾节点有值，则在此尾节点后接入新节点
            l.next = newNode;
        }
        size++;
        return true;
    }

    public boolean insert(int index, E element){
        Node<E> x = node(index - 1);
        Node<E> newNode = new Node<>(x, element, x.next);
        size++;
        x.next.prev = newNode;
        x.next = newNode;
        return true;
    }

    public E set(int index, E element) {
        Node<E> x = node(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) { // 相当于 index < size / 2
            Node<E> x = head;
            for (int i = 0; i < index; i++) {
                x = head.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = last.prev;
            }
            return x;
        }
    }

    public E get(int index) {
        return node(index).item;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            return get(index++);
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        // linkedList.set(1, 5);
        linkedList.insert(2, 6);
        while (linkedList.head != null){
            System.out.println(linkedList.head.item);
            linkedList.head = linkedList.head.next;
        }
    }
}
