package ru.geekbrains.Alg_SD.dz.dz2;

public class Main {
    private static int size = 1000000; // Устанавливаем размер массива
    private static Arr ar = new Arr(size); // Создаем массив

    public static void main(String[] args) {

        double t;

        addArray();
        ar.toArhiv();
        System.out.println(((ar.isSort())?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов с суммой элеменов " + ar.sumControl());
        t = System.currentTimeMillis();
        ar.sortBub();
        System.out.println("Сортировка пузырьком. Прошло время: " + (System.currentTimeMillis()-t)/1000 + " секунд");
        System.out.println(((ar.isSort())?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов с суммой элеменов " + ar.sumControl());
        System.out.println();

        ar.fromArhiv();
        System.out.println(((ar.isSort())?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов с суммой элеменов " + ar.sumControl());
        t = System.currentTimeMillis();
        ar.sortSel();
        System.out.println("Сортировка выбором. Прошло время: " + (System.currentTimeMillis()-t)/1000 + " секунд");
        System.out.println(((ar.isSort())?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов с суммой элеменов " + ar.sumControl());
        System.out.println();

        ar.fromArhiv();
        System.out.println(((ar.isSort())?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов с суммой элеменов " + ar.sumControl());
        t = System.currentTimeMillis();
        ar.sortIns();
        System.out.println("Сортировка вставкой. Прошло время: " + (System.currentTimeMillis()-t)/1000 + " секунд");
        System.out.println(((ar.isSort())?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов с суммой элеменов " + ar.sumControl());
        System.out.println();

    }

    private static void addArray () { // Заполняем массив случайными целыми числами (от 0 до 999)
        for (int i=0; i<size; i++) {
            ar.insert((int)(Math.random()*1000));
        }
    }

}
