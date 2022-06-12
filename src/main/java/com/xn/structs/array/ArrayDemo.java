package com.xn.structs.array;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayDemo<E> implements Iterable<E> {

    private Object[] elementData;
    private int index;

    public ArrayDemo(int capacity) {
        // 数组初始化
        this.elementData = new Object[capacity];
        this.index = 0;
    }

    public ArrayDemo() {
        // 数组初始化
        elementData = new Object[5];
        this.index = 0;
    }

    /*
    public boolean add(E element) {
        int size = elementData.length; // 下标从0开始，0,1,2,.....size - 1
        int newCapacity = size + 1;
        // 性能消耗，新增数据时需要扩容
        elementData = Arrays.copyOf(elementData, newCapacity);
        elementData[size] = element;
        return true;
    }
     */

    public boolean add(E element) {
        int size = this.elementData.length;
        if (index >= size - 1) { // 下标到达最大长度
            int newSize = size * 2;
            this.elementData = Arrays.copyOf(this.elementData, newSize);
        }
        this.elementData[this.index++] = element;
        return true;
    }

    public E set(int index, E element) {
        E oldValue = (E) this.elementData[index];
        this.elementData[index] = element;
        return oldValue;
    }

    public E get(int index) {
        return (E) this.elementData[index];
    }

    public E pop() {
        int index = 0;
        for (Object data : elementData) {
            if (data != null) {
                index++;
            } else {
                break;
            }
        }
        E oldValue = (E) this.elementData[index - 1];
        this.elementData[index - 1] = null;
        return oldValue;
    }

    public E pop(int index) { // 传入下标删除元素
        E oldValue = (E) this.elementData[index];
        this.elementData[index] = null;
        return oldValue;
    }


    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> { // 迭代器

        int index = 0;

        @Override
        public boolean hasNext() {
            return index != elementData.length;
        }

        @Override
        public E next() {
            return (E) elementData[index++];
        }
    }

    public static void main(String[] args) {
        ArrayDemo<String> arrayDemo = new ArrayDemo<>();
        arrayDemo.add("11");
        arrayDemo.add("22");
        arrayDemo.add("33");
        arrayDemo.add("44");
        arrayDemo.set(0, "1");
        arrayDemo.pop();
        for (String s : arrayDemo) {
            System.out.println(s);
        }
    }
}
