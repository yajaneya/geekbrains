package ru.geekbrains.java1.dz.dz1;

public class HomeWork1 {
    public static void main(String[] args) {
        byte b = 127;
        short sh = -32768;
        int i = 2147483646;
        long l = 1000000000000L;
        float f = 345.32f;
        double d = 43.5646456;
        boolean bool = true;
        char ch = 'Y';

        // Тесты методов

        // пункт 3 ДЗ
        System.out.println("Тестирование метода по пункту 3 ДЗ");
        System.out.println(vyr(4, 6, 5, 3));
        System.out.println(vyr(4.433, 34.343, 23424.5343, -32343));
        System.out.println(vyr(4343, -6, 5343, 0.4343));
        System.out.println(vyr(0, 0, 0, 1));
        System.out.println("");

        // пункт 4 ДЗ
        System.out.println("Тестирование метода по пункту 4 ДЗ");
        System.out.println(srav(2.43, 9.12));
        System.out.println(srav(-12.43, 19.12));
        System.out.println(srav(0, 0));
        System.out.println(srav(1, 2));
        System.out.println("");

        // пункт 5 ДЗ
        System.out.println("Тестирование метода по пункту 5 ДЗ");
        testznak(9);
        testznak(0);
        testznak(-12);
        System.out.println("");

        // пункт 6 ДЗ
        System.out.println("Тестирование метода по пункту 6 ДЗ");
        System.out.println(testminus(9));
        System.out.println(testminus(0));
        System.out.println(testminus(-12));
        System.out.println("");

        // пункт 7 ДЗ
        System.out.println("Тестирование метода по пункту 7 ДЗ");
        privet("Вася");
        privet("Иван");
        privet("Анастасия");
        System.out.println("");

        // пункт 8* ДЗ
        System.out.println("Тестирование метода по пункту 8 ДЗ");
        vysokyear (2018);
        vysokyear (0);
        vysokyear (4);
        vysokyear (100);
        vysokyear (400);
        vysokyear (1999);
        vysokyear (2020);
        vysokyear (2000);
        System.out.println("");

    }

    public static double vyr(double a, double b, double c, double d) {
        return a * (b + (c / d));
    }


    public static boolean srav(double a, double b) {
        if (((a + b) >= 10) && ((a + b) <= 20)) return true;
        else return false;
    }


    public static void testznak(int a) {
        if (a >= 0) System.out.println("Число " + a + " - положительное");
        else System.out.println("Число " + a + " - отрицательное");
    }


    public static boolean testminus(int a) {
        if (a < 0) return true;
        return false;
    }


    public static void privet (String name) {
        System.out.println("Привет, " + name + "!");
    }


    public static void vysokyear (int year) {

        boolean vys = false;

        if (year % 4 == 0) vys = true;
        if (year % 100 == 0) vys = false;
        if (year % 400 == 0) vys = true;
        if (year == 0) vys = false;

        if (vys) System.out.println("Год " + year + " - высокосный, однако!");
    }

}
