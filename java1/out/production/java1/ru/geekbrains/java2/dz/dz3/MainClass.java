package ru.geekbrains.java2.dz_2.dz3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class MainClass {
    public static void main (String [] args) {

        System.out.println("Задание 1");
        System.out.println("-------------");
        String [] mass = {"лето", "осень", "весна", "зима", "январь", "лето", "август", "осень", "март", "май", "май", "солнце", "небо", "нёбо", "окно", "май"};
        System.out.println("Изначальный массив:");
        ArrayList<String> al = new ArrayList(Arrays.asList(mass));
        System.out.println(al);
        System.out.println();
        System.out.println("Список уникальных слов из массива (без дублей):");
        LinkedHashSet<String> hs = new LinkedHashSet(Arrays.asList(mass));
        System.out.println(hs);
        System.out.println();

        System.out.println("Задание 2");
        System.out.println("-------------");
        TelefonSprav ts = new TelefonSprav(); //создаем пустой телефонный справочник
        // заполняем справочник
        ts.add("Иванов", "+79784532343"); // добавляем Иванова
        ts.add("Петров", "+79784358765"); // добавляем Петрова
        ts.add("Иванов", "+79789807646"); // добавляем ещё одного Иванова
        ts.add("Карпов", "+79789345646");  // добавляем ещё и ещё...
        ts.add("Лодкина", "+79789805432");
        ts.add("Петрова", "+79789434425");
        ts.add("Лодкина", "+79784542235");
        ts.add("Иванов", "+79789834532");


        System.out.println("Содержимое телефонного справочника:");
        System.out.println(ts.getTelsprav()); // смотрим содержимое справочника
        System.out.println();
        ts.infoTtlsprav();

        // смотрим телефонные номера
        ts.get("Иванов");
        ts.get("Петров");
        ts.get("Петрова");
        ts.get("Лодкина");

    }
}
