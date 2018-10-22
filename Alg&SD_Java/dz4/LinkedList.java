package ru.geekbrains.Alg_SD.dz.dz4;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<T> implements LinkedListIF<T>, Iterable{

    protected Link<T> first;
    protected int size;

    public LinkedList() {
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public Link<T> getFirst() {
        return first;
    }

    public void setFirst(Link<T> first) {
        this.first = first;
    }

    public LinkIterator getIterator() {
        return null;
    }

    @Override
    public void insert(T value) {
        Link<T> link = new Link<>(value);
        link.setNext(first);
        first = link;
        size++;

    }

    @Override
    public Link <T> remove() {
        if (isEmpty()) {
            System.out.println("Список пуст.");
            return null;
        }
        Link<T> temp = first;
        first = first.getNext();
        size--;
        return temp;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void display() {
        Link<T> current = first;
        if (current == null) {
            System.out.println("Список пуст.");
            return;
        }
        System.out.print(current.getLink());
        current = current.getNext();
        if (current == null) {
            System.out.println();
            return;
        }
        while (current != null) {
            System.out.print(" -> " + current.getLink());
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public Link<T> find(T value) {
        Link<T> find = new Link<>(value);
        Link<T> current = first;
        while (current != null) {
            if (current.getLink().equals(find.getLink()))
                return current;
        }
        return null;
    }

    @Override
    public Iterator iterator() {
        return new LinkIterator(this);
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }
}
