package ru.geekbrains.Alg_SD.dz.dz8;

import java.util.ArrayList;

public class HashTable {

    private ArrayList <Item> [] hashArr;
    private int size;

    public HashTable(int size) {
        this.hashArr = new ArrayList[size];
        this.size = size;
    }

    public void insert (Item item) {
        int key = hashFunc(item.hashCode());
        if (hashArr[key] == null)
            hashArr[key] = new ArrayList<>();
        hashArr[key].add(item);
    }

    public Item remove (Item item) {
        int key = hashFunc(item.hashCode());
        int index = hashArr[key].indexOf(item);
        return (index == -1) ? null : hashArr[key].remove(index);
    }

    public Item find (int data) {
        Item item = new Item(data);
        int key = hashFunc(item.hashCode());
        int index = hashArr[key].indexOf(item);
        return (index == -1) ? null : hashArr[key].get(index);
    }

    public void display() {
        for (int l=0; l<size; l++) {
            if (hashArr[l]!=null) {
                if (hashArr[l].size() == 0)
                    System.out.println("---");
                else  {
                    for (int i=0; i<hashArr[l].size(); i++) {
                        System.out.print(hashArr[l].get(i).toString());
                        if (i!=hashArr[l].size()-1)
                            System.out.print(" -> ");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("---");
            }
        }
        System.out.println();
    }

    private int hashFunc(int i) {
        return i % size;
    }
}
