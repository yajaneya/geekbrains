package ru.geekbrains.Alg_SD.dz.dz5;

/*
Программа вычисления степени числа с помощью рекурсии

Содержит два перегруженныхи метода:
public static long stepen (long ar, int step) - для работы с целыми числами
public static double stepen (double ar, int step) - для работы с дробными числами

 */


public class Stepen {

    // Тест возведения в степень
    public static void main(String[] args) {
        System.out.println("10^3 = " + stepen(10, 3));
        System.out.println("10^-3 = " + stepen(10, -3));
        System.out.println("10^1 = " + stepen(10, 1));
        System.out.println("10^-1 = " + stepen(10, -1));
        System.out.println("10^0 = " + stepen(10, 0));
        System.out.println("23^6 = " + stepen(23.5, 6));
        System.out.println("165^-24 = " + stepen(165, -24));
    }

    public static long stepen (long ar, int step) {
        if (step == 1)
            return ar;
        if (step == 0)
            return 1;
        if (step == -1)
            return 1/ar;
        if (step > 0)
            return ar * stepen(ar, step-1);
        else
            return 1/stepen(ar, -step);
    }


    public static double stepen (double ar, int step) {
        if (step == 1)
            return ar;
        if (step == 0)
            return 1;
        if (step == -1)
            return 1/ar;
        if (step > 0)
            return ar * stepen(ar, step-1);
        else
            return 1/stepen(ar, -step);
    }

}
