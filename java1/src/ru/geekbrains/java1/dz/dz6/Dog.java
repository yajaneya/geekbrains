package ru.geekbrains.java1.dz.dz6;

public class Dog extends Animals{
    private int distRun;
    private double distJump;
    private int distSwim;


    public Dog(String name) {
        super(name);
        distRun = 500;
        distJump = 0.5;
        distSwim = 10;
    }

    public Dog(String name, int distRun, double distJump, int distSwim) {
        super(name);
        this.distRun = distRun;
        this.distJump = distJump;
        this.distSwim = distSwim;
    }

    public void run (int dist) {
        if ((dist<0)|(dist>distRun)) System.out.println("Пёс " + name + " не пробежит " + dist + " м.");
        else System.out.println("Пёс " + name + " пробежал " + dist + " м.");
    }

    public void jump (double dist) {
        if ((dist<0)|(dist>distJump)) System.out.println("Пёс " + name + " не допрыгнет " + dist + " м.");
        else System.out.println("Пёс " + name + " прыгнул на " + dist + " м.");
    }

    public void swim (int dist) {
        if ((dist<0)|(dist>distSwim)) System.out.println("Пёс " + name + " не доплывёт " + dist + " м.");
        else System.out.println("Пёс " + name + " проплыл таки " + dist + " м.");
    }
}
