package ru.geekbrains.Alg_SD.dz.dz3;

public interface QueueInterface {

    boolean insert (int value);
    int peek ();
    int remove();

    boolean isEmpty();
    boolean isFull();

    void display();
}
