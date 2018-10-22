package ru.geekbrains.Alg_SD.dz.dz4;

public class Stack implements StackIF {

    private LinkedList<Integer> stack;

    public Stack() {
        stack = new LinkedList<>();
    }

    @Override
    public boolean push(int value) {
        stack.insert(value);
        return true;
    }

    @Override
    public int pop() {
        return stack.remove().getLink();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void display() {
        stack.display();
    }
}
