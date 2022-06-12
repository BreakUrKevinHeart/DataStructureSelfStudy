package com.xn.structs.queue;

public class ListQueue<E> {

    private static class Node<E> {

        private E item;

        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> head; // 队头

    private Node<E> tail; // 队尾

    private int size; // 队列长度

    public ListQueue() {
        size = 0;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enQueue(E item) {
        if (this.tail == null) { // 当队列为空时入队
            this.tail = new Node<>(item, null);
            this.head = this.tail;
            size++;
        } else {
            this.tail.next = new Node<>(item, null);
            this.tail = this.tail.next;
            size++;
        }
        return true;
    }

    /**
     * 出队
     * @return
     */
    public E deQueue(){
        if (head == null){
            throw new RuntimeException("队列为空");
        }
        E item = head.item;
        head = head.next;
        return item;
    }

    public static void main(String[] args) {
        ListQueue<Integer> listQueue = new ListQueue<>();
        listQueue.enQueue(1);
        listQueue.enQueue(2);
        listQueue.enQueue(3);
        listQueue.enQueue(4);
        System.out.println(listQueue.deQueue());
        System.out.println(listQueue.deQueue());
        System.out.println(listQueue.deQueue());
        System.out.println(listQueue.deQueue());
    }
}
