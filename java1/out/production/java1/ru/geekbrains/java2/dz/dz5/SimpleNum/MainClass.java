package ru.geekbrains.java2.dz_2.dz5.SimpleNum;

import java.util.Scanner;

public class MainClass {

    public static void main (String[] args) {
        int min; // начало интервала поиска простых чисел
        int max; // конец интервала поиска простых чисел

        // ввод интервала поиска
        Scanner scan = new Scanner(System.in);
        System.out.println("Вас приветствует Поисковик простых чисел!!!");
        System.out.println();
        System.out.println("Введите начало интервала поиска (целое число): ");
        min = scan.nextInt();
        System.out.println("Введите конец интервала поиска (целое число): ");
        max = scan.nextInt();

        // создание и запуск четырех потоков поиска простых чисел
        SimpleNums sn1 = new SimpleNums("1й", min, (max-min)/4);
        SimpleNums sn2 = new SimpleNums("1й", (max-min)/4+1, (max-min)/2);
        SimpleNums sn3 = new SimpleNums("1й", (max-min)/2+1, 3*(max-min)/4);
        SimpleNums sn4 = new SimpleNums("1й", 3*(max-min)/4+1, max);

        // ожидание завершения работы в потоках
        try {
            sn1.t.join();
            sn2.t.join();
            sn3.t.join();
            sn4.t.join();
        } catch (InterruptedException e) {
            System.out.println("Поток прерван");
        }

        // получение результатов работы потоков (вытягиваем простые числа из каждого)
        int [] s1 = sn1.getResult();
        int [] s2 = sn2.getResult();
        int [] s3 = sn3.getResult();
        int [] s4 = sn4.getResult();

        // склеиваем в один массив все простые числа
        int [] s = new int[s1.length+s2.length+s3.length+s4.length];

        System.arraycopy(s1,0,s,0,s1.length);
        System.arraycopy(s2,0,s,s1.length,s2.length);
        System.arraycopy(s3,0,s,s1.length+s2.length,s3.length);
        System.arraycopy(s4,0,s,s1.length+s2.length+s3.length,s4.length);

        // выводим результат в консоль
        System.out.println();
        System.out.println("Ловите результат:");
        for(int i=0;i<s.length;i++) {
            System.out.print(s[i]+" ");
            if ((i+1)%10 == 0) System.out.println();
        }
    }
}
