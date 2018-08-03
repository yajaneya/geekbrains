package ru.geekbrains.java1.dz.dz6;

public class Cat extends Animals{
    private int distRun;
    private double distJump;

    public Cat(String name) {
        super(name);
        distRun = 200;
        distJump = 2;
    }

    public Cat(String name, int distRun, double distJump) {
        super(name);
        this.distRun = distRun;
        this.distJump = distJump;
    }

    public void run (int dist) {
        if ((dist<0)|(dist>distRun)) System.out.println("Кот " + name + " не пробежит " + dist + " м.");
        else System.out.println("Кот " + name + " пробежал " + dist + " м.");
    }

    public void jump (double dist) {
        if ((dist<0)|(dist>distJump)) System.out.println("Кот " + name + " не допрыгнет " + dist + " м.");
        else System.out.println("Кот " + name + " прыгнул на " + dist + " м.");
    }

    public void swim (int dist) {
        System.out.println("Кот " + name + " не умеет плавать");
    }
}
