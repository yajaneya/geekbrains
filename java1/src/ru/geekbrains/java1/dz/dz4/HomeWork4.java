package ru.geekbrains.java1.dz.dz4;

import java.util.Random;
import java.util.Scanner;

public class HomeWork4 {

    public static char[][] map;
    public static char[][] oldfield;
    public static final int SIZE = 4;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    public static boolean route = true;

    public static void main(String[] args) {
        initMap();

        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        oldfield = new char[SIZE][SIZE];
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                map[i][j] = DOT_EMPTY;
                oldfield[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i=0; i<=SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i=0; i<SIZE; i++) {
            System.out.print((i+1)+" ");
            for (int j=0; j<SIZE; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты ");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x,y));
        map[x][y] = DOT_X;
    }

    public static void aiTurn() {
        int x, y, sx, sy;
        x = 0;
        y = 0;
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if ((map[i][j] == DOT_X) && (map[i][j] != oldfield[i][j])) {
                    sx = i; // запоминаем координаты последнего хода
                    sy = j; // запоминаем координаты последнего хода
                    // осматриваемся вокруг этой клетки и запоминаем координаты пустой
                    // интеллект не доработанный, так как полностью не отслеживает длинных последовательностей
                    // особенно, по диагонали
                    // (к сожалению, не хватило времени состряпать более полный алгоритм)
                    if (route) {
                        if (isCellValid(sx+1, sy)) {
                            x=sx+1;
                            y=sy;
                        } else if (isCellValid(sx+1, sy+1)) {
                            x=sx+1;
                            y=sy+1;
                        } else if (isCellValid(sx, sy+1)) {
                            x=sx;
                            y=sy+1;
                        } else if (isCellValid(sx-1, sy+1)) {
                            x=sx-1;
                            y=sy+1;
                        } else if (isCellValid(sx-1, sy)) {
                            x=sx-1;
                            y=sy;
                        } else if (isCellValid(sx-1, sy-1)) {
                            x=sx-1;
                            y=sy-1;
                        } else if (isCellValid(sx, sy-1)) {
                            x=sx;
                            y=sy-1;
                        } else if (isCellValid(sx+1, sy-1)) {
                            x = sx + 1;
                            y = sy - 1;
                        } else {
                            // если все клетки вокруг заняты - выбираем случайную клетку
                            do {
                                x = rand.nextInt(SIZE);
                                y = rand.nextInt(SIZE);
                            } while (!isCellValid(x,y));
                        }
                    } else {
                        if (isCellValid(sx, sy + 1)) {
                            x = sx;
                            y = sy + 1;
                        } else if (isCellValid(sx + 1, sy + 1)) {
                            x = sx + 1;
                            y = sy + 1;
                        } else if (isCellValid(sx + 1, sy)) {
                            x = sx + 1;
                            y = sy;
                        } else if (isCellValid(sx + 1, sy - 1)) {
                            x = sx + 1;
                            y = sy - 1;
                        } else if (isCellValid(sx, sy - 1)) {
                            x = sx;
                            y = sy - 1;
                        } else if (isCellValid(sx - 1, sy - 1)) {
                            x = sx - 1;
                            y = sy - 1;
                        } else if (isCellValid(sx - 1, sy)) {
                            x = sx - 1;
                            y = sy;
                        } else if (isCellValid(sx - 1, sy + 1)) {
                            x = sx - 1;
                            y = sy + 1;
                        } else {
                            // если все клетки вокруг заняты - выбираем случайную клетку
                            do {
                                x = rand.nextInt(SIZE);
                                y = rand.nextInt(SIZE);
                            } while (!isCellValid(x, y));
                        }
                    }
                    route=!route;
                }
            }
        }
        map[x][y] = DOT_O;
        // запоминаем текущее сосотояние поля
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                oldfield[i][j] = map[i][j];
            }
        }
    }

    public static boolean isCellValid(int x, int y) {
        if (x<0||x>=SIZE||y<0||y>=SIZE) return false;
        if (map[x][y]==DOT_EMPTY) return true;
        return false;
    }

    public static boolean isMapFull() {
        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }


    public static boolean checkWin(char sumb) {
        int count;

        for (int i=0; i<SIZE; i++) {
            for (int j=0; j<SIZE; j++) {
                if (map[i][j] == sumb) {

                    // проверка по вертикали
                    count = 1;
                    for (int k=i+1; k<SIZE; k++) {
                        if ((map[k][j] == sumb) & (map[k-1][j] == sumb)) count +=1;
                    }
                    if (count >= DOTS_TO_WIN) return true;

                    // проверка по горизонтали
                    count = 1;
                    for (int k=j+1; k<SIZE; k++) {
                        if ((map[i][k] == sumb) & (map[i][k-1] == sumb)) count +=1;
                    }
                    if (count >= DOTS_TO_WIN) return true;

                    // проверка по диагонали вперед
                    count = 1;
                    for (int k=1; (i+k<SIZE)&(j+k<SIZE); k++) {
                        if ((map[i+k][j+k] == sumb) & (map[i+k-1][j+k-1] == sumb)) count +=1;
                    }
                    if (count >= DOTS_TO_WIN) return true;

                    // проверка по диагонали назад
                    count = 1;
                    for (int k=1; (i+k<SIZE)&(j-k>0); k++) {
                        if ((map[i+k][j-k] == sumb) & (map[i+k-1][j-k+1] == sumb)) count +=1;
                    }
                    if (count >= DOTS_TO_WIN) return true;

                }
            }
        }
        return false;
    }


    public static int MaxElMassiv (int [] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }
}
