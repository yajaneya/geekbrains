package ru.geekbrains.java1.dz_2.dz2;

// Это моё (почти моё, - придумал его не я) исключение, бросающееся на неправильные данные в массиве

public class MyArrayDataException extends RuntimeException {

    public MyArrayDataException(String message) {
        super(message);
        System.out.println(message);
    }
}
