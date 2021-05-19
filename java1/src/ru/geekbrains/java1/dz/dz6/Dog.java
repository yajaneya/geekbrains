package ru.geekbrains.java1.dz.dz6;

public class Dog extends Animals{

    public Dog(String name) {
        super(name);
        super.distRun = 500;
        super.distJump = 0.5;
        super.distSwim = 10;
    }

    public Dog(String name, int distRun, double distJump, int distSwim) {
        super(name, distRun, distJump, distSwim);
    }

    public void run (int dist) {
        super.run (dist, "Пёс");
    }

    public void jump (double dist) {
        super.jump (dist, "Пёс");
    }

    public void swim (int dist) {
        super.swim (dist, "Пёс");
    }
}
