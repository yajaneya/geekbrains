package ru.geekbrains.Alg_SD.dz.dz3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /* Тест стека */
//        /*
        System.out.println("**************************");
        System.out.println("*** Тестирование стека ***");
        System.out.println("**************************");
        System.out.println("Создадим стек на 3 элемента.");
        Stack st = new Stack(3);
        System.out.println("Поместим 5, 15, 23, 0, 1000.");
        st.insert(5);
        st.insert(15);
        st.insert(23);
        st.insert(0);
        st.insert(1000);
        st.display();
        System.out.println("Возьмем один элемент.");
        st.remove();
        st.display();
        System.out.println("Возьмем один элемент.");
        st.remove();
        st.display();
        System.out.println("Возьмем один элемент.");
        st.remove();
        st.display();
        System.out.println("Возьмем один элемент.");
        st.remove();
        st.display();
        System.out.println("Возьмем один элемент.");
        st.remove();
        System.out.println();
//        */


        /* Тест очереди */
//        /*
        System.out.println("*****************************");
        System.out.println("*** Тестирование очереди ***");
        System.out.println("*****************************");
        System.out.println("Создадим очередь на 5 элементов.");
        Queue q = new Queue(5);
        System.out.println("Добавим 12, 13, 14.");
        q.insert(12);
        q.insert(13);
        q.insert(14);
        q.display();
        System.out.println("Добавим 15, 16.");
        q.insert(15);
        q.insert(16);
        q.display();
        System.out.println("Удалим три элемента");
        q.remove();
        q.remove();
        q.remove();
        q.display();
        System.out.println("Добавим 17, 18, 19, 20.");
        q.insert(17);
        q.insert(18);
        q.insert(19);
        q.insert(20);
        q.display();
        System.out.println("Удалим три элемента. Добавим 3.");
        q.remove();
        q.remove();
        q.remove();
        q.insert(3);
        q.display();
        System.out.println();
//        */

        /* Тест дека */
//        /*
        System.out.println("*************************");
        System.out.println("*** Тестирование дека ***");
        System.out.println("*************************");
        System.out.println("Создадим очередь на 6 элементов.");
        Deque dq = new Deque(6);
        System.out.println("Добавим слева элементы 2 и 3.");
        dq.insert(2);
        dq.insert(3);
        dq.display();
        System.out.println("Добавим справа элементы 1, 0, -1, -7, -6.");
        dq.left=false;
        dq.insert(1);
        dq.insert(0);
        dq.insert(-1);
        dq.insert(-7);
        dq.insert(-6);
        dq.display();
        System.out.println("Удалим элемент справа.");
        dq.remove();
        dq.display();
        System.out.println("Добавим -2 справа. Удалим элемент слева.");
        dq.insert(-2);
        dq.left=true;
        dq.remove();
        dq.display();
        System.out.println();
//        */

        /* Тест приоритетной очереди */
//        /*
        System.out.println("*****************************************");
        System.out.println("*** Тестирование приоритетной очереди ***");
        System.out.println("*****************************************");
        System.out.println("Создадим очередь на 5 элементов.");
        PriorityQueue pq = new PriorityQueue(5);
        System.out.println("Поместим 2, 3.");
        pq.insert(2);
        pq.insert(3);
        pq.display();
        System.out.println("Поместим 1, 0, -1, -1, -5.");
        pq.insert(1);
        pq.insert(0);
        pq.insert(-1);
        pq.insert(-1);
        pq.insert(-5);
        pq.display();
        System.out.println("Удалим один элемент.");
        pq.remove();
        pq.display();
        System.out.println("Поместим -2.");
        pq.insert(-2);
        pq.display();
        System.out.println("Удалим один элемент.");
        pq.remove();
        pq.display();
        System.out.println();
//        */

        /* Тест переворота строк */
//        /*
        System.out.println("**************************************");
        System.out.println("*** Тестирование переворота строки ***");
        System.out.println("**************************************");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите слово (Enter - выход): ");
            String input = scanner.nextLine();
            if (input.equals("")) break;
            Perevorot per = new Perevorot(input);
            System.out.println("Перевертыш:   " + per.go());

        }
//        */

    }
}
