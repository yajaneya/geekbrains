package ru.geekbrains.Alg_SD.dz.dz6;

public class Node {

    private int value;
    private Node leftChild;
    private Node rightChild;
    private int level;

    public Node(int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getKey () {
        return value;
    }

    public int getData () {
        return value;
    }

    public boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    public void display() {
        System.out.println(getKey() + " : " + getData());
    }
}
