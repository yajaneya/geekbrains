package ru.geekbrains.java1.dz.dz6;

public class Animals {

    protected String name;
    protected int distRun;
    protected double distJump;
    protected int distSwim;

    public Animals (String name) {
        this.name = name;
    }

    public Animals (String name, int distRun, double distJump, int distSwim) {
        this.name = name;
        this.distRun = distRun;
        this.distJump = distJump;
        this.distSwim = distSwim;
    }

    public void run (int dist, String animal) {
        if ((dist<0)|(dist>distRun))
            System.out.println(animal + " " + name + " не пробежит " + dist + " м.");
        else
            System.out.println(animal + " " + name + " пробежал " + dist + " м.");
    }

    public void jump (double dist, String animal) {
        if ((dist<0)|(dist>distJump))
            System.out.println(animal + " " + name + " не допрыгнет " + dist + " м.");
        else
            System.out.println(animal + " " + name + " прыгнул на " + dist + " м.");
    }

    public void swim (int dist, String animal) {
        if (animal == "Кот")
            System.out.println("Кот " + name + " не умеет плавать");
        else if ((dist<0)|(dist>distSwim))
            System.out.println(animal + " " + name + " не доплывёт " + dist + " м.");
        else
            System.out.println(animal + " " + name + " проплыл таки " + dist + " м.");
    }
}
