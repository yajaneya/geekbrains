package ru.geekbrains.Alg_SD.dz.dz4;

public class Queue implements QueueIF {

    private TwoSideLinkedList<Integer> queue;

    public Queue() {
        queue = new TwoSideLinkedList<>();
    }

    @Override
    public boolean insert(int value) {
        queue.insertLast(value);
        return true;
    }

    @Override
    public int remove() {
        return queue.remove().getLink();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        queue.display();
    }
}
