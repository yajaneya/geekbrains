package ru.geekbrains.Alg_SD.dz.dz5.ExBackpack;

public class Thing {
    private String name;
    private int weight;
    private int cost;

    public Thing(String name, int weight, int cost) {
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "{"+name+", вес: "+weight+", стоимость "+cost+"}";
    }
}
