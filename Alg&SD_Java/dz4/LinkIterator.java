package ru.geekbrains.Alg_SD.dz.dz4;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkIterator<T> implements Iterator{

    private Link <T> current;
    private Link <T> previos;
    private LinkedList <T> list;

    public LinkIterator(LinkedList<T> list) {
        this.list = list;
        this.reset();
    }

    public void reset() {
        current = list.getFirst();
        previos = null;
    }

    public boolean atEnd() {
        return (current.getNext() == null);
    }

    public void nextLink() {
        previos = current;
        current = current.getNext();
    }

    public Link <T> getCurrent() {
        return current;
    }

    public Link <T> deleteCurrent() {
        Link temp = current;
        remove();
        return temp;
    }

    public void insertAfter (Link <T> l) {
        if (list.isEmpty()) {
            list.setFirst(l);
            current = l;
        } else {
            l.setNext(current.getNext());
            current.setNext(l);
            nextLink();
        }
    }

    public void insertBefore (Link <T> l) {
        if (previos == null) {
            l.setNext(list.getFirst());
            list.setFirst(l);
            reset();
        } else {
            l.setNext(previos.getNext());
            previos.setNext(l);
            current = l;
        }
    }

    @Override
    public boolean hasNext() {
        return (current != null);
    }

    @Override
    public Link <T> next() {
        return current;
    }

    @Override
    public void remove() {
        if (previos == null) {
            list.setFirst(current.getNext());
            reset();
        } else {
            previos.setNext(current.getNext());
            if (atEnd()) {
                reset();
            } else {
                current = current.getNext();
            }
        }
    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
