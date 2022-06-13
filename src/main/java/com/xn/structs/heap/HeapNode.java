package com.xn.structs.heap;

public class HeapNode {

    // 堆中元素大小
    private int size;

    // 堆数组
    private int[] heap;

    public HeapNode(){
        this.heap = new int[10];
    }

    /**
     * 往堆中放入数据，小顶堆
     */
    public void offer(int n){
        int i = size;
        while (i > 0){
            int parent = (i - 1) >>> 1; // 相当于 (size - 1) / 2，取中位
            int v = heap[parent];
            if (n >= v){
                break;
            }
            heap[i] = v;
            i = parent;
        }
        this.heap[i] = n;
        size++;
    }

    public int poll(){
        //将堆顶元素 弹出，并且删除
        //需要重新构建堆
        int top = heap[0];
        int[] newHeap = new int[size-1];
        System.arraycopy(heap,1,newHeap,0,size-1);
        heap = new int[heap.length];
        size = 0;
        for (int i : newHeap) {
            offer(i);
        }
        return top;
    }

    public int peek(){
        return heap[0];
    }

    public static void main(String[] args) {
        HeapNode heapNode = new HeapNode();
        heapNode.offer(4);
        heapNode.offer(3);
        heapNode.offer(6);
        heapNode.offer(2);
        heapNode.offer(9);
        heapNode.offer(7);
        System.out.println(heapNode.peek());
        System.out.println(heapNode.poll());
        heapNode.offer(1);
        System.out.println(heapNode.peek());
    }
}
