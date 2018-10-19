package ru.geekbrains.Alg_SD.dz.dz3;

/*
*** Класс для организации двусторонней очереди (деки) ***

Поля класса
-----------
private int[] elements; - массив, содержащий элементы очереди
private int front; - маркер начала очереди
private int rear; - маркер конца очереди
private int items; - количество элементов очереди
private int size; - максимальный размер очереди
boolean left; - указатель задействуемого края очереди (true - левый край, false - правый край)


Методы класса
-------------
public boolean insert(int value) - добавляет элемент в очередь слева или справа (зависит от поля left)
public int peek() - выводит текущий элемент очереди слева или справа (зависит от поля left)
public int remove() - удаляет элемент очереди слева или справа (зависит от поля left)
public boolean isEmpty() - показатель пустоты очереди
public boolean isFull() - показатель заполненности очереди
public void display() - выводит текущее состояние очереди в консоль


*/



public class Deque implements QueueInterface {

    private int[] elements;
    private int front;
    private int rear;
    private int items;
    private int size;
    boolean left;

    public Deque(int size) {
        this.size = size;
        this.elements = new int[size];
        this.front = 0;
        this.rear = -1;
        this.items = 0;
        this.left = true;
    }

    @Override
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Очередь заполнена");
            return false;
        }
        if (left) {
            if (front == 0)
                front = size-1;
            else
                front--;
            elements[front] = value;
            items++;
            return true;
        } else {
            if (rear == size-1)
                rear = -1;
            elements[++rear] = value;
            items++;
            return true;
        }
    }

    @Override
    public int peek() {
        return left ? elements[front] : elements[rear];
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            System.out.println("Очередь пуста");
            return 0;
        } else {
            int temp;
            if (left) {
                temp = elements[front++];
                if (front == size)
                    front = 0;
                items--;
            } else {
                temp = elements[--rear];
                if (rear == 0)
                    rear = size;
                items--;
            }

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
        for (int i=0; i<items; i++) {
            if ((index!=front)&&(index == rear+1)) break;
            if (index == size) index = 0;
            System.out.print(elements[index++] + "   ");
        }
        System.out.println();
    }
}
