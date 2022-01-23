package ru.geekbrains.Alg_SD.dz.dz4;

public class TwoSideLinkedList<T> extends LinkedList<T> implements TwoSideLinkedListIF<T>{

    private Link<T> last;

    @Override
    public void insertLast(T value) {
        Link<T> link = new Link<>(value);
        if (isEmpty()) {
            first = link;
        } else{
            last.setNext(link);
        }
        last = link;
        size++;
    }

    @Override
    public Link<T> removeLast() {
        if (isEmpty()){
            System.out.println("Список пуст");
            return null;
        }
        if (first == last){
            Link<T> temp = first;
            first = last = null;
            size = 0;
            return temp;
        }
        Link<T> prevoius = first;
        Link<T> current = first;
        while (current !=last) {
            prevoius = current;
            current = current.getNext();
        }
        last = prevoius;
        prevoius.setNext(null);
        size--;
        return current;
    }

    @Override
    public void insert(T value) {
        super.insert(value);
        if (size == 1)
            last = first;
    }

    @Override
    public Link<T> remove() {
        return super.remove();
    }
}
