package ru.geekbrains.Alg_SD.dz.dz3;

/*
*** Интерфейс для очередей/стеков ***

Методы
-------------
boolean insert(int value) - добавляет элемент
int peek() - выводит текущий элемент
int remove() - удаляет элемент
boolean isEmpty() - показатель пустоты
boolean isFull() - показатель заполненности
void display() - выводит текущее состояние


*/

public interface QueueInterface {

    boolean insert(int value);
    int peek();
    int remove();

    boolean isEmpty();
    boolean isFull();

    void display();
}
