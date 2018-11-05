package ru.geekbrains.Alg_SD.dz.dz5.ExBackpack;

import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private List<Thing> allThings;
    private int capacity;
    private List <Thing> maxCostThings;
    private int maxCost;
    private int count;

    public Backpack(List<Thing> allThings, int capacity) {
        this.allThings = allThings;
        this.capacity = capacity;
    }

    public void displayMaxCostThings() {
        for (Thing thing : maxCostThings) {
            System.out.println(thing.getName() + ", вес: " + thing.getWeight() + ", стоимость: " + thing.getCost());
        }
    }

    public List<Thing> getMaxCostThings() {
        calcMaxCostThings(allThings);
        return maxCostThings;
    }

    public int getMaxCost() {
        return maxCost;
    }

    public int getCount() {
        return count;
    }

    private void calcMaxCostThings (List<Thing> things) {
        if (things.size() >0) {
            setMaxCostThings(things);
            count++;
        }

        for (int i=0; i<things.size(); i++) {
            List<Thing> list = new ArrayList<>(things);
            list.remove(i);
            calcMaxCostThings(list);
        }
    }

    private void setMaxCostThings (List<Thing> things) {
        if (weigthCalc(things) <= capacity) {
            if ((maxCostThings == null)||(costCalc(things) > maxCost)) {
                maxCostThings = things;
                maxCost = costCalc(things);
            }
        }
    }

    private int costCalc (List<Thing> things) {
        int cost = 0;
        for (Thing t: things) {
            cost += t.getCost();
        }
        return cost;
    }

    private int weigthCalc (List<Thing> things) {
        int weigth = 0;
        for (Thing t: things) {
            weigth += t.getWeight();
        }
        return weigth;
    }

}
