package ru.geekbrains.java1.dz_2.dz1;

public class Course {
    //массив со списком препятствий
    String[] lets = {"Забор с наклонной доской", "Разрушенная лестница", "Разрушенный мост", "Стенка с проломами", "Окоп", "Лабиринт"};
    int levelCourse; // уровень прохождения полосы препятствий, в процентах, которые надо набрать для зачета
                    // после преодоления всех препятствий

    //конструктор полосы препяттвий со средними требованиями
    public Course() {
        levelCourse = 50;
    }

    //конструктор полосы препятствий с заданным уровнем требований
    public Course(int levelCourse) {
        this.levelCourse = levelCourse;
    }

    // геттеры и сеттеры
    public String[] getLets() {
        return lets;
    }

    // прохождение полосы препятствий командой
    // результат преодоления препятствий получается путем перемножения уровня подготовки для определенного
    // препятствия (число в пределах от 0 до 100) и случайного числа (от 0 до 100), характеризующего текущую
    // попытку преодолеть препятствие. По умолчанию препятствие считается пройденным, если произведение более 50

    public void doIt(Team team) {

        Member[] members = team.getTeam();
        boolean[] dist = new boolean[members.length];
        int popytka;
        float rez, rez_obsh; // общий (накопительный) результат преодоления полосы препятствий

        System.out.println("Начинается прохождение полосы препятствий со уровнем сложности " + levelCourse + "...");
        System.out.println("----------");
        team.infoTeam();
        System.out.println();
        System.out.println("Выступает команда " + team.getName());
        System.out.println("------------------------------------");
        for (int j=0; j<members.length; j++) {
           rez = 0;
           System.out.println();
           for (int i=0; i<lets.length; i++) {
               popytka = (int) popytka(members[j], i);
               rez = rez + popytka;
               System.out.println(members[j].getName() + " прошел препятствие '" + lets[i] + "' с результатом: " + popytka + "%");
           }
           System.out.println("-------");
           rez_obsh = rez/lets.length;
           System.out.println(members[j].getName() + " выступил с общим результатом: " + rez_obsh + "%");
           if (rez_obsh > levelCourse) dist[j] = true;
           else dist[j]=false;
        }
        System.out.println();
        team.setDist(dist);
        team.showResults(); //вывод результатов
        System.out.println("------------");
        System.out.println();

    }

    //попытка пройти препятствие из полосы препятствий
    float popytka (Member member, int numLet) {
        float popytka; // случайный результат попытки преодоления препятствия
        int q; // уровень подготовки к препятствию

        popytka = (float)(Math.random());
        q = member.getLevelCourse()[numLet];
        return q*popytka;
    }
}
