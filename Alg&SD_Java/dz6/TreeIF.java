package ru.geekbrains.Alg_SD.dz.dz6;

public interface TreeIF {

    void add (int value);
    int remove (int key);

    int find (int key);

    boolean isEmpty();
    void display();
    int getSize();

    void traverse (TraverseMode mode);

}
