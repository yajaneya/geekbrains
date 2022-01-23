package ru.geekbrains.Alg_SD.dz.dz4;

public interface TwoSideLinkedListIF<T> extends LinkedListIF<T> {

    void insertLast(T value);

    Link<T> removeLast ();

}
