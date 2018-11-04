package ru.geekbrains.Alg_SD.dz.dz8;

public class Main {

    public static void main(String[] args) {

        HashTable ht = new HashTable(10);

        Item it1 = new Item(43);
        Item it2 = new Item(42);
        Item it3 = new Item(48);
        Item it4 = new Item(43);
        Item it5 = new Item(45);
        ht.insert(it1);
        ht.insert(it2);
        ht.insert(it3);
        ht.insert(it4);
        ht.insert(it5);

        System.out.println("Изначальный:");
        ht.display();

        System.out.println("Ищем " + it4 + ", найден - " + ht.find(43));
        System.out.println();

        System.out.println("Удаляем " + it2);
        System.out.println("удалили " + ht.remove(it2) + ":");
        ht.display();

        System.out.println("Удаляем " + it4);
        System.out.println("удалили " + ht.remove(it4) + ":");
        ht.display();

        System.out.println("Удаляем " + it1);
        System.out.println("удалили " + ht.remove(it1) + ":");
        ht.display();

        System.out.println("Удаляем " + it5);
        System.out.println("удалили " + ht.remove(it5) + ":");
        ht.display();

        System.out.println("Удаляем " + it1 + " повторно");
        System.out.println("удалили " + ht.remove(it1) + ":");
        ht.display();

        int numItems = 100;

        System.out.println("Заполним хэштаблицу " + numItems + " случайными элементами с данными от 0 до 100 :");
        for (int i=0; i<numItems; i++) {
            int data = (int) (Math.random()*100);
            ht.insert(new Item(data));
        }

        ht.display();

        System.out.println("Найдем 58, найдено - " + ht.find(58) );

    }
}
