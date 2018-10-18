package ru.geekbrains.Alg_SD.dz.dz3;

public class Queue implements QueueInterface {

    private int[] elements;
    private int front;
    private int rear;
    private int items;
    private int size;

    public Queue(int size) {
        this.size = size;
        this.elements = new int[size];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
    }

    @Override
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return false;
        }
        if (rear == size-1)
            rear = -1;
        elements[++rear] = value;
        items++;
        return true;
    }

    @Override
    public int peek() {
        return elements[front];
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return 0;
        } else {
            int temp = elements[front++];
            if (front == size)
                front = 0;
            items--;
            return temp;
        }
    }

    @Override
    public boolean isEmpty() {
        return (items == 0);
    }

    @Override
    public boolean isFull() {
        return (items == size);
    }

    @Override
    public void display() {
        System.out.println("Содержимое очереди:");
        int index = front;
        for (int i=0; i<=items; i++) {
            if (index == rear+1) break;
            if (index == size) index = 0;
            System.out.println(elements[index++]);
        }
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }
}
