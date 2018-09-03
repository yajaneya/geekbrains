package ru.geekbrains.java1.dz_2.dz2;

// Это моё (почти моё, - придумал его не я) исключение, бросающееся на несоразмерность массива

public class MyArraySizeException extends RuntimeException {

    public MyArraySizeException(String message) {
        super(message);
        System.out.println(message);
    }
}
