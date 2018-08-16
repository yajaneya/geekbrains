package ru.geekbrains.java1.dz_2.dz1;

public class Member implements Trenirovka{

    private String name; //имя члена команды
    private int[] levelCourse; // уровень подготовки для преодоления каждого из шести препятствий (в процентах)

    // конструктор, создающий среднестатистического члена команды с уровнем подготовки 75%
    public Member(String name) {
        this.name = name;
        levelCourse = new int[6];
        for (int i=0; i<levelCourse.length; i++) {
            levelCourse[i] = 75;
        }
    }

    // конструктор, создающий члена команды с указанием уровня подготовки
    public Member(String name, int[] levelCourse) {
        this.name = name;
        for (int l: levelCourse){
            if (l<0) l=0;
            if (l>100) l=100;
        }
        this.levelCourse = levelCourse;
    }

    // геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int[] getLevelCourse() {
        return levelCourse;
    }

    public void setLevelCourse(int[] levelCourse) {
        this.levelCourse = levelCourse;
    }

    // вывод информации об уровнях подготовки в консоль
    public void infoLeveCourse() {
        String lc = "Уровни подготовки к преодолению препятствий: ";
        for (int i=0; i<levelCourse.length; i++) {
            lc += (i+1) + " - " + levelCourse[i] + "; ";
        }
        lc += ".";
        System.out.println(lc);
    }

    // подсчет среднего уровня подготовки по всем препятствиям
    public int levelCourse() {
        int sum = 0;
        for (int l: levelCourse) {
            sum = sum + l;
        }
        return sum/levelCourse.length;
    }

    // Тренировки члена команды по всей полосе препятствий
    public void tren_polosa(){
        int popytka;

        Course c = new Course();
        String [] lets = c.getLets();
        System.out.println("Тренировка: " + name);
        System.out.println("-------------");
        System.out.println("До тренировки:");
        infoLeveCourse();
        System.out.println("-------------");
        for (int i=0; i<lets.length; i++) {
            popytka = (int)(Math.random()*100);
            System.out.println(this.getName() + " прошел препятствие '" + lets[i] + "' с результатом: " + popytka + "%");
            if (levelCourse[i] < popytka)
                levelCourse[i] += ((popytka-levelCourse[i])/10);
        }
        System.out.println("-------------");
        System.out.println("После тренировки:");
        infoLeveCourse();
        System.out.println("-------------");
        System.out.println();


    }

//    int tren_prepyatstvie (int prep); - на перспективу: реализация тренировки по одному препятствию

}
