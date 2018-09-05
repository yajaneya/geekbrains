package ru.geekbrains.java2.dz_2.dz5.StandartDZ;

public class MassUpd implements Runnable {
    private float[] arr; // массив для обработки
    private int startnum; // номер первого элемента обрабатываемой выборки в исходном массиве
    private int size; // размер обрабатываемой выборки массива
    private int np; // номер потока

    @Override
    public void run() {
        for (int i=0; i<size; i++) {
                arr[i]=(float)(arr[i]*Math.sin(0.2f+(i+startnum)/5)*Math.cos(0.2f+(i+startnum)/5)*Math.cos(0.4f+(i+startnum)/2));
        }
    }

    public MassUpd(float[] arr, int startnum, int size, int np) {
        this.arr = arr;
        this.startnum = startnum;
        this.size = size;
        this.np = np;
    }

    public float[] getArr() {
        return arr;
    }


}
