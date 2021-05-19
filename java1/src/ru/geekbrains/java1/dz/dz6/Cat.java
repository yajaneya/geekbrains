package ru.geekbrains.java1.dz.dz6;

public class Cat extends Animals{

    public Cat(String name) {
        super(name);
        super.distRun = 200;
        super.distJump = 2;
    }

    public Cat(String name, int distRun, double distJump) {
        super(name, distRun, distJump, 0);
   }

    public void run (int dist) {
        super.run (dist, "Кот");
    }

    public void jump (double dist) {
        super.jump (dist, "Кот");
    }

    public void swim (int dist) {
        super.swim (dist, "Кот");
    }

}
