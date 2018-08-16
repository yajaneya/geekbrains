package ru.geekbrains.java1.dz_2.dz1;

public class Team implements Trenirovka{
    private String name; // Название команды
    private Member [] team; // Команда
    private boolean[] dist; // Прохождение дистанции

    //конструктор
    public Team(String name, Member [] team) {
        this.name = name;
        this.team = team;
        dist = new boolean[team.length];
    }

    // сеттеры и геттеры

    public void setDist(boolean[] dist) {
        this.dist = dist;
    }

    public Member[] getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    // отображение результатов прохождения полосы препятствий командой
    public void showResults() {
        boolean distNon =false;
        for (int i=0; i<dist.length; i++) {
            distNon = distNon || dist[i];
        }

        if (!distNon) {
            System.out.println("Команда " + name + " не прошла полосу препятствий.");
            return;
        }

        System.out.println("Из команды '" + name + "' прошли полосу препятствий: ");
        for (int i=0; i<dist.length; i++) {
            if (dist[i]) System.out.println(team[i].getName());
        }
    }

    // информация о команде
    public void infoTeam(){
        System.out.println("Команда: " + name);
        for (Member t: team) {
            System.out.println("Имя: " + t.getName() + ". Уровень преодоления препятсвий: " + t.levelCourse());
        }
    }

    // проведение тренировки команды по всей полосе препятствий
    public void tren_polosa(){
        int popytka;

        Course c = new Course();
        String [] lets = c.getLets();
        for (int j=0; j<team.length; j++) {
            int[] levelCourse = team[j].getLevelCourse();
            System.out.println("Тренировка: " + team[j].getName());
            System.out.println("-------------");
            System.out.println("До тренировки:");
            team[j].infoLeveCourse();
            System.out.println("-------------");
            for (int i=0; i<lets.length; i++) {
                popytka = (int)(Math.random()*100);
                System.out.println("Прошел препятствие '" + lets[i] + "' с результатом: " + popytka + "%");
                if (levelCourse[i] < popytka)
                    levelCourse[i] += ((popytka-levelCourse[i])/10);
            }
            System.out.println("-------------");
            System.out.println("После тренировки:");
            team[j].infoLeveCourse();
            System.out.println("-------------");
            System.out.println();
            team[j].setLevelCourse(levelCourse);
        }

    }

    //    int tren_prepyatstvie (int prep); - на перспективу: реализация тренировки по одному препятствию

}
