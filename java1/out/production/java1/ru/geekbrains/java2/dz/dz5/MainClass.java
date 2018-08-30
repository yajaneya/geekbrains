package ru.geekbrains.java2.dz_2.dz5;

public class MainClass {
    static final int size = 10000000;
    static final int h = size/2;
    static float[] arr = new float[size];



    public static void main (String[] args) {
        linmass();
//        System.out.println("Массив после обычного метода:");
//        for (int i=0; i<size; i++) {
//            System.out.print(arr[i]+", ");
//        }
//        System.out.println();
//        System.out.println();

        doublemass();
//        for (int i=0; i<size; i++) {
//            System.out.print(arr[i]+", ");
//        }
    }

    public static void linmass () {
        for (int i=0; i<arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i=0; i<arr.length; i++) {
            arr[i]=(float)(arr[i]*Math.sin(0.2f+i/5)*Math.cos(0.2f+i/5)*Math.cos(0.4f+i/2));
        }
        System.out.print("Время обычного метода: ");
        System.out.println(System.currentTimeMillis()-a);
        System.out.println();
    }

    public static void doublemass () {
        for (int i=0; i<arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();

        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);
        MassUpd mu1 = new MassUpd();
        MassUpd mu2 = new MassUpd();
        mu1.setArr(a1);
        mu1.setSize(h);
        mu1.setNp(1);
        mu1.setStartnum(0);
        mu2.setArr(a2);
        mu2.setSize(h);
        mu2.setNp(2);
        mu2.setStartnum(h);
//        System.out.println("Массив 1го потока до двупоточного метода:");
//        for (int i=0; i<h; i++) {
//            System.out.print(a1[i]+", ");
//        }
//        System.out.println();
//        System.out.println("Массив 2го потока до двупоточного метода:");
//        for (int i=0; i<h; i++) {
//            System.out.print(a2[i]+", ");
//        }
//        System.out.println();
//        System.out.println();

        new Thread(mu1).start();
        new Thread(mu2).start();
        a1=mu1.getArr();
        a2=mu2.getArr();

//        System.out.println("Массив 1го потока после двупоточного метода:");
//        for (int i=0; i<h; i++) {
//            System.out.print(a1[i]+", ");
//        }
//        System.out.println();
//        System.out.println("Массив 2го потока после двупоточного метода:");
//        for (int i=0; i<h; i++) {
//            System.out.print(a2[i]+", ");
//        }
//        System.out.println();
//        System.out.println();

        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.print("Время двупоточного метода: ");
        System.out.println(System.currentTimeMillis()-a);
    }

}
