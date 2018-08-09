package ru.geekbrains.java1.dz.dz7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food <= 0) {
            System.out.println("Миска пуста!!!");
            return false;
        }
        else if (food<n){
            System.out.println("В миске недостаточно еды, однако!");
            return false;
        }
        else{
            food -=n;
            return true;
        }
    }

    public void addFood(int f) {
        food = food + f;
    }

    public void info() {
        System.out.println("В тарелке еды: "+food);
    }
}
