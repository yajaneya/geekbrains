package ru.geekbrains.java1.dz.dz7;

import java.util.Date;

public class Cat {
    private String name;
    private int appetite;
    private boolean sytost;
    private long eatTime; // время еды в миллисекундах, истекших с января 1970 года
    private int golod; // содержит время (на данный момент для удобства демонстрации - количество секунд),
                        // через которые кот проголодается

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.sytost = false;
        this.golod = 3;
        this.eatTime = 0;
    }

    @Override
    public String toString() {
        return "Кот по имени " + name + " с аппетитом " + appetite;
    }

    public String isSytost() {
        if (sytost)
            return "Кот " + name + " - сыт!";
        else
            return "Кот " + name + " - голоден!";
    }

    public void eat(Plate p) {
        Date date = new Date();
        if ((date.getTime()-eatTime)>golod*1000) sytost=false;
        if (!sytost) {
            if (p.decreaseFood(appetite)) {
                sytost=true;
                eatTime=date.getTime();
            }
        } else{
            System.out.println(name + " итак уже сыт!");
        }
    }
}
