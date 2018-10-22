package ru.geekbrains.Alg_SD.dz.dz4;

public interface LinkedListIF<T> {

    void insert(T value);
    Link <T> remove();

    boolean isEmpty();

    void display();
    Link<T> find(T value);
}

