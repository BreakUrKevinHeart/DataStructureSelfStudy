package com.xn.structs.queue;

import java.util.Arrays;

public class ArrayQueue<E> {

    private Object elementData[];

    private int head; // 队头

    private int tail; // 队尾

    public ArrayQueue(){
        this.elementData = new Object[5];
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队
     * @param item
     * @return
     */
    public boolean enQueue(E item){
        if (this.tail >= this.elementData.length){
            this.elementData = Arrays.copyOf(this.elementData, this.elementData.length * 2);
            if (head != 0){
                // 数据迁移
                if (tail - head >= 0){
                    //                 源数组        原数组起始    目标数组        目标数组起始     目标数组复制长度
                    System.arraycopy(this.elementData, head, this.elementData, 0, tail - head);
                }
                tail = tail - head;
                head = 0;
            }
        }
        this.elementData[tail++] = item;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public E deQueue(){
        if (tail == head){
            throw new RuntimeException("队列为空");
        }
        return (E) this.elementData[this.head++];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        arrayQueue.enQueue(1);
        arrayQueue.enQueue(2);
        arrayQueue.enQueue(3);
        System.out.println(arrayQueue.deQueue());
        arrayQueue.enQueue(4);
        arrayQueue.enQueue(5);
        arrayQueue.enQueue(6);
        arrayQueue.enQueue(7);
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
    }
}
