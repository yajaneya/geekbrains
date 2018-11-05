package ru.geekbrains.Alg_SD.dz.dz5.ExBackpack;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // установка емкости рюкзака
        int capacity = 5;

        // Инициализация набора вещей
        String[] names = {"Книга", "Бинокль", "Аптечка", "Ноутбук", "Котелок"};
        int[] weights = {1, 2, 4, 2, 1};
        int[] costs = {600, 5000, 1500, 40000, 500};
        List<Thing> things = new ArrayList<Thing>();
        System.out.println("*** Все вещи ***");
        for (int i=0; i<names.length; i++) {
            things.add(new Thing(names[i], weights[i],costs[i]));
            System.out.println(things.get(i).toString());;
        }
        System.out.println();

        Backpack backpack = new Backpack(things,capacity);
        backpack.getMaxCostThings();

        System.out.println("Наилучший набор вещей в рюкзаке с вместимостью " + capacity + " :");
        backpack.displayMaxCostThings();
        System.out.println("---------");
        System.out.println("*** Общая стоимость набора: " + backpack.getMaxCost() + " ***");
        System.out.println("Набор найден за " + backpack.getCount() + " итераций.");



    }
}
