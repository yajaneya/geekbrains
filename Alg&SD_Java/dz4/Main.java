package ru.geekbrains.Alg_SD.dz.dz4;

/*
Нынче без описаний и полных комментариев.
 */

import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {

        testLinkedList();
        testTwoSideLinkedList();
        testStack();
        testQueue();
        testLinkIterator();

    }

    private static void testLinkedList() {
        System.out.println("**************************************");
        System.out.println("*** Тестирование Cвязанного списка ***");
        System.out.println("**************************************");
        LinkedList <Integer> list = new LinkedList<>();
        list.display();
        list.insert(12);
        list.display();
        list.insert(25);
        list.display();
        list.insert(234);
        list.insert(21);
        System.out.println("Foreach");
        /*
        // С этой частью задания я так и не справился, - foreach не работает.
        for ( Integer l: list) {
            System.out.println(l);
        }
         */
        list.display();
        list.remove();
        list.display();
        list.display();
        System.out.println(list.remove().getLink() +  " размер: " + list.size);
        System.out.println(list.remove().getLink() +  " размер: " + list.size);
        System.out.println(list.remove().getLink() +  " размер: " + list.size);
        System.out.println(list.remove());
        list.display();
        System.out.println();
    }

    private static void testTwoSideLinkedList() {
        System.out.println("****************************************************");
        System.out.println("*** Тестирование Двустороннего связанного списка ***");
        System.out.println("****************************************************");
        TwoSideLinkedList <Integer> list = new TwoSideLinkedList<Integer>();
        list.display();
        list.insert(12);
        list.display();
        list.insert(25);
        list.display();
        list.insert(234);
        list.insert(21);
        list.display();
        list.remove();
        list.display();
        list.insertLast(1234);
        list.display();
        System.out.println(list.removeLast().getLink() +  " размер: " + list.size);
        System.out.println(list.remove().getLink() +  " размер: " + list.size);
        System.out.println(list.removeLast().getLink() +  " размер: " + list.size);
        System.out.println(list.removeLast().getLink() +  " размер: " + list.size);
        System.out.println(list.remove());
        System.out.println(list.removeLast());
        list.display();
        System.out.println();
    }

    private static void testStack() {
        System.out.println("**************************");
        System.out.println("*** Тестирование Стека ***");
        System.out.println("**************************");
        Stack st = new Stack();
        System.out.println("Ложим в стек: 23, 25, 31, 2");
        st.push(23);
        st.push(25);
        st.push(31);
        st.push(2);
        st.display();
        System.out.println("Берем со стека: " + st.pop());
        st.display();
        System.out.println("Берем со стека: " + st.pop());
        st.display();
        System.out.println("Берем со стека: " + st.pop());
        st.display();
        System.out.println("Берем со стека: " + st.pop());
        st.display();
        System.out.println();
    }

    private static void testQueue() {
        System.out.println("****************************");
        System.out.println("*** Тестирование Очереди ***");
        System.out.println("****************************");
        Queue qu = new Queue();
        System.out.println("Добавляем 23, 25, 31, 2");
        qu.insert(23);
        qu.insert(25);
        qu.insert(31);
        qu.insert(2);
        qu.display();
        System.out.println("Удаляем: " + qu.remove());
        qu.display();
        System.out.println("Удаляем: " + qu.remove());
        qu.display();
        System.out.println("Удаляем: " + qu.remove());
        qu.display();
        System.out.println("Удаляем: " + qu.remove());
        qu.display();
        System.out.println();
    }

    private static void testLinkIterator() {
        System.out.println("**************************************");
        System.out.println("*** Тестирование Итератора Cвязанного списка ***");
        System.out.println("**************************************");
        LinkedList <Integer> list = new LinkedList();
        list.display();
        list.insert(12);
        list.display();
        list.insert(25);
        list.display();
        list.insert(234);
        list.insert(21);
        list.display();
        System.out.println("----------------------------");
        System.out.println("Вывод списка через foreach:");
        for (Integer i : list) {
            System.out.println(i);
        }
        System.out.println("----------------------------");
        LinkIterator iterator = (LinkIterator) list.iterator();
        iterator.reset();
        System.out.println("При сбросе итератора: " + iterator.getCurrent().getLink());
        iterator.nextLink();
        iterator.nextLink();
        System.out.println("После двух перемещений итератора: " + iterator.getCurrent().getLink());
        list.display();
        iterator.insertBefore(new Link(24));
        iterator.nextLink();
        iterator.insertAfter(new Link(26));
        System.out.println("Вставили 24 до и 26 после текущей позиции итератора.");
        list.display();
        System.out.println();
    }

}
