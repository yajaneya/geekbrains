package ru.geekbrains.java1.dz_2.dz2;

// Тест-класс
public class MainClass {
    public static void main (String[] args) {

        // создание правильного массива с правильным содержимым
        System.out.println("Тест 1 - Всё ОК!");
        String[][] str = new String [4][4];
        zapolnenieInt(str);
        lovetz(str);

        // создание правильного массива с одним неправильным элементом
        System.out.println("Тест 2 - Червоточинка, однако!");
        zapolnenieIntStr(str);
        lovetz(str);

        // создание массива с одним неправильным индексом
        System.out.println("Тест 3 - Высоковато...!");
        str = new String [5][4];
        zapolnenieInt(str);
        lovetz(str);

        // создание массива с другим неправильным индексом
        System.out.println("Тест 4 - Широковато...!");
        str = new String [4][5];
        zapolnenieInt(str);
        lovetz(str);

        // создание массива с двумя неправильными индексами и элементом с ошибочными данными
        System.out.println("Тест 5 - Ух ты! И высоко и широко...! И что-то левое закралось...");
        str = new String [9][9];
        zapolnenieIntStr(str);
        lovetz(str);

        // создание массива с двумя меньшими индексами
        System.out.println("Тест 6 - Узко и низко, однако!");
        str = new String [1][0];
        lovetz(str);

    }

    // ключевой метод, проверяющий массив на соответствие размерам, проверяющий целочисленность элементов,
    // и после прохождения массивом через все придирки, вычисляющий сумму его элементов,
    // ну и ыводящий эту сумму в консоль...
    public static void massiv (String [][] mas) {

        int sum = 0;

        // тут мы проверяем соразмерность массива, и при несоразмерности, вычисляем, где проседание,
        // формируем информацию о просчетах, создаем и обучаем фразам "пёсика"
        if (!((mas.length==4)&(mas[0].length==4))){
            String addMessage = "";
            if (mas.length!=4) addMessage +=  "Количество строк " + mas.length+1 + " вместо 4. ";
            if (mas[0].length!=4) addMessage +=  "Количество солбцов " + mas[0].length+1 + " вместо 4. ";
            throw new MyArraySizeException("Некорректный размер массива. " + addMessage);
        }

        // тут мы проверяем элементы массива на наличие нелегальных элементов,
        // формируем информацию о находке, создаем и обучаем нужной фразе "пёсика",
        // параллельно, на всякий случай - вдруг повезёт, вычисляем сумму элементов массива,
        // и, если повезет, выводим её прямо в консоль
        for (int i = 0; i<mas.length; i++) {
            for (int j = 0; j<mas[i].length; j++) {
                try {
                    sum += Integer.parseInt(mas[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("В ячейке [" + i + "][" + j + "] неверные данные!" );
                }
            }
        }

        System.out.println("Сумма массива: " + sum);
    }

    // метод, занимающийся ловлей ошибок
    public static void lovetz (String[][] str) {
        try {
            massiv(str);
        } catch (MyArraySizeException| MyArrayDataException e ) {
            System.out.println("Отловили таки!!!");
        } finally {
            System.out.println("Ну вот и всё!");
            System.out.println("--------------");
            System.out.println();
        }
    }

    // прилежный метод, аккуратно заполняющий массив нужным содержимым
    public static void zapolnenieInt (String[][] str) {
        int r;
        for (int i = 0; i<str.length; i++) {
            for (int j = 0; j<str[i].length; j++) {
                r = (int)(Math.random()*100);
                str[i][j] = String.valueOf(r);
            }
        }
    }

    // подловатый метод, заполняющий массив вполне приличными данными,
    // но, из под тишка подкидывающий свинку в массив
    public static void zapolnenieIntStr (String[][] str) {
        zapolnenieInt(str);
        int i = (int)(Math.random()*4);
        int j = (int)(Math.random()*4);
        str[i][j] = "w";
    }
}
