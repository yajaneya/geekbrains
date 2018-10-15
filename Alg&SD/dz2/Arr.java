package ru.geekbrains.Alg_SD.dz.dz2;

/*
*** Класс описывает тюнингованный массив ***

Поля класса
-----------
arr - int[] текущий массив
arrArhiv - int [] архив массива
size - int размер массива
sort - boolean атрибут сортировки массива (true - сортирован, false - несортирован)
sortArhiv - boolean атрибут сортировки массива в архиве (true - сортирован, false - несортирован)

Методы класса
-------------
boolean isSort() - получение атрибута сортировки текущего архива
boolean insert (int value) - добавление 1 елемента массива в конец (успех - true, массив заполнен - false)
boolean delVal (int value) - удаление первого попавшегося элемента по значению (успех - true, нет элемента с таким значением - false)
void delInd (int index) - удаление элемента по индексу
void delArr () - очистка массива
boolean searchOne (int value) - поиск  первого элемента по значению (успех - true, нет такого элемента - false)
int searchAll (int value) - поиск всех элементов по значению (возвращает количество найденных элементов, 0 - нет таких элементов)
int getElement (int index) - возвращает значение элемента с указанным индексом
void display () - выводит в консоль весь архив строками по 10 элементов
void display (int line) - выводит в консоль весь архив строками по указанному количеству (line) элементов
void toArhiv() - помещает текущий массив в архив
void fromArhiv() - восстанавливает из архива в текущий массив
int sumControl () - возвращает сумму всех элементов массива (используется дл контроля неизменности массива, например, до и после сортировки)

* СОРТИРОВКИ *
void sortBub() - Пузырьковая сортировка
void sortSel() - Сортировка выбором
void sortIns() - Сортировка вставкой

 */

public class Arr {
    private int[] arr; // Массив
    private int[] arrArhiv; // Архив масива
    private int size; // Текущий размер заполненного массива
    private boolean sort; // Показатель сортировки массива (истина - сортирован, ложь - не сортирован)
    private boolean sortArhiv; // Показатель сортировки массива в архиве

    public Arr(int size) { // Конструктор массива заданного размера 
        this.arr = new int [size]; // Создается массив предельного размера
        this.arrArhiv = new int[size]; // Создаем место для архива массива
        this.size = 0; // начальный размер - 0 элементов
        this.sort = false; // массив при заполнении не сортируется
    }

    public boolean isSort() {
        return sort;
    }

    public boolean insert (int value) { // Добавление элемента в массив
        if (size>=arr.length) return false; // Если архив полный, возвращиется ложь
        arr[size++] = value; // добавляется в конец, полсе чего размер массива увеличивается на 1
        return true; // При успешном добавлении возвращается истина
    }
    
    public boolean delVal (int value) { // Удаление из массива первого попавщегося элемента с заданным значением 
        int delNum; // переменная для индекса удаляемого элемента
        for (delNum = 0; delNum < size; delNum ++) { // в цикле ищем удаляемый элемент
            if (arr[delNum] == value) break; 
        }
        if (delNum == size) // если дошли до конца массива, но ничего не нашли 
            return false; // возвращаем ложь - удаление не удалось
        else { 
            delInd(delNum); // удаляем элемент с найденным индексом delNum
            return true; // возвращаем истину, так как удаление свершилось
        }
    }
    
    public void delInd (int index) {    // Удаление из массива элемента с заданным индексом
        for (int i=index; i<size; i++) { // путем сдвига влево следующих за ним элементов 
            arr[i] = arr[i+1];
        }
        size--; // размер массива уменьшается на 1
    }

    public  void delArr () {
        size = 0;
    }

    public boolean searchOne (int value) { // Поиск первого элемента с заданым значением
        for (int i:arr) {
            if (i == value) return true; // если найден искомый элемент - возвращается истина
        }
        return false; // если цикл завершен, а элемент не найден - возвращается ложь
    } 
    
    public int searchAll (int value) { // Поиск всех элементов с заданным значением
        int ch = 0; // Счетчик элементов
        for (int i:arr) {
            if (i == value) ch++;
        }
        return ch; // возвращаем количество элементов с заданным значением, если не найдено, то возвращается 0
    }

    public int getElement (int index) { // Получение значения элемента по индексу
        return arr[index];
    }

    public void display () { // Вывод массива в строки - по десять элементов в строке
        display(10);
    }

    public void display (int line) { // Вывод массива с заданным количеством элементов в строке
        System.out.println(((sort)?"Сортированный ":"Несортированный ")+"массив из " + size + " элементов:");
        for (int i=0; i<size; i++) {
            System.out.print(arr[i]+"\t");
            if (((i+1)%line)==0) System.out.println();
        }
        System.out.println();
    }

    public void toArhiv() {
        for (int i=0; i<size; i++) {
            arrArhiv[i] = arr[i];
        }
        sortArhiv = sort;
    }

    public void fromArhiv() {
        for (int i=0; i<size; i++) {
            arr[i] = arrArhiv[i];
        }
        sort = sortArhiv;
    }

    public int sumControl () { // Подсчет суммы элементов массива для контроля неизменности его
        int sum = 0;
        for (int i:arr) {
            sum+=i;
        }
        return sum;
    }

    /*     СОРТИРОВКИ     */

    public void sortBub() { // Пузырьковая сортировка
        for (int i=size-1; i>1; i--) { //Цикл от всех элементов до одного, двигаясь с конца к началу.
            for (int j=0; j<i; j++) { //Цикл с первого элемента до последнего несортированного
                if (arr[j]>arr[j+1]) changeElements(j,j+1); //перемещение бо'льших чисел в хвост
            }
        }
        sort = true;
    }

    public void sortSel() { //Сортировка методом выбора
        int marker; // создаем маркер
        for (int i=0; i<size; i++) { // Проходим по всем элементам с начала
            marker = i; // Маркируем первый из оставшихся элемент
            for (int j=i+1; j<size; j++) { // Просматриваем остальные элементы
                if (arr[marker]>arr[j]) //Если находим элемент меньше маркироанного,
                    marker=j;           //маркируем его
            }
            if (marker!=i)                  //если маркер ушел с первого элемента
                changeElements(marker, i);  //меняем содержимое первого элемента и маркированного
        }
        sort = true;
    }

    public void sortIns() {
        int temp, j;
        for (int i=1; i<size; i++) {
            temp = arr[i];
            for (j=i; j>0; j--) {
                if (arr[j-1]>=temp) {
                    arr[j]=arr[j-1];
                } else {
                     break;
                }
            }
            arr[j]=temp;
        }
        sort = true;
    }

    private void changeElements(int j, int i) { //Обмен содержимым между двумя элементами массива
        int temp;
        temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

}
