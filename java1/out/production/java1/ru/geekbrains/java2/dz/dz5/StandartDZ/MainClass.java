package ru.geekbrains.java2.dz_2.dz5.StandartDZ;

public class MainClass {
    static final int size = 10000000; // размер массива
    static final int h = size/2; // размер массива для каждого потока
    static float[] arr = new float[size]; // исходный массив

    public static void main (String[] args) throws InterruptedException {

        linmass(); // запуск обычного метода
        doublemass(); // запуск двупоточного метода

        System.out.println("Конец!");
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

    public static void doublemass () throws InterruptedException {
        for (int i=0; i<arr.length; i++) {
            arr[i]=1;
        }

        // разбивка исходного массива
        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        //создание объектов для обработки массивов и инициализация полей
        MassUpd mu1 = new MassUpd(a1, 0, h, 1);
        MassUpd mu2 = new MassUpd(a2, h, h, 2);

        // создание и запуск двух потоков
        Thread t1 = new Thread(mu1);
        Thread t2 = new Thread(mu2);
        t1.start();
        t2.start();

        // ожидание заверщения работы потоков
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }

        // получение массивов из завершенных потоков
        a1=mu1.getArr();
        a2=mu2.getArr();

        // склейка массивов в исходный массив
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.print("Время двупоточного метода: ");
        System.out.println(System.currentTimeMillis()-a);
        System.out.println();
    }
}
