package ru.geekbrains.java1.dz.dz5;

public class Person {
    private String fio;
    private String dolzhnost;
    private String email;
    private String telefon;
    private long cash;
    private int age;

    public Person (String fio, String dolzhnost, String email, String telefon, long cash, int age) {
        this.fio = fio;
        this.dolzhnost = dolzhnost;
        this.email = email;
        this.telefon = telefon;
        this.cash = cash;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + fio + ", Возраст: " + age + ", Должность: " + dolzhnost + ", email: " + email + ", тел.: " + telefon + ", Зарплата: " + cash);
    }
}
