package ru.geekbrains.java2.dz_2.dz6;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main (String[] args) {

        // объявляем переменные для нужных нам объектов
        Socket sock = null;
        Scanner in = null;
        PrintWriter out = null;
        try {
            // создаем и устаналиваем сокет для нужного нам сервера
            sock = new Socket("localhost", 9121);

            // подключаем прослушку входящих сообщений от сервера
            new ClientListen(sock);

            // настраиваем прием сообщений для отправки от клиента к серверу
            in = new Scanner(System.in);
            out = new PrintWriter(sock.getOutputStream());

            // получаем сообщения и отправляем их серверу
            while (true) {
                String mess = in.nextLine();
                if (mess.equalsIgnoreCase("end")) break;
                out.println(mess);
                out.flush();
            }

        // это соломка, чтоб легче было падать
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // ну и в завершение
            System.exit(1); // ложимся спать
        }
    }
}
