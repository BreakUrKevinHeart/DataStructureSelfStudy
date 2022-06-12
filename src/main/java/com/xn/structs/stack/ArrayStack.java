package com.xn.structs.stack;

import java.util.Arrays;

public class ArrayStack<E> {

    private Object[] elementData;

    private int topIndex;

    public ArrayStack(int capacity){
        this.elementData = new Object[capacity];
        this.topIndex = 0;
    }

    /**
     * 入栈操作
     * @param element
     * @return
     */
    public boolean push(E element){
        if(this.topIndex >= elementData.length){
            this.elementData = Arrays.copyOf(elementData, elementData.length * 2);
        }
        elementData[this.topIndex++] = element;
        return true;
    }

    /**
     * 出栈，返回并删除栈顶元素
     * @return
     */
    public E pop(){
        if (this.topIndex <=0){
            throw new RuntimeException("栈顶为空");
        }
        return (E) elementData[--this.topIndex];
    }

    /**
     * 出栈，返回栈顶元素
     * @return
     */
    public E peek(){
        if (this.topIndex <=0){
            throw new RuntimeException("栈顶为空");
        }
        return (E) elementData[this.topIndex - 1];
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println(arrayStack.pop());
        System.out.println("------------------------");
        System.out.println(arrayStack.peek());
        System.out.println(arrayStack.peek());
    }
}
