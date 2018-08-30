package ru.geekbrains.java2.dz_2.dz5;

public class MassUpd implements Runnable {
    private float[] arr;
    private int startnum;
    private int size;
    private int np;

    @Override
    public void run() {
        for (int i=0; i<size; i++) {
            try {
                arr[i]=(float)(arr[i]*Math.sin(0.2f+(i+startnum)/5)*Math.cos(0.2f+(i+startnum)/5)*Math.cos(0.4f+(i+startnum)/2));
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("Массив в потоке: " + np);
//        for (int i=0; i<size; i++) {
//            System.out.print(arr[i]+", ");
//        }
//        System.out.println();
//        System.out.println();
    }

    public void setArr(float[] arr) {
        this.arr = arr;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setNp(int np) {
        this.np = np;
    }

    public void setStartnum(int startnum) {
        this.startnum = startnum;
    }

    public float[] getArr() {
//        System.out.println("Массив в геттере потока " + np + " перед возвратом.");
//        for (int i=0; i<size; i++) {
//            System.out.print(arr[i]+", ");
//        }
//        System.out.println();
//        System.out.println();
        return arr;
    }
}
