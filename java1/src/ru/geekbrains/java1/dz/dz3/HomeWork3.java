package ru.geekbrains.java1.dz.dz3;

import java.util.Random;
import java.util.Scanner;

public class HomeWork3 {

    public static void main (String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String outcompareword;
        String part = "";
        Boolean key;
        int lengthword;

        do {
            int i = random.nextInt (25);

            while (true) {
                System.out.println("Введите слово:");
                String word = scanner.nextLine();
                System.out.println(word);

                if (word.equals(words[i])) {
                    System.out.printf("Вы правильно угадали слово: %s", words[i]);
                    break;
                } else {
                    outcompareword = "";
                    key = false;
                    if (words[i].length()<word.length()) lengthword = words[i].length();
                    else lengthword = word.length();

                    for (int k=0; k<lengthword; k++) {
                        if (words[i].charAt(k) == word.charAt(k)) {
                            outcompareword = outcompareword + words[i].charAt(k);
                            key = true;
                        } else {
                            outcompareword = outcompareword + "#";
                        }
                    }
                    for (int k = lengthword-1; k<=15; k++) {
                        outcompareword = outcompareword + "#";
                    }
                    if (!key) System.out.printf("Вы не угадали слово");
                    else System.out.printf("Вы угадали некоторые буквы в слове: %s", outcompareword);
                }
                System.out.println("");
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("Может ещё партеечку? (1 - да, любое другое - нет)");
            part = scanner.nextLine();
            System.out.println("");

        } while (part.equals("1"));
    }
}
