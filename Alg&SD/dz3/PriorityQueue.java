package ru.geekbrains.Alg_SD.dz.dz3;

/*
*** Класс для организации приоритетной очереди ***

Поля класса
-----------
private int[] elements; - массив, содержащий элементы очереди
private int items; - количество элементов очереди
private int size; - максимальный размер очереди


Методы класса
-------------
public boolean insert(int value) - добавляет элемент в соответствующее место очереди
public int peek() - выводит текущий элемент
public int remove() - удаляет элемент очереди
public boolean isEmpty() - показатель пустоты очереди
public boolean isFull() - показатель заполненности очереди
public void display() - выводит текущее состояние очереди в консоль

*/

public class PriorityQueue implements QueueInterface {
    private int[] elements;
    private int items;
    private int size;

    public PriorityQueue(int size) {
        this.size = size;
        this.elements = new int[size];
        this.items = 0;
    }

    @Override
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return false;
        }
        if (items == 0)
            elements[items++] = value;
        else {
            int i;
            for (i=items-1; i>=0; i--) {
                if (value > elements[i])
                    elements[i+1] = elements[i];
                else
                    break;
            }
            elements[i+1] = value;
            items++;
        }
        return false;
    }

    @Override
    public int peek() {
        return elements[items-1];
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return 0;
        }
        return elements[--items];
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
        for (int i=0; i<items; i++) {
            System.out.print(elements[i] + "   ");
        }
        System.out.println();
    }
}
