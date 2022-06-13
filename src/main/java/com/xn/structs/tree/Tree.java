package com.xn.structs.tree;

public class Tree<E> {

    private E item;

    private Tree<E> left; // 左指针

    private Tree<E> right;

    public Tree(E item){
        this.item = item;
    }

    public Tree<E> buildLeft(E item){
        this.left = new Tree<>(item);
        return this.left;
    }

    public Tree<E> buildRight(E item){
        this.right = new Tree<>(item);
        return this.right;
    }

    public void printPreOrder(){
        // 根左右
        System.out.print(this.item + " > ");
        print(this.left);
        print(this.right);
    }

    private void print(Tree<E> node) {
        if (node == null) return;
        System.out.print(node.item + " > ");
        print(node.left);
        print(node.right);
    }

    public static void main(String[] args) {
        Tree<Integer> root = new Tree<>(10);
        Tree<Integer> left = root.buildLeft(6);
        Tree<Integer> left1 = left.buildLeft(4);
        left1.buildLeft(2);
        left.buildRight(8);
        Tree<Integer> right = root.buildRight(18);
        right.buildLeft(13);
        right.buildRight(20);
        root.printPreOrder();

    }
}
