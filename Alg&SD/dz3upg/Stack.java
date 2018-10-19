package ru.geekbrains.Alg_SD.dz.dz3;

/*
*** Класс описывает Стек ***

Поля класса
-----------
elements - int[] массив, в котором содержится стек
size - int размер стека

Методы класса
-------------
boolean insert (int value) - добавление в верх стека (успешное добавление - true, стек заполнен - false)
int peek () - вывод верхнего элемента стека
int remove () - снятие (с удалением) верхнего элемента стека
boolean isEmpty () - проверка на опустощение стека (пустой - true, не пустой - false)
boolean isFull () - проверка на заполненность стека (полный - true, не полный - false)
void display () - выводит стек в консоль

 */

public class Stack implements QueueInterface {

    private int elements[];
    private int size;

    public Stack(int maxSize) {
        this.size = 0;
        this.elements = new int[maxSize];
    }

    @Override
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Стек заполнен");
            return false;
        }
        elements[size++] = value;
        return true;
    }

    @Override
    public int peek() {
        return elements[size];
    }

    @Override
    public int remove() {
        if (isEmpty()) {
            System.out.println("Стек пуст");
            return 0;
        } else
            return elements[--size];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size >= elements.length;
    }

    @Override
    public void display() {
        System.out.println("Содержимое стека:");
        for (int i = size-1; i>=0; i--)
            System.out.println(elements[i]);
    }
}
