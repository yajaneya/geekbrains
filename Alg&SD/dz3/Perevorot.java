package ru.geekbrains.Alg_SD.dz.dz3;

/*
*** Класс позволяет переворачивать строки ***
Класс использует Дек, с тем же успехом можно было использовать Стек

Поля класса
-----------
private String input; - входящая строка для переворота

Методы класса
-------------
public String go() - осуществляет переворот, возвращает перевернутую строку

*/

public class Perevorot {
    private String input;

    public Perevorot(String input) {
        this.input = input;
    }

    public String go(){
        String out = "";
        Deque dq = new Deque(input.length());
        dq.left = true;
        for (int i=0; i<input.length(); i++)
            dq.insert(input.charAt(i));
        for (int i=0; i<input.length();i++)
            out += (char)dq.remove();
        return out;
    }
}
