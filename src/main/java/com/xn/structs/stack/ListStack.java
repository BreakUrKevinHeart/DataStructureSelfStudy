package com.xn.structs.stack;

public class ListStack<E> {

    private static class Node<E>{
        E item;
        Node<E> next;

        public Node(){}

        public Node(E item, Node<E> next){
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> head; // 头节点

    private int size; // 元素个数

    public ListStack(){
        this.size = 0;
    }

    /**
     * 入栈
     * @param item
     * @return
     */
    public boolean push(E item){
        head = new Node<>(item, head); // 参数里的head是改变之前的head
        size++;
        return true;
    }

    /**
     * 出栈，返回并删除栈顶元素
     * @return
     */
    public E pop(){
        if (head == null){
            throw new RuntimeException("栈为空");
        }
        Node<E> old = head;
        head = head.next;
        size--;
        return old.item;
    }

    /**
     * 出栈，返回栈顶元素
     * @return
     */
    public E peek(){
        if (head == null){
            throw new RuntimeException("栈为空");
        }
        return head.item;
    }

    public static void main(String[] args) {
        ListStack listStack = new ListStack();
        listStack.push(1);
        listStack.push(2);
        listStack.push(3);
        listStack.push(4);
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println(listStack.pop());
        System.out.println("------------------------");
        System.out.println(listStack.peek());
        System.out.println(listStack.peek());
    }

}
