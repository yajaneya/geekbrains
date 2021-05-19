package ru.geekbrains.java1.dz.dz7;

import java.util.Date;

public class HomeWork7 {
    public static void main(String[] args) {

        Date date = new Date();
        Cat cat = new Cat("Barsik", 5);
        Plate plate = new Plate(10);

        // --- Тестирование задач ---

        System.out.println("В самом начале...");
        plate.info(); // текущее состояние еды в тарелке
        cat.eat(plate); // кот поел
        System.out.println();
        System.out.println("Кот поел, и...");
        plate.info(); // состояние еды в тарелке после еды
        System.out.println();
        System.out.println("Попробуем сразу же покормить ещё раз кота, и...");
        cat.eat(plate); // попытка сытого кота ещё поесть
        System.out.println();
        System.out.println("И тогда...");
        plate.info(); // состояние еды в тарелке после попытки сытого кота поесть

        System.out.println();
        System.out.println("Пройдёт время...");

        // проверка появления голода у кота
        // пауза на время больше 3 секунд, чтобы кот успел проголодаться.
        pause();

        System.out.println();
        System.out.println("Покормим теперь кота, и...");
        cat.eat(plate); // попытка уже проголодавшегося кота поесть
        plate.info(); // состояние еды в тарелке после попытки проголодавшегося кота поесть

        System.out.println();
        System.out.println("Пройдёт ещё время...");

        // дадим коту опять проголадаться
        pause();

        System.out.println();
        System.out.println("Попробуем ещё раз покормить кота, и...");
        cat.eat(plate); // попытка поесть из пустой тарелки

        System.out.println();
        System.out.println("Досадно. Добавим чуть-чуть еды в миску, дадим время коту проголодаться, покормим его, и... ");

        plate.addFood(3); //добавим немного еды в тарелку

        // дадим коту опять проголадаться
        pause();
        cat.eat(plate); // попытка поесть из тарелки с недостаточным количеством еды (


        // по пункту 5. Создание массива котов, отдельной тарелки для них и кормёжка

        // заводим котов
        Cat[] cats = new Cat[11];
        String [] namesCats = {"Мурка", "Жмурка", "Томик", "Бумик", "Манька", "Васька", "Кузька", "Барсик", "Парсик", "Мефодий", "Цуцька"};
        int [] appetitesCats = {3, 4, 2, 6, 3, 11, 6, 3, 8, 5, 1};

        for (int i=0; i<cats.length; i++) {
            cats[i] = new Cat(namesCats[i], appetitesCats[i]);
        }

        // Вывод сех котов
        System.out.println();
        System.out.println("Заведём 11 котов и кошек:");
        for (Cat c: cats) System.out.println(c.toString());

        // берем новую тарелку с едой
        Plate plate1 = new Plate(100);

        System.out.println();
        System.out.println("Возьмём тарелку и наполним её едой");

        plate1.info(); //смотрим, сколько в тарелке еды

        // кормим наших котов
        for (Cat c: cats) c.eat(plate1);

        System.out.println();
        System.out.println("Покормим животных, и...");

        plate1.info(); // смотрим, солько еды в тарелке

        System.out.println();
        System.out.println("Глянем, кто сыт, а кто нет:");
        // смотрим на сытость котов
        for (Cat c: cats) System.out.println(c.isSytost());

        System.out.println();
        System.out.println("Прошло время...");

        // дадим котам проголадаться
        pause();

        // снова кормим наших котов
        System.out.println();
        System.out.println("Ещё покормим котов, и ...");
        for (Cat c: cats) c.eat(plate1);

        plate1.info(); // смотрим, солько теперь еды в тарелке

        System.out.println();
        System.out.println("Опять глянем, кто сыт, а кто нет:");
        // смотрим на сытость котов
        for (Cat c: cats) System.out.println(c.isSytost());
    }

    // метод для задержки, чтобы кот(ы) проголодались
    public static void pause () {
        int paus;
        for (int i = 0; i < 1000000000; i++) {
            for (int j = 0; j<3; j++) paus = 0;
        }
    }
}
