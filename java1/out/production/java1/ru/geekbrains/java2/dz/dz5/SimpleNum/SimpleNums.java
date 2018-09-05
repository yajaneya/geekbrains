package ru.geekbrains.java2.dz_2.dz5.SimpleNum;

import java.util.ArrayList;

public class SimpleNums implements Runnable{
    private int numMin; // начало интервала поиска простых чисел
    private int numMax; // конец интервала поиска простых чисел
    private ArrayList<Integer> sn; // список, собиращий простые числа
    Thread t; // поточный объект

    // конструктор объекта для поиска простых чисел в интеревале
    SimpleNums(String name, int numMin, int numMax) {
        sn = new ArrayList<>();
        this.numMin = numMin;
        this.numMax = numMax;
        t = new Thread(this, name);
        t.start();
    }

    // описание работы поисковика простых чисел
    @Override
    public void run() {
        for (int i=numMin; i<=numMax; i++) {
            if (isSimple(i)) sn.add(i);
        }
    }

    // выдача результатов поиска в массив
    public int [] getResult() {
        int [] s = new int[sn.size()];
        for (int i=0; i<sn.size(); i++)
            s[i] = sn.get(i);
        return s;
    }

    // тест числа на простоту
    private boolean isSimple(int num) {
        if (num == 2) return true;
        if (num%2 == 0) return false;
        for (int i=2; i<num; i++) {
            if (num%i == 0) return false;
        }
        return true;
    }
}
