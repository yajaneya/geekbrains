package ru.geekbrains.java1.dz_2.dz1;

public class Main {
    public static void main (String [] args) {
        Course c = new Course(); //создание полосы препятствий
        Course c20 = new Course(20); //создание полосы препятствий
        Course c40 = new Course(40); //создание полосы препятствий
        Course c70 = new Course(70); //создание полосы препятствий

        // Создание членов команды
        Member[] members = new Member[3];
        members[0] = new Member("Василий");
        int [] lev = {60, 40, 90, 33, 39, 45};
        members[1] = new Member("Дмитрий", lev);
        members[2] = new Member("Степан");

        Team team = new Team("Бравые ребята", members); //создание команды

        // прохождение полосы препятствий
        c.doIt(team);
        c20.doIt(team);
        c40.doIt(team);
        c70.doIt(team);

        // тренировка команды
        team.tren_polosa();

        // прохождение полосы препятствий
        c.doIt(team);

        //100 тренировок одного из членов команды
        for (int i=0; i<100; i++){
            members[0].tren_polosa();
        }

        // прохождение полосы препятствий
        c.doIt(team);
    }
}
