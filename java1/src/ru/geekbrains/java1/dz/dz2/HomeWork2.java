package ru.geekbrains.java1.dz.dz2;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {

        // пункт 1 ДЗ
        System.out.println("Пункт 1 ДЗ");
        int[] arr1 = {1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1};
        System.out.println("Изначальный массив: " + Arrays.toString(arr1));
        for (int i=0; i<arr1.length; i++) {
            if (arr1[i] == 0) arr1[i] = 1;
            else arr1[i] = 0;
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr1));
        System.out.println("");

        // пункт 2 ДЗ
        System.out.println("Пункт 2 ДЗ");
        int[] arr2 = new int[8];
        for (int i=0; i<arr2.length; i++) {
            arr2[i] = i * 3;
        }
        System.out.println("Заполненный массив: " + Arrays.toString(arr2));
        System.out.println("");

        // пункт 3 ДЗ
        System.out.println("Пункт 3 ДЗ");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Изначальный массив: " + Arrays.toString(arr3));
        for (int i=0; i<arr3.length; i++) {
            if (arr3[i] < 6) arr3[i] = arr3[i] * 2;
        }
        System.out.println("Измененный массив: " + Arrays.toString(arr3));
        System.out.println("");

        // пункт 4 ДЗ
        System.out.println("Пункт 4 ДЗ");
        int[][] arr4 = new int[3][3];
        System.out.println("Изначальный массив:");
        VyvIntDoubleMassiv(arr4);
        for (int i=0; i<arr4.length; i++) {
            arr4[i][i] = 1;
        }
        System.out.println("Измененный массив:");
        VyvIntDoubleMassiv(arr4);
        System.out.println("");

        // пункт 5 ДЗ
        System.out.println("Пункт 5 ДЗ");
        int[] arr5 = {1, 5, 3, 2, 11, 4, 5, 0, 4, 28, 9, -1};
        System.out.println("Массив:" + Arrays.toString(arr5));
        System.out.println("Минимальный элемент массива: " + MinElMassiv(arr5));
        System.out.println("Максимальный элемент массива: " + MaxElMassiv(arr5));
        System.out.println("");

        // пункт 6 ДЗ
        System.out.println("Пункт 6 ДЗ");
        int[] arr6 = {1, 5, 3, 2, 11, 4, 5, 0, 4, 28, 9, -1};
        System.out.println("Массив: " + Arrays.toString(arr6));
        System.out.println("Сумма левой и правой части массива равны: " + СheckBalance(arr6));
        int[] arr7 = {1,1,1,2,1};
        System.out.println("---------------------");
        System.out.println("Массив: " + Arrays.toString(arr7));
        System.out.println("Сумма левой и правой части массива равны: " + СheckBalance(arr7));
        int[] arr8 = {1,1,1,2,1,0,2,4};
        System.out.println("---------------------");
        System.out.println("Массив: " + Arrays.toString(arr8));
        System.out.println("Сумма левой и правой части массива равны: " + СheckBalance(arr8));
        int[] arr9 = {12,1,1,2,1,0,2,4,-1,4};
        System.out.println("---------------------");
        System.out.println("Массив: " + Arrays.toString(arr9));
        System.out.println("Сумма левой и правой части массива равны: " + СheckBalance(arr9));
        System.out.println("");

        // пункт 7 ДЗ
        System.out.println("Пункт 7 ДЗ");
        int[] arr10 = {1, 5, 3, 2, 11, 4, 5, 0, 4, 28};
        System.out.println("Массив: " + Arrays.toString(arr10));
        Parovoz(arr10,1);
        System.out.println("Смещение элементов массива на 1: " + Arrays.toString(arr10));
        System.out.println("");
        Parovoz(arr10,5);
        System.out.println("Смещение элементов массива ещё на 5: " + Arrays.toString(arr10));
        System.out.println("");
        Parovoz(arr10,-6);
        System.out.println("Смещение элементов массива на -6 (возврат к изначальному): " + Arrays.toString(arr10));
        System.out.println("");


    }

    public static void VyvIntDoubleMassiv (int[][] arr) {
        for (int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    public static int MinElMassiv (int [] arr) {
        int min = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (min > arr[i]) min = arr[i];
        }
        return min;
    }

    public static int MaxElMassiv (int [] arr) {
        int max = arr[0];
        for (int i=1; i<arr.length; i++) {
            if (max < arr[i]) max = arr[i];
        }
        return max;
    }

    public static boolean СheckBalance (int [] arr) {
        int sum1, sum2;
        for (int i=0; i<arr.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j=0; j<=i; j++) {
                sum1 = sum1 + arr [j];
            }
            for (int j=i+1; j<arr.length; j++) {
                sum2 = sum2 + arr [j];
            }
            if (sum1 == sum2) {
                String ms = new String();
                ms = "[";
                for (int j=0; j<arr.length; j++) {
                    ms = ms + arr[j];
                    if (j != arr.length-1) ms = ms + ", ";
                    if (j == i) ms = ms + "|| ";
                }
                ms = ms + "]";
                System.out.println("Разделение массива:" + ms);
                return true;
            }
        }
        return false;
    }

    public static void Parovoz (int [] arr, int n) {
        int tmp;
        if (n>=0) {
            for (int i=1; i<=n; i++) {
                tmp = arr[arr.length-1];
                for (int j=arr.length-1; j>0; j--) {
                    arr[j]=arr[j-1];
                }
                arr[0] = tmp;
            }
        } else {
            n=-n;
            for (int i=1; i<=n; i++) {
                tmp = arr[0];
                for (int j=1; j<arr.length; j++) {
                    arr[j-1]=arr[j];
                }
                arr[arr.length-1] = tmp;
            }
        }
    }

}
