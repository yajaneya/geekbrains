package ru.geekbrains.java2.dz_2.dz4.var2;

import java.util.*;

public class TelefonSprav {
    private HashMap<String, String> telsprav; // наш справочник

    //конструктор пустого справочника
    public TelefonSprav() {
        telsprav = new HashMap<>();
    }

    //конструктор справочника с его заполнением
    public TelefonSprav(HashMap<String, String> telsprav) {
        this.telsprav = telsprav;
    }

    // получение содержимого справочника
    public HashMap<String, String> getTelsprav() {
        return telsprav;
    }

    // вывод справочника в удобном для чтения виде
    public void infoTtlsprav() {
        System.out.println("ТЕЛЕФОННЫЙ СПРАВОЧНИК");
        System.out.println("---------------------");
        Set<HashMap.Entry<String, String>> set = telsprav.entrySet();
        for (Map.Entry<String, String> abon: set) {
            System.out.println(abon.getValue() + ", тел. " + abon.getKey());
        }
        System.out.println();
    }


    // добавление записи в справочник
    public void add(String fio, String tel) {
        telsprav.put(tel, fio);
    }

    // удаление записи из справочника
    public void del(String tel) { telsprav.remove(tel);}

    // получение телефонных номеров по фамилии
    public void get (String fio) {

        ArrayList<String> telnom = new ArrayList<>();
        Set<HashMap.Entry<String, String>> set = telsprav.entrySet();
        for (Map.Entry<String, String> abon: set) {
            if (fio == abon.getValue())
                telnom.add(abon.getKey());
        }

        System.out.println("На фамилию: " + fio);
        System.out.println("в справочнике есть такие номера телефонов: ");
        System.out.println(telnom);
        System.out.println("-----------");
        System.out.println();
    }

    public String gettel (String fio) {

        String telspis = "";

        ArrayList<String> telnom = new ArrayList<>();
        Set<HashMap.Entry<String, String>> set = telsprav.entrySet();
        int i = 0;
        for (Map.Entry<String, String> abon: set) {
            if (fio.equals(abon.getValue())) {
                if (i==0) {
                    telspis=abon.getKey();
                }
                else {
                    telspis=telspis+"\n"+abon.getKey();
                }
                i++;
            }
        }
        return telspis;
    }


    public TreeSet<String> getabons() {
        TreeSet<String> abons = new TreeSet<>();
        Set<HashMap.Entry<String, String>> set = telsprav.entrySet();
        for (Map.Entry<String, String> abon: set) {
            abons.add(abon.getValue());
        }
        return abons;
    }
}
