package ru.geekbrains.Alg_SD.dz.dz4;

public interface QueueIF {

    boolean insert (int value);
    int remove();

    boolean isEmpty();
    boolean isFull();

    void display();

}
