package ru.geekbrains.java2.dz_2.dz6;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientListen implements Runnable{
    private Socket sock; // сокет для подключения
    private Scanner in; // сканер для сообшений, отправляемых с клиента
    Thread t; // место для дополнительного потока

    // конструируем поток для прослушки сервера
    public ClientListen(Socket sock) {
        this.sock = sock; // принимаем сокет
        try {
            in = new Scanner(sock.getInputStream()); // подключаем прослушку
        } catch (IOException e) {
            e.printStackTrace();
        }
        t = new Thread(this); // создаем поток
        t.start(); // и запускаем его
    }

    @Override  // описываем наш поток
    public void run() {
        try {
            // слушаем сервер
            while (true) {
                if (in.hasNext()) {
                    String w = in.nextLine();
                    if (w.equalsIgnoreCase("end")) break; //если фразой конца бросил - завершаем
                    System.out.println(w);  // если он прислал что-то - в консоль кидаем
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
