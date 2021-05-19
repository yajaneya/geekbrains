package ru.geekbrains.java1.dz.dz6;

public class HomeWork6 {
    public static void main(String[] args) {

        Cat c1 = new Cat("Барсик");
        c1.run(100);
        c1.run(250);
        c1.jump( 1.5);
        c1.jump(5);
        c1.swim(2);

        Dog d1 = new Dog("Дана");
        d1.run(300);
        d1.run(2500);
        d1.jump( 3);
        d1.jump(0.2);
        d1.swim(7);
        d1.swim(11);

        Dog d2 = new Dog ("Корвет", 600, 1, 35);
        d2.run(550);
        d2.jump(1);
        d2.swim(33);
        d2.run(1000);
        d2.jump(10);
        d2.swim(1000);

        Cat c2 = new Cat("Жмушка", 1000, 10);
        c2.run(1000);
        c2.jump(10);
        c2.swim(100);
    }
}
